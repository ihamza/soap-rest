package com.ihamza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ihamza.service.WeatherService;
import com.ihamza.soap.WeatherReturn;

@RestController
@RequestMapping(value = "/v1.0/weather", produces = "application/json")
public class WeatherRestController {
	
	@Autowired
	private WeatherService service;
	
	@RequestMapping(path="/zip/{zipcode}" , 
			method = RequestMethod.GET,  produces = "application/json")
 	public WeatherReturn getWeatherByZIP(@PathVariable(value="zipcode") String code) {
	
		return service.getWeatherByZIP(code) ;		 
		 
	 }

}
