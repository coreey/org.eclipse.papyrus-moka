/*
 * FMIComponent.h
 *
 *  Created on: Feb 23, 2016
 *      Author: seb
 */

#ifndef INFRA_INCLUDE_ABSTRACTFMICOMPONENT_H_
#define INFRA_INCLUDE_ABSTRACTFMICOMPONENT_H_

#include <inttypes.h>

#include "fmi2FunctionTypes.h"
#include "fmi2TypesPlatform.h"
#include <map>


class AbstractFMIComponent {

protected :
	std::map<int32_t, double>  setRealRequests;
	std::map<int32_t, int32_t>  setIntegerRequests;
	std::map<int32_t, bool>  setBooleanRequests;
	std::map<int32_t, std::string>  setStringRequests;

	std::map<int32_t, double>  responseReals;
	std::map<int32_t, int32_t>  responseIntegers;
	std::map<int32_t, bool>  responseBooleans;
	std::map<int32_t, std::string>  responseStrings;

	double nextDate =-1;
	bool inputChanged =false;


public:

		virtual fmi2Status doStep(fmi2Real currentCommunicationTime, fmi2Real stepSize)=0;
		virtual void terminate()=0;

		virtual void getReal(const fmi2ValueReference valueReference[], size_t numberOfValues,fmi2Real values[]);
		virtual void getInteger(const fmi2ValueReference valueReference[], size_t numberOfValues,fmi2Integer values[]);
		virtual void getBoolean(const fmi2ValueReference valueReference[], size_t numberOfValues,fmi2Boolean values[]);
		virtual void getString(const fmi2ValueReference valueReference[], size_t numberOfValues,fmi2String values[]);

		virtual void setReal(const fmi2ValueReference valueReference[], size_t numberOfValues,const fmi2Real values[]);
		virtual void setInteger(const fmi2ValueReference valueReference[], size_t numberOfValues,const fmi2Integer values[]);
		virtual void setBoolean(const fmi2ValueReference valueReference[], size_t numberOfValues,const fmi2Boolean values[]);
		virtual void setString(const fmi2ValueReference valueReference[], size_t numberOfValues, const fmi2String values[]);

		virtual ~AbstractFMIComponent();


};




#endif /* INFRA_INCLUDE_ABSTRACTFMICOMPONENT_H_ */
