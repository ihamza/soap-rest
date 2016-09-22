package com.ihamza;

import com.ihamza.soap.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void callSOAP() {
		Weather weather = new Weather();
		WeatherSoap soap = weather.getWeatherSoap();
		//a New York location ZIP code 
		System.out.println(soap.getCityWeatherByZIP("10001"));
	}

}
