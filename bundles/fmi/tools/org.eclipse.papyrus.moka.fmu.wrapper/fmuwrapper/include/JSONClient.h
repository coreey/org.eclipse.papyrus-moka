/*
 * JSONClient.h
 *
 *  Created on: Mar 24, 2016
 *      Author: seb
 */

#ifndef JSON_INCLUDE_JSONCLIENT_H_
#define JSON_INCLUDE_JSONCLIENT_H_

#include "asio.hpp"
#include "rapidjson/rapidjson.h"
#include "rapidjson/document.h"

#include <memory>
#include <thread>

class JSONClient {

private  :



	std::thread * rcpThread;
	asio::io_service io_service;
	asio::ip::tcp::socket socket;

	char  hugeStaticBuff[1048576];
	std::string replaceAll(std::string str, const std::string& from, const std::string& to);



public:




	JSONClient();
	virtual ~JSONClient();

	int init(const char * fmuResourceLocation);
	void sendRequest(rapidjson::Document& request, 	rapidjson::Document& response);
	void nonBlockingSendRequest(rapidjson::Document& request,rapidjson::Document& response);
	std::thread& getRcpThread();



};

#endif /* JSON_INCLUDE_JSONCLIENT_H_ */
