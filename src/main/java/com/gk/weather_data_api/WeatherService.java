package com.gk.weather_data_api;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
	
	private final WebClient webClient;

	public WeatherService(WebClient.Builder webClientBuilder) {
		super();
		this.webClient = webClientBuilder.baseUrl("https://api.open-meteo.com").build();
	}
	
	
	public WeatherResponseDTO getWeather(double latitude,double longitude) {
		
		//https://api.open-meteo.com/v1/forecast?latitude=13.08784&longitude=80.27847&current_weather=true
		
		WeatherAPIResponseDTO response=webClient.get().uri( uriBuilder-> 
		uriBuilder.path("/v1/forecast")
		.queryParam("latitude",latitude)
		.queryParam("longitude",longitude)
		.queryParam("current_weather",true).build())
		.retrieve().bodyToMono(WeatherAPIResponseDTO.class).block();
	
		return response.getCurrentWeather();
	}
	
}
