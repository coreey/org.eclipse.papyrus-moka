/*
 * ThriftFMIComponent.cpp
 *
 *  Created on: Feb 24, 2016
 *      Author: seb
 */

#include "JSONFMIComponent.h"

#include "JSONClient.h"
#include <iostream>
#include <stdint.h>

const char* JSONFMIComponent::REQ_STEP__CURRENT_TIME= "t";
const char* JSONFMIComponent::REQ_STEP__STEP_SIZE = "h";
const char* JSONFMIComponent::REQ_STEP= "step";
const char* JSONFMIComponent::REQ_INIT="ini";
const char* JSONFMIComponent::REQ_TERMINATE= "ter";

const char* JSONFMIComponent::REQ_STEP__INTVRS= "iv";
const char* JSONFMIComponent::REQ_STEP__BOOLVRS= "bv";
const char* JSONFMIComponent::REQ_STEP__DOUBLEVRS= "dv";
const char* JSONFMIComponent::REQ_STEP__STRINGVRS= "sv";

const char* JSONFMIComponent::REQ_STEP__INT= "i";
const char* JSONFMIComponent::REQ_STEP__BOOL= "b";
const char* JSONFMIComponent::REQ_STEP__DOUBLE= "d";
const char* JSONFMIComponent::REQ_STEP__STRING= "s";



const char* JSONFMIComponent::RESP_STATUS= "r";
const char* JSONFMIComponent::RESP_NEXT_DATE= "nd";


JSONFMIComponent::JSONFMIComponent():client(), response()

{

}


int JSONFMIComponent::init(const char * fmuResourceLocation){
	int status =  client.init(fmuResourceLocation);
	if (status == 0){
			rapidjson::Document request;
			request.SetObject();
			rapidjson::Document::AllocatorType& allocator=request.GetAllocator() ;

			rapidjson::Value init(true);
			request.AddMember(rapidjson::StringRef(REQ_INIT), init, allocator);
			client.sendRequest(request, response);
			handleResponse();
	}
	return status;
}


JSONFMIComponent::~JSONFMIComponent() {

}

fmi2Status  JSONFMIComponent::doStep(fmi2Real currentCommunicationTime, fmi2Real stepSize){
	fmi2Status status = fmi2OK;
	if ( inputChanged|| ((currentCommunicationTime+ stepSize)> nextDate)){
		inputChanged = false;
		rapidjson::Document request;
		request.SetObject();
		rapidjson::Document::AllocatorType& allocator=request.GetAllocator() ;



		rapidjson::Value communicationTimeValue(currentCommunicationTime);
		rapidjson::Value stepSizeValue(stepSize);


		request.AddMember(rapidjson::StringRef(REQ_STEP__CURRENT_TIME), communicationTimeValue, allocator);
		request.AddMember(rapidjson::StringRef(REQ_STEP__STEP_SIZE), stepSizeValue, allocator);


		if (!setBooleanRequests.empty()){
			rapidjson::Value boolVR(rapidjson::kArrayType);
			rapidjson::Value bools(rapidjson::kArrayType);
			for( std::map<int,bool>::iterator iterator = setBooleanRequests.begin(); iterator != setBooleanRequests.end(); iterator++) {
				boolVR.PushBack(iterator->first, allocator);
				bools.PushBack(iterator->second, allocator);
			}
			setBooleanRequests.clear();
			request.AddMember(rapidjson::StringRef(REQ_STEP__BOOLVRS), boolVR, allocator);
			request.AddMember(rapidjson::StringRef(REQ_STEP__BOOL), bools, allocator);
		}

		if (!setRealRequests.empty()){
			rapidjson::Value realVR(rapidjson::kArrayType);
			rapidjson::Value reals(rapidjson::kArrayType);
			for( std::map<int,double>::iterator iterator = setRealRequests.begin(); iterator != setRealRequests.end(); iterator++) {
				realVR.PushBack(iterator->first, allocator);
				reals.PushBack(iterator->second, allocator);
			}
			setRealRequests.clear();
			request.AddMember(rapidjson::StringRef(REQ_STEP__DOUBLEVRS), realVR, allocator);
			request.AddMember(rapidjson::StringRef(REQ_STEP__DOUBLE), reals, allocator);

		}
		if (!setIntegerRequests.empty()){
			rapidjson::Value intVR(rapidjson::kArrayType);
			rapidjson::Value ints(rapidjson::kArrayType);
			for( std::map<int,int>::iterator iterator = setIntegerRequests.begin(); iterator != setIntegerRequests.end(); iterator++) {
				intVR.PushBack(iterator->first, allocator);
				ints.PushBack(iterator->second, allocator);
			}
			setIntegerRequests.clear();
			request.AddMember(rapidjson::StringRef(REQ_STEP__INTVRS),intVR, allocator);
			request.AddMember(rapidjson::StringRef(REQ_STEP__INT), ints, allocator);
		}
		if (!setStringRequests.empty()){
			rapidjson::Value stringVR(rapidjson::kArrayType);
			rapidjson::Value strings(rapidjson::kArrayType);
			for( std::map<int,std::string>::iterator iterator = setStringRequests.begin(); iterator != setStringRequests.end(); iterator++) {
				stringVR.PushBack(iterator->first, allocator);
				rapidjson::Value value;
				value.SetString(iterator->second.c_str(),allocator);
				strings.PushBack(value, allocator);
			}
			setStringRequests.clear();
			request.AddMember(rapidjson::StringRef(REQ_STEP__STRINGVRS),stringVR, allocator);
			request.AddMember(rapidjson::StringRef(REQ_STEP__STRING), strings, allocator);
		}




		 client.sendRequest(request, response);


		status = handleResponse();
	}
	return status;

}



