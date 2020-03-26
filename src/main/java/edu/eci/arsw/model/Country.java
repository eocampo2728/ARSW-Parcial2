package edu.eci.arsw.model;

public class Country {
    private String country;
    private int confirmed;
    private int death;
    private int recovered;
    
    public Country (String country, int confirmed, int death, int recovered){
        this.country = country;
        this.confirmed = confirmed;
        this.death = death;
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
    
    public int getDeath(){
        return death;
    }
    
    public void setDeath(int death){
        this.death = death;
    }
    
    public int getRecovered(){
        return recovered;
    }
    
    public void setRecovered(int recovered){
        this.recovered = recovered;
    }
}
