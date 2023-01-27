#!/bin/bash

###############################################################################
# Copyright (c) 2012-2023 CEA LIST and others.
#
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License 2.0
# which accompanies this distribution, and is available at
# https://www.eclipse.org/legal/epl-2.0/
#
# SPDX-License-Identifier: EPL-2.0
#
# Contributors:
# Nicolas Bros (Mia-Software) - Initial API and implementation
# Quentin Le menez (CEA LIST) - Support for the new Papyrus architecture
# Ansgar Radermacher (CEA LIST) - Adaptation to Papyrus relatives/components
# Pauline Deville (CEA LIST) - Adapt to the new architecture
# Pauline Deville (CEA LIST) - Adapt for Moka
#
###############################################################################

sshGenie="genie.papyrus"
sshRemote="projects-storage.eclipse.org"

UPDATE_SITES_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/components/$componentName
PAPYRUS_CMPDWL=https://download.eclipse.org/modeling/mdt/papyrus/components/

P2URL="https://ci.eclipse.org/papyrus/view/Moka/job/papyrus-moka-master/lastSuccessfulBuild/artifact/releng/org.eclipse.papyrus.moka.p2/target/repository/*zip*"
RCPURL="https://ci.eclipse.org/papyrus/job/$buildJob/$buildId/artifact/products/*zip*"

# enable the job defined parameters
#env >/dev/null

########### Set Access Rights ###########
# This function sets the access rights to allow all members of the group to edit the files
function setAccessRights() {
  ssh $sshGenie@$sshRemote chmod -R 775 "$1"
  ssh $sshGenie@$sshRemote chgrp -hR modeling.mdt.papyrus "$1"
}

########### Get Zip ###########
# This function fetches and test the zip
function getZip() {
  _zipName=$1
  _jenkinsBaseURL=$2

  [[ "$_zipName" =~ ^.*?\.zip$ ]] || { echo "incorrect parameter: zipName"; exit 1; }

  # Use the Jenkins REST API
  # see https://www.jenkins.io/doc/book/using/remote-access-api/
  wget --no-check-certificate "$_jenkinsBaseURL/${_zipName}"
  if [ ! -f "$_zipName" ]; then echo "ERROR: $_zipName (from Jenkins) not found"; exit -2; fi
  echo "[$(date +%Y%m%d-%H%M)] Testing zip integrity"
  unzip -t "$_zipName"
}

########### Clean Composites ###########
# This function cleans local job composite if necessary
function cleancompositesandreadme () {
  if [ -f compositeArtifacts.xml ] ; then
    rm -f compositeArtifacts.xml
  fi
  if [ -f compositeContent.xml ] ; then
    rm -f compositeContent.xml
  fi
  if [ -f readme.md ] ; then
    rm -f readme.md
  fi
}

########### Exists ###########
# For some reasons the job can't state '-f' or '-d' queries on the server
# Those queries seem to be limited to the job workspace
function folderexists () {
  declare -a releasefolders=($(ssh $sshGenie@$sshRemote find "$1" -maxdepth 1 -type d | while read folder; do echo "$folder"; done))
  for child in "${releasefolders[@]}" ; do
    #echo -e "$child\n$2"
    if [ "$child" = "$2" ]; then
      return 1
    fi
  done
  return 0
}
function fileexists () {
  declare -a releasefiles=($(ssh $sshGenie@$sshRemote find "$1" -maxdepth 1 -type f | while read file; do echo "$file"; done))
  for child in "${releasefiles[@]}" ; do
    #echo -e "$child\n$2"
    if [ "$child" = "$2" ]; then
      return 1
    fi
  done
  return 0
}

# ============================== USER PARAMETERS ==============================
echo "-------------------- check parameters --------------------"
if [[ ! ("$buildId" =~ ^[0-9]+$ || "$buildId" < 1) && (! $buildId =~ "lastSuccessfulBuild") ]]; then
    echo "buildId (CI build from which to publish the plug-ins) must be a integer (only digits) or lastSuccessfulBuild"
    echo "Canceled."; exit 1
fi

echo "-------------------- initialized parameters --------------------"
echo "componentName: $componentName"
echo "buildId: $buildId"
echo "version: $version"
echo "buildJob: $buildJob"
echo "eclipseTarget: $eclipseTarget"
echo "overwrite: $overwrite"
echo "publishRCP: $publishRCP"
echo "publishP2: $publishP2"

# from now on, display executed commands
set -x

dirBefore=$(pwd)
echo "[$DATE] creating working dir"
workingDir=$(mktemp -d)
cd "$workingDir"
releasesDir=$UPDATE_SITES_DIR/releases
releaseDir=$releasesDir/$version

########### Publish RCP ###########
if [ "$publishRCP" = "y" ]; then
# ========================== fetch zip of all RCPs ================================
  rcpDir=$releaseDir/rcps
  folderexists $releasesDir $releaseDir
  if [[ $? != 0 ]]; then
    if  [ "$overwrite" != "y" ]; then
      echo "The RCP already exists under: ${rcpDir}, canceling job."; exit 1
    fi
    echo "Overwrite set to true, replacing published rcp."
  fi

  echo fetching RCPs
  zipName="products.zip"
  getZip "$zipName" "$RCPURL"
  if [ ! -f "$zipName" ]; then 
    echo "ERROR: $zipName (from CI server) not found"; 
    exit -2; 
  fi
  ls -la
  ssh $sshGenie@$sshRemote rm -fr "$rcpDir"

