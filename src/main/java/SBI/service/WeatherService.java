package SBI.service;

import SBI.model.WeatherResponse;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getHourlyTemperature(double latitude, double longitude) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&hourly=temperature_2m";

        return restTemplate.getForObject(
                url,
                WeatherResponse.class,
                latitude,
                longitude
        );
    }
}


