/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controller;

import edu.eci.arsw.CoronavirusAPIApplication;
import edu.eci.arsw.model.Country;
import edu.eci.arsw.service.CoronavirusService;
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
@RequestMapping(value = "/covid19")
public class CoronavirusController {
   @Autowired
   CoronavirusService coronavirusService;
   
   @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCases(){
        try {
            List<Country> stats = coronavirusService.getAllCountries(); 
            return new ResponseEntity<>(stats, HttpStatus.ACCEPTED); 
        } catch (Exception e) {
            Logger.getLogger(CoronavirusAPIApplication.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Unable to return information",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/{country}", method = RequestMethod.GET)
    public ResponseEntity<?> getCaseByCountry(@PathVariable("country")String country){
        try {
            List<Country> stats = coronavirusService.getCountryByName(country); 
            return new ResponseEntity<>(stats, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CoronavirusAPIApplication.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar la informacion", HttpStatus.NOT_FOUND);
        }
    }
   
}
