package com.ihamza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ihamza.service.WeatherService;
import com.ihamza.soap.WeatherReturn;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1.0/weather", produces = "application/json")
public class WeatherRestController {
	
	@Autowired
	private WeatherService service;
	
	@RequestMapping(path="/zip/{zipcode}" , 
			method = RequestMethod.GET,  produces = "application/json")
	@ApiOperation(value = "get weather by zip code", 
	
	notes = "<br/>To retrieve weather by zip code enter <br/> "
			+ "for example <URL>/v1.0/weather/zip/10001 <br/>", 
	
	response = WeatherReturn.class, tags = {
			"RestController", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = WeatherReturn.class)
			//,@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = Exception.class) 
			})			
 	public WeatherReturn getWeatherByZIP(@PathVariable(value="zipcode") String code) {
	
		return service.getWeatherByZIP(code) ;		 
		 
	 }

}
