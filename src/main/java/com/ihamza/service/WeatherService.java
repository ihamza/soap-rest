package com.ihamza.service;

import org.springframework.stereotype.Service;

import com.ihamza.soap.Weather;
import com.ihamza.soap.WeatherReturn;
import com.ihamza.soap.WeatherSoap;

@Service
public class WeatherService {
	
	public WeatherReturn getWeatherByZIP(String zip){
		
		Weather weather = new Weather();
		WeatherSoap soap = weather.getWeatherSoap();
		return soap.getCityWeatherByZIP(zip);
		
	}

}
