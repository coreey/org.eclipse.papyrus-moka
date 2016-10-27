/*
 * FMIComponent.cpp
 *
 *  Created on: Feb 23, 2016
 *      Author: seb
 */

#include <AbstractFMIComponent.h>


AbstractFMIComponent::~AbstractFMIComponent(){}

//fmi2Status AbstractFMIComponent::doStep(fmi2Real currentCommunicationTime, fmi2Real stepSize){
//	return fmi2Error;
//};
//
//void AbstractFMIComponent::terminate(){
//}

void AbstractFMIComponent::getReal(const fmi2ValueReference valueReference[], size_t numberOfValues,fmi2Real values[]){

	for (unsigned int index = 0; index < numberOfValues; index++) {
		if (responseReals.find(valueReference[index]) != responseReals.end()){
			values[index] = responseReals[valueReference[index]];
		}
	}
}
void AbstractFMIComponent::getInteger(const fmi2ValueReference valueReference[], size_t numberOfValues,fmi2Integer values[]){
	for (unsigned int index = 0; index < numberOfValues; index++) {
		if (responseIntegers.find(valueReference[index]) != responseIntegers.end()){
			values[index] = responseIntegers[valueReference[index]];
		}
	}
}
void AbstractFMIComponent::getBoolean(const fmi2ValueReference valueReference[], size_t numberOfValues,fmi2Boolean values[]){
	for ( unsigned int index = 0; index < numberOfValues; index++) {
		if (responseBooleans.find(valueReference[index]) != responseBooleans.end()){
			values[index] = responseBooleans[valueReference[index]];
		}
	}
}
void AbstractFMIComponent::getString(const fmi2ValueReference valueReference[], size_t numberOfValues,fmi2String values[]){
	for ( unsigned int index = 0; index < numberOfValues; index++) {
		if (responseStrings.find(valueReference[index]) != responseStrings.end()){
			values[index] = responseStrings[valueReference[index]].c_str();
		}
	}
}

void AbstractFMIComponent::setReal(const fmi2ValueReference valueReference[], size_t numberOfValues,const fmi2Real values[]){
	for (unsigned int index = 0; index < numberOfValues; index++) {
		setRealRequests[valueReference[index]] = values[index];
	}
	inputChanged = true;
}
void AbstractFMIComponent::setInteger(const fmi2ValueReference valueReference[], size_t numberOfValues,const fmi2Integer values[]){
	for (unsigned int index = 0; index < numberOfValues; index++) {
		setIntegerRequests[valueReference[index]] = values[index];
	}
	inputChanged = true;
}
void AbstractFMIComponent::setBoolean(const fmi2ValueReference valueReference[], size_t numberOfValues,const fmi2Boolean values[]){
	for (unsigned int index = 0; index < numberOfValues; index++) {
		setBooleanRequests[valueReference[index]] = values[index];
	}
	inputChanged = true;
}
void AbstractFMIComponent::setString(const fmi2ValueReference valueReference[], size_t numberOfValues, const fmi2String values[]){
	for (unsigned int index = 0; index < numberOfValues; index++) {
		setStringRequests[valueReference[index]] = values[index];
	}
	inputChanged = true;
}

