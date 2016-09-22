package com.ihamza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ihamza.domain.Status;
import com.ihamza.exception.AppException;
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

	@RequestMapping(path = "/zip/{zipcode}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "get weather by zip code",

	notes = "<br/>To retrieve weather by zip code enter <br/> " + "for example <URL>/v1.0/weather/zip/10001 <br/>",

	response = WeatherReturn.class, tags = { "RestController", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = WeatherReturn.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = Status.class) })
	public ResponseEntity<?> getWeatherByZIP(@PathVariable(value = "zipcode") String code) {
		try {
			WeatherReturn weatherReturn = service.getWeatherByZIP(code);
			return new ResponseEntity<WeatherReturn>(weatherReturn, HttpStatus.OK);

		} catch (AppException ex) {
			return new ResponseEntity<Status>(ex.getStatus(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 catch (Exception ex) {
		return new ResponseEntity<Status>(new Status("ERR-0000", ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

}
