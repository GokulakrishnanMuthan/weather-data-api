package com.gk.weather_data_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAPIResponseDTO {

	@JsonProperty("current_weather")
	private WeatherResponseDTO currentWeather;
	
}
