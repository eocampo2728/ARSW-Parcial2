/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controller;

import edu.eci.arsw.CoronavirusAPIApplication;
import edu.eci.arsw.model.Country;
import edu.eci.arsw.service.CoronavirusService;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduardo Ocampo
 */
@RestController
@RequestMapping(value = "/countries")
public class CoronavirusController {
   @Autowired
   CoronavirusService coronavirusService;
   /**
    * This request all the countries
    * @return it return an array with all the countries or a NOT_FOUND error in case is not able to get the data.
    */
   @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCases(){
        try {
            List<Country> stats = coronavirusService.getAllCountries(); 
            return new ResponseEntity<>(stats, HttpStatus.OK); 
        } catch (Exception e) {
            Logger.getLogger(CoronavirusAPIApplication.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Unable to return information",HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * This method request the information of a specific country
     * @param country name of the country to search the information
     * @return it return an array with all the provinces of the country or a NOT_FOUND error in case is not able to get the data.
     */
    @RequestMapping(path = "/{country}", method = RequestMethod.GET)
    public ResponseEntity<?> getCaseByCountry(@PathVariable("country")String country){
        try {
            List<Country> stats = coronavirusService.getCountryByName(country); 
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(CoronavirusAPIApplication.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar la informacion", HttpStatus.NOT_FOUND);
        }
    }
   
}
