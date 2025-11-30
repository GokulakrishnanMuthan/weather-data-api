package com.gk.weather_data_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	

	// get weather data
	//https://api.open-meteo.com/v1/forecast?latitude=13.08784&longitude=80.27847&current_weather=true
	@Bean
	public WebClient weatherWebClient(WebClient.Builder webClientBuilder) {
		 return webClientBuilder.baseUrl("https://api.open-meteo.com").build();
	}
	
	//get lat and long using location
	//https://geocoding-api.open-meteo.com/v1/search?name=Chennai&count=1&language=en
	@Bean
	public WebClient geoWebClient(WebClient.Builder webClientBuilder) {
		 return webClientBuilder.baseUrl("https://geocoding-api.open-meteo.com").build();
	}
	
}
