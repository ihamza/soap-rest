package com.ihamza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihamza.domain.History;
import com.ihamza.repository.HistoryRepository;
import com.ihamza.soap.Weather;
import com.ihamza.soap.WeatherReturn;
import com.ihamza.soap.WeatherSoap;

@Service
public class WeatherService {

	@Autowired
	private HistoryRepository historyRepository;
	
	
	public WeatherReturn getWeatherByZIP(String zip){
		
		Weather weather = new Weather();
		WeatherSoap soap = weather.getWeatherSoap();		
		WeatherReturn weatherReturn  =soap.getCityWeatherByZIP(zip);		
		historyRepository.save(new History(zip, weatherReturn.toString()));
		return weatherReturn;
	}

}
