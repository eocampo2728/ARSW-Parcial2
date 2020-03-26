package edu.eci.arsw.model;

public class Country {
    private String name;
    private int confirmed;
    private int death;
    private int recovered;
    
    public Country (String name, int confirmed, int death, int recovered){
        this.name = name;
        this.confirmed = confirmed;
        this.death = death;
        this.recovered = recovered;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
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
