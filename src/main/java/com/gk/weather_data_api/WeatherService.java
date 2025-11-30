package com.gk.weather_data_api;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
	
	private final WebClient weatherWebClient;
	private final WebClient geoWebClient;

		
	public WeatherService(WebClient weatherWebClient, WebClient geoWebClient) {
		super();
		this.weatherWebClient = weatherWebClient;
		this.geoWebClient = geoWebClient;
	}

	public GeoCodingResponseDTO.Location getCoordinates(String location) {
		GeoCodingResponseDTO response = geoWebClient.get().uri( uriBuilder->
		uriBuilder.path("/v1/search")
		.queryParam("name",location)
		.queryParam("count",1)
		.queryParam("language","en").build())
		.retrieve().bodyToMono(GeoCodingResponseDTO.class).block();
		return (response !=null & !response.getResults().isEmpty()) ? response.getResults().get(0) : null;
	}

	public WeatherResponseDTO getWeather(String location) {
			
		GeoCodingResponseDTO.Location coordinates = getCoordinates(location);
		if(coordinates ==null) {
			return null;
		}
		
		//https://api.open-meteo.com/v1/forecast?latitude=13.08784&longitude=80.27847&current_weather=true
	
		WeatherAPIResponseDTO response=weatherWebClient.get().uri( uriBuilder-> 
		uriBuilder.path("/v1/forecast")
		.queryParam("latitude",coordinates.getLatitude())
		.queryParam("longitude",coordinates.getLongitude())
		.queryParam("current_weather",true).build())
		.retrieve().bodyToMono(WeatherAPIResponseDTO.class).block();
		
		WeatherResponseDTO weatherResponse=response.getCurrentWeather();
		
		weatherResponse.setWeatherDescription(getWeatherDescription(Integer.parseInt(weatherResponse.getWeatherCode())));
		weatherResponse.setWeatherIcon(getWeatherIcon(Integer.parseInt(weatherResponse.getWeatherCode())));
		
		
		return response.getCurrentWeather();
	}
	
	
	//Map weather code to description
	private String getWeatherDescription(int code) {
		
		Map<Integer, String> weatherMap = Map.ofEntries(
				 Map.entry(0, "Clear sky"),
			        Map.entry(1, "Mainly clear"),
			        Map.entry(2, "Partly cloudy"),
			        Map.entry(3, "Overcast"),
			        Map.entry(45, "Fog"),
			        Map.entry(48, "Depositing rime fog"),
			        Map.entry(51, "Light drizzle"),
			        Map.entry(53, "Moderate drizzle"),
			        Map.entry(55, "Dense drizzle"),
			        Map.entry(61, "Slight rain"),
			        Map.entry(63, "Moderate rain"),   // your case
			        Map.entry(65, "Heavy rain"),
			        Map.entry(71, "Slight snow fall"),
			        Map.entry(73, "Moderate snow fall"),
			        Map.entry(75, "Heavy snow fall"),
			        Map.entry(95, "Thunderstorm"),
			        Map.entry(96, "Thunderstorm with slight hail"),
			        Map.entry(99, "Thunderstorm with heavy hail")


			   );

		return  weatherMap.getOrDefault(code, "Unknown Weather code");
	}
	
	//get weather code to icon
	private String getWeatherIcon(int code) {
		 Map<Integer, String> weatherIconMap = Map.ofEntries(
				   	Map.entry(0, "☀️"),   // Clear sky
			        Map.entry(1, "🌤️"),   // Mainly clear
			        Map.entry(2, "⛅"),    // Partly cloudy
			        Map.entry(3, "☁️"),   // Overcast
			        Map.entry(45, "🌫️"),  // Fog
			        Map.entry(48, "🌫️❄️"), // Depositing rime fog
			        Map.entry(51, "🌦️"),  // Light drizzle
			        Map.entry(53, "🌦️"),  // Moderate drizzle
			        Map.entry(55, "🌧️"),  // Dense drizzle
			        Map.entry(61, "🌦️"),  // Slight rain
			        Map.entry(63, "🌧️"),  // Moderate rain
			        Map.entry(65, "🌧️🌧️"), // Heavy rain
			        Map.entry(71, "🌨️"),  // Slight snow fall
			        Map.entry(73, "❄️"),   // Moderate snow fall
			        Map.entry(75, "❄️❄️"), // Heavy snow fall
			        Map.entry(95, "⛈️"),   // Thunderstorm
			        Map.entry(96, "⛈️🌨️"), // Thunderstorm with slight hail
			        Map.entry(99, "⛈️❄️❄️") // Thunderstorm with heavy hail


			    );
		 return weatherIconMap.getOrDefault(code, "unknown");
		 }
	
}