void  JSONFMIComponent::terminate(){
	rapidjson::Document request;
	request.SetObject();
	rapidjson::Document::AllocatorType& allocator=request.GetAllocator() ;

	rapidjson::Value terminate(true);
	request.AddMember(rapidjson::StringRef(REQ_TERMINATE), terminate, allocator);
	client.nonBlockingSendRequest(request,response );
	if (client.getRcpThread().joinable()){
		client.getRcpThread().join();
	}

}

fmi2Status  JSONFMIComponent::handleResponse(){

	if (response.HasMember(rapidjson::StringRef(REQ_STEP__BOOL))){
		const rapidjson::Value& boolVRs = response[REQ_STEP__BOOLVRS];
		const rapidjson::Value& bools = response[REQ_STEP__BOOL];

		for (rapidjson::SizeType i = 0; i < boolVRs.Size(); i++) {
			responseBooleans[boolVRs[i].GetInt()]= bools[i].GetBool();
		}
	}

	if (response.HasMember(rapidjson::StringRef(REQ_STEP__DOUBLE))){
		const rapidjson::Value& doubleVRs = response[REQ_STEP__DOUBLEVRS];
		const rapidjson::Value& doubles = response[REQ_STEP__DOUBLE];

		for (rapidjson::SizeType i = 0; i < doubleVRs.Size(); i++) {
			responseReals[doubleVRs[i].GetInt()]= doubles[i].GetDouble();
		}
	}

	if (response.HasMember(rapidjson::StringRef(REQ_STEP__INT))){
		const rapidjson::Value& intVRs = response[REQ_STEP__INTVRS];
		const rapidjson::Value& ints = response[REQ_STEP__INT];

		for (rapidjson::SizeType i = 0; i < intVRs.Size(); i++) {
			responseIntegers[intVRs[i].GetInt()]= ints[i].GetInt();
		}
	}


	if (response.HasMember(rapidjson::StringRef(REQ_STEP__STRING))  && response.HasMember(rapidjson::StringRef(REQ_STEP__STRINGVRS)) ){
		const rapidjson::Value& stringVRs = response[REQ_STEP__STRINGVRS];
		const rapidjson::Value& strings = response[REQ_STEP__STRING];

		//
		if (strings.IsArray()){
			for (rapidjson::SizeType i = 0; i < stringVRs.Size(); i++) {
						responseStrings[stringVRs[i].GetInt()]= strings[i].GetString();
			}
		}

	}

	if (response.HasMember(rapidjson::StringRef(RESP_NEXT_DATE))) {
		const rapidjson::Value& nextDateValue = response[RESP_NEXT_DATE];
		if (nextDateValue.IsDouble()){
			nextDate = nextDateValue.GetDouble();
		}
	}else {
		//if we didn't receive a next date new value, if means that either  Moka simulation is finished
		//either there are only change event. We won't need to make further do step if inputs don't change
		 nextDate = std::numeric_limits<double>::max();
	}

	if (response.HasMember(rapidjson::StringRef(RESP_STATUS))) {
		//TODO complete status parsing
	}
	return fmi2Status::fmi2OK;


}

