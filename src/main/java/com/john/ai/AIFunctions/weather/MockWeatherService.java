package com.john.ai.AIFunctions.weather;

import java.util.function.Function;

public class MockWeatherService implements Function<MockWeatherService.Request, MockWeatherService.Response> {

    @Override
    public Response apply(Request t) {
        System.out.println("MockWeatherService called with location: "+t.location());
        if(t.location().equalsIgnoreCase("STOCKHOLM")) 
        return new Response(1.0, "C");
        else if(t.location().equalsIgnoreCase("CHENNAI"))
        return new Response(30.0, "C");
        else
        return new Response(10.0, "C");
    }

    public record Request(String location) {}
    public record Response(double temp, String unit) {}
}
