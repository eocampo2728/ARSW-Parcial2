/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.model.Country;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Ocampo
 */
@Service
public class CoronavirusService {
    
    private Gson gson;
    
    public List<Country> getAllCountries(){
        gson = new Gson();
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "f0ac279634mshfb892495e463495p1334bajsn9a3c972b3eaa")
                    .asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(CoronavirusService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gson = new GsonBuilder().create();
        JSONArray allCountries = response.getBody().getObject().getJSONObject("data").getJSONArray("coronavirusStats");
        List<Country> stats = gson.fromJson(allCountries.toString(),new TypeToken<List<Country>>(){}.getType());
        return stats;
    }
    
    public List<Country> getCountryByName(String country){
        gson = new Gson();
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+country)
            .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
            .header("x-rapidapi-key", "f0ac279634mshfb892495e463495p1334bajsn9a3c972b3eaa")
                    .asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(CoronavirusService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gson = new GsonBuilder().create();
        JSONArray country = response.getBody().getObject().getJSONObject("data").getJSONArray("coronavirusStats");
        List<Country> stats = gson.fromJson(country.toString(),new TypeToken<List<Country>>(){}.getType());
        return stats;
    }
}
