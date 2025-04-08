package SBI.Controller;

import SBI.model.WeatherResponse;
import SBI.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/hourly")
    public ResponseEntity<WeatherResponse> getHourlyTemperature(
            @RequestParam double lat,
            @RequestParam double lon
    ) {
        WeatherResponse response = weatherService.getHourlyTemperature(lat, lon);
        return ResponseEntity.ok(response);
    }
}
