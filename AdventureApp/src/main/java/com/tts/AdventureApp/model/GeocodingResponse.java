package com.tts.AdventureApp.model;

import java.util.List;

public class GeocodingResponse {
    public List<Geocoding> results;
    
    public List<Geocoding> getResults() {
        return results;
    }

    public void setResults(List<Geocoding> results) {
        this.results = results;
    }
    
}