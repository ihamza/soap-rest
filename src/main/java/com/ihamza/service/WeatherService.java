package com.ihamza.service;

import org.springframework.stereotype.Service;

import com.ihamza.soap.WeatherReturn;

@Service
public class WeatherService {
	
	public WeatherReturn getWeatherByZIP(String zip){
		
		return new WeatherReturn(true,"Magical City Found","NY","New York",
				"White Plains",(short) 15,"N/A","63","87","E7","29.97S","","","");
		
	}

}
