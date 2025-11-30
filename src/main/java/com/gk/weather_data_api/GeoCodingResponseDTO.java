package com.gk.weather_data_api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCodingResponseDTO {

	private List<Location> results;
	
	@Data
	public static class Location{
		private double latitude;
		private double longitude;
	}
	
}
