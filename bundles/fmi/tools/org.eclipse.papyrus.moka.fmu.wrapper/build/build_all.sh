#!/bin/bash

# ex : build_all.sh ./org.eclipse.papyrus.moka.fmu.wrapper ./org.eclipse.papyrus.moka.fmu.exporter 
#Path can be absolute or relative


WRAPPER_PROJ=$1
EXPORTER_PROJ=$2

if [[ !("$WRAPPER_PROJ" = /*) ]]; then
WRAPPER_PROJ=$PWD/$WRAPPER_PROJ
fi

if [[ !("$EXPORTER_PROJ" = /*) ]]; then
EXPORTER_PROJ=$PWD/$EXPORTER_PROJ
fi


TMPDIR=`mktemp -d`
echo "compiling in temp directory = $TMPDIR"
LIN32_TMPDIR="$TMPDIR/LIN32"
LIN64_TMPDIR="$TMPDIR/LIN64"
WIN64_TMPDIR="$TMPDIR/WIN64"

mkdir $LIN32_TMPDIR $LIN64_TMPDIR  $WIN64_TMPDIR


LIB_NAME="libfmuwrapper"
COMMON_COMP_OPTS="-DASIO_STANDALONE -pthread -std=c++11 -O3 -Wall -c -fmessage-length=0"
COMMON_LINK_OPTS="-shared -pthread -std=c++11"

INCLUDE="-I$WRAPPER_PROJ/asio/include -I$WRAPPER_PROJ/fmi -I$WRAPPER_PROJ/rapidjson/include -I$WRAPPER_PROJ/fmuwrapper/include"

CPP_INPUTS="$WRAPPER_PROJ/fmuwrapper/src/*.cpp"

LIN64_COMP_OPTS="-fpic"
LIN32_COMP_OPTS="-fpic -m32"
WIN64_COMP_OPTS=" -DASIO_STANDALONE -D__NO_INLINE__ -D_WIN32_WINNT=0x0501"

LIN32_LINK_OPTS="-m32"
LIN64_LINK_OPTS=""
WIN64_LINK_OPTS="-static-libgcc -static-libstdc++"
WIN64_LINK_LIBS="-lws2_32 -static -lpthread"

#LINUX 32 bits compilation
printf "\n\n============Linux 32 compilation============="
cd $LIN32_TMPDIR

COMP_COMMAND_LIN32="g++ $COMMON_COMP_OPTS $LIN32_COMP_OPTS $INCLUDE  $CPP_INPUTS"
printf "\n\n$COMP_COMMAND_LIN32 \n"
$COMP_COMMAND_LIN32

LINK_COMMAND_LIN32="g++ $COMMON_LINK_OPTS $LIN32_LINK_OPTS -o $LIB_NAME.so *.o"
printf "\n\n$LINK_COMMAND_LIN32 \n"
$LINK_COMMAND_LIN32

if [ ! -f $LIB_NAME.so ] 
then
printf "ERROR : failed to compile Linux32 bits FMU Wrapper library \n" 
exit 1
fi

cp -f $LIB_NAME.so $EXPORTER_PROJ/resources/linux32/


#LINUX 64 bits compilation
printf "\n\n============Linux 64 compilation============="

cd $LIN64_TMPDIR
COMP_COMMAND_LIN64="g++ $COMMON_COMP_OPTS $LIN64_COMP_OPTS $INCLUDE  $CPP_INPUTS"
printf "\n\n$COMP_COMMAND_LIN64 \n"
$COMP_COMMAND_LIN64

LINK_COMMAND_LIN64="g++ $COMMON_LINK_OPTS $LIN64_LINK_OPTS -o $LIB_NAME.so *.o"
printf "\n\n$LINK_COMMAND_LIN64 \n"
$LINK_COMMAND_LIN64

if [ ! -f $LIB_NAME.so ] 
then
printf "ERROR : failed to compile Linux64 bits FMU Wrapper library\n" 
exit 1
fi

cp -f $LIB_NAME.so $EXPORTER_PROJ/resources/linux64/

#WINDOWS 64 bits compilation
printf "\n\n============Windows 64 compilation============="

cd $WIN64_TMPDIR
COMP_COMMAND_WIN64="x86_64-w64-mingw32-g++ $COMMON_COMP_OPTS $WIN64_COMP_OPTS $INCLUDE  $CPP_INPUTS"
printf "\n\n$COMP_COMMAND_WIN64"
$COMP_COMMAND_WIN64

LINK_COMMAND_WIN64="x86_64-w64-mingw32-g++ $COMMON_LINK_OPTS $WIN64_LINK_OPTS -o $LIB_NAME.dll *.o $WIN64_LINK_LIBS"
printf "\n\n$LINK_COMMAND_WIN64 \n"
$LINK_COMMAND_WIN64

if [ ! -f $LIB_NAME.dll ] 
then
printf "ERROR : failed to compile Windows 64 bits FMU Wrapper library \n" 
exit 1
fi

cp -f $LIB_NAME.dll $EXPORTER_PROJ/resources/win64/


printf "\n=========================================\n Compilation success! :) \n\n\n"
rm -rf $TMPDIR



