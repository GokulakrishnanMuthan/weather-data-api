package com.gk.weather_data_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	
	private  final WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		super();
		this.weatherService = weatherService;
	}
		
	@GetMapping
	public WeatherResponseDTO getWeather(@RequestParam double lat, @RequestParam  double lon) {
		return weatherService.getWeather(lat, lon);
	}

}
