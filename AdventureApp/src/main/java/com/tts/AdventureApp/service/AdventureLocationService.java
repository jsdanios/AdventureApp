package com.tts.AdventureApp.service;

import java.util.Random;

import com.tts.AdventureApp.model.GeocodingResponse;
import com.tts.AdventureApp.model.Location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdventureLocationService {
    @Value("${geocoding_url}")
    public String geocodingUrl;

    @Value("${google_api_key}")
    public String googleApiKey;

    public Location getCoordinates(String description) {
        description = description.replace(" ", "+");
        description = description.replace(",", "");
        String url = geocodingUrl + description + "&key=" + googleApiKey;
        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        Location location = response.results.get(0).geometry.location;
        return location;
    }

    public static Location getRandomLocation(double x0, double y0, int radius) {
        Random random = new Random();
        Location location = new Location();
    
        // Convert radius from meters to degrees
        double radiusInDegrees = radius / 111000f;
    
        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);
    
        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(Math.toRadians(y0));
    
        double foundLongitude = new_x + x0;
        double foundLatitude = y + y0;
        location.setLng(String.valueOf(foundLongitude));
        location.setLat(String.valueOf(foundLatitude));
        return location;
    }
    
}