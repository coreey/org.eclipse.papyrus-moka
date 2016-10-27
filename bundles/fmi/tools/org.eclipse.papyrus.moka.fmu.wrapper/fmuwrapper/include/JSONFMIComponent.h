/*
 * JSONFMIComponent.h
 *
 *  Created on: Feb 24, 2016
 *      Author: seb
 */

#ifndef JSON_INCLUDE_JSONFMICOMPONENT_H_
#define JSON_INCLUDE_JSONFMICOMPONENT_H_


#include <AbstractFMIComponent.h>
#include "JSONClient.h"
#include "rapidjson/rapidjson.h"
#include "rapidjson/document.h"



class JSONFMIComponent : AbstractFMIComponent {


private :
	JSONClient client;

	static const char* REQ_STEP__CURRENT_TIME;
	static const char* REQ_STEP__STEP_SIZE;
	static const char* REQ_STEP;
	static const char* REQ_INIT;
	static const char* REQ_TERMINATE;

	static const char* REQ_STEP__INTVRS;
	static const char* REQ_STEP__BOOLVRS;
	static const char* REQ_STEP__DOUBLEVRS;
	static const char* REQ_STEP__STRINGVRS;

	static const char* REQ_STEP__INT;
	static const char* REQ_STEP__BOOL;
	static const char* REQ_STEP__DOUBLE;
	static const char* REQ_STEP__STRING;

	static const char* RESP_STATUS;
	static const char* RESP_NEXT_DATE;

	rapidjson::Document response;

public:
	JSONFMIComponent();
	virtual ~JSONFMIComponent();

	int init(const char * fmuResourceLocation);
	fmi2Status doStep(fmi2Real currentComunicationTime, fmi2Real stepSize);
	void terminate();

private:
	fmi2Status  handleResponse();



};

#endif /*JSON_INCLUDE_JSONFMICOMPONENT_H_*/