# ============================== publish RCPs =====================================
  echo "publishing RCPs (version='$version') to directory '$rcpDir'"
  ssh $sshGenie@$sshRemote mkdir -p "$rcpDir"
  scp $zipName $sshGenie@$sshRemote:/$rcpDir
  ssh $sshGenie@$sshRemote unzip -o "$rcpDir/$zipName" -d "$rcpDir"
  ssh $sshGenie@$sshRemote rm -f "$rcpDir/$zipName"
  rm -f $zipName
fi

########### Publish P2 ###########
if [ "$publishP2" = "y" ]; then
# ============================ fetch update site ==================================
  p2Dir=$releaseDir/p2
  folderexists $releasesDir $releaseDir
  if [[ $? != 0 ]]; then
    if  [ "$overwrite" != "y" ]; then
      echo "The update site already exists under: ${p2Dir}, canceling job."; exit 1
    fi
    echo "Overwrite set to true, replacing published p2."
  fi
  ssh $sshGenie@$sshRemote rm -fr "$p2Dir"

  echo fetching update-site
  zipName="updatesite.zip"
  getZip "$zipName" "$P2URL"
  if [ ! -f "$zipName" ]; then 
    echo "ERROR: $zipName (from CI server) not found"; 
    exit -2; 
  fi
  ls -la

# ============================== PUBLISH update site ==============================
  echo "publishing version='$version' to the repository directory '$p2Dir'..."
  ssh $sshGenie@$sshRemote mkdir -p "$p2Dir"
  scp $zipName $sshGenie@$sshRemote:/$p2Dir
  ssh $sshGenie@$sshRemote unzip -o "$p2Dir/$zipName" -d "$p2Dir"
  ssh $sshGenie@$sshRemote mv "$p2Dir/repository/*" "$p2Dir"
  ssh $sshGenie@$sshRemote rmdir "$p2Dir/repository/"
  ssh $sshGenie@$sshRemote rm -f "$p2Dir/$zipName"
  rm -f $zipName
fi

########### Publish Composites ###########
# Create eclipse target directory
eclipseTargetDir=$UPDATE_SITES_DIR/$eclipseTarget
ssh $sshGenie@$sshRemote mkdir -p "$eclipseTargetDir"
# Clean generated files
cleancompositesandreadme

# Create the composite files
if [ "$publishP2" = "y" ]; then
  newTimeStamp=$(date +%s000)
  p2relativeDir="location=\"../releases/${version}/p2\"/>"
  compArt=$eclipseTargetDir/compositeArtifacts.xml

  fileexists $eclipseTargetDir $compArt
  if [ $? != 0 ]; then
    # If there are existing composites, count existing children and add their location to an array
    childCount=$(($(ssh $sshGenie@$sshRemote grep -sE "child\ location" $compArt | wc -l)+1))
    childArray=($(ssh $sshGenie@$sshRemote grep -s "location=" $compArt | sed -s "s/<child //" | sed "s/'/\"/g"))
	# Detect already present directories and decrement if necessary
    for child in "${childArray[@]}" ; do
      if [ "$child" = "$p2relativeDir" ]; then
        alreadyExists=true
        ((childCount=childCount-1))
      fi
    done
  else
    # New composite, hence there are only one child
    childCount=1
	childArray=()
  fi
  cat > compositeArtifacts.xml <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<repository name="Papyrus-$componentName" type="org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository" version="1.0.0">
  <properties size="1">
    <property name="p2.timestamp" value="${newTimeStamp}"/>
  </properties>
  <children size="${childCount}">$(
	for child in "${childArray[@]}" ; do
      printf "\n    <child $child"
    done
    )$(
    if [[ -z ${alreadyExists+x} ]] ; then
      printf "\n    <child $p2relativeDir"
    fi
    )
  </children>
</repository>
EOF
  scp compositeArtifacts.xml $sshGenie@$sshRemote:$eclipseTargetDir/compositeArtifacts.xml

  compCont=$eclipseTargetDir/compositeContent.xml
  fileexists $eclipseTargetDir $compCont
  if [ -f $compCont ]; then
    # The children and their location should be the same as the compositeArtifacts
	:
  else
    # The children and their location should be the same as the compositeArtifacts
	:
  fi
  cat > compositeContent.xml <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<repository name="Papyrus-$componentName" type="org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository" version="1.0.0">
  <properties size="1">
    <property name="p2.timestamp" value="${newTimeStamp}"/>
  </properties>
  <children size="${childCount}">$(
	for child in "${childArray[@]}" ; do
      printf "\n    <child $child"
    done
    )$(
    if [[ -z ${alreadyExists+x} ]] ; then
      printf "\n    <child $p2relativeDir"
    fi
    )
  </children>
</repository>
EOF
  scp compositeContent.xml $sshGenie@$sshRemote:$eclipseTargetDir/compositeContent.xml

fi

echo "# Welcome to the $eclipseTarget release of $componentName
## P2 repository
If there is an update site associated to this release, it can be found in the **p2** folder at:
$PAPYRUS_CMPDWL/$componentName/releases/$version

## RCP files
If there are RCP files associated to this release, they can be found in the **rcps** folder at:
$PAPYRUS_CMPDWL/$componentName/releases/$version" > readme.md
scp readme.md $sshGenie@$sshRemote:$eclipseTargetDir

setAccessRights "$UPDATE_SITES_DIR"
echo "publishing done."