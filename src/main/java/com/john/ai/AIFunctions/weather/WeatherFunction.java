package com.john.ai.AIFunctions.weather;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class WeatherFunction {

    @Bean
	@Description("Get the weather in location")
	public Function<MockWeatherService.Request, MockWeatherService.Response> currentWeather() {
		return new MockWeatherService();
	}

}
