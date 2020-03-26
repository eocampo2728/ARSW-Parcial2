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
import java.util.ArrayList;
import java.util.HashMap;
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
        } catch (UnirestException e) {
            Logger.getLogger(CoronavirusService.class.getName()).log(Level.SEVERE, null, e);
        }
        
        gson = new GsonBuilder().create();
        JSONArray allCountries = response.getBody().getObject().getJSONObject("data").getJSONArray("covid19Stats");
        List<Country> stats = gson.fromJson(allCountries.toString(),new TypeToken<List<Country>>(){}.getType());
        
        HashMap<String, Country> countries = new HashMap<>();
        Country country = null;
        for (Country c: stats){
            if(countries.containsKey(c.getCountry())){
                country = countries.get(c.getCountry());
                country.setConfirmed(country.getConfirmed()+c.getConfirmed());                
                country.setDeath(country.getDeath()+c.getDeath());
                country.setRecovered(country.getRecovered()+c.getRecovered());
            }else{
                countries.put(c.getCountry(),c);
            }
        }
        stats = new ArrayList<>(countries.values());
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
        } catch (UnirestException e) {
            Logger.getLogger(CoronavirusService.class.getName()).log(Level.SEVERE, null, e);
        }
        
        gson = new GsonBuilder().create();
        
        JSONArray countryStat = response.getBody().getObject().getJSONObject("data").getJSONArray("coronavirusStats");
        List<Country> stats = gson.fromJson(countryStat.toString(),new TypeToken<List<Country>>(){}.getType());
        return stats;
    }
}
