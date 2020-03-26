package edu.eci.arsw.model;

public class Country {
    private String country;
    private int confirmed;
    private int deaths;
    private int recovered;
    
    public Country (String country, int confirmed, int deaths, int recovered){
        this.country = country;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    public int getConfirmed(){
        return confirmed;
    }
    
    public void setConfirmed(int confirmed){
        this.confirmed = confirmed;
    }
    
    public int getDeaths(){
        return deaths;
    }
    
    public void setDeaths(int deaths){
        this.deaths = deaths;
    }
    
    public int getRecovered(){
        return recovered;
    }
    
    public void setRecovered(int recovered){
        this.recovered = recovered;
    }
}
