package com.ihamza.service;

import javax.xml.ws.WebServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihamza.domain.History;
import com.ihamza.domain.Status;
import com.ihamza.exception.AppException;
import com.ihamza.repository.HistoryRepository;
import com.ihamza.soap.Weather;
import com.ihamza.soap.WeatherReturn;
import com.ihamza.soap.WeatherSoap;

@Service
public class WeatherService {

	@Autowired
	private HistoryRepository historyRepository;
	
	
	public WeatherReturn getWeatherByZIP(String zip){
		
		History history;
		Weather weather ;
		WeatherSoap soap ;
		WeatherReturn weatherReturn;
		try {
		weather = new Weather();	
		soap = weather.getWeatherSoap();	
		weatherReturn  =soap.getCityWeatherByZIP(zip);
		history = new History(zip, weatherReturn.toString());
		historyRepository.save(history);
		}
		catch (WebServiceException ex){
			history = new History(zip, ex.getMessage());
			historyRepository.save(history);
			throw new AppException(new Status("ERR-0001","Unable to Connect to Weather Webservice"),ex);
		}
		return weatherReturn;
	}

}
