package com.example.mudule4.controller;

import com.example.mudule4.model.City;
import com.example.mudule4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home/cities")
@CrossOrigin
public class CityController
{
    @Autowired
    private ICityService cityService;

    @GetMapping("/list")
    public ResponseEntity<List<City>> cityList()
    {
        List<City> cities = (List<City>) cityService.findAll();

        if (cities.size() == 0)
        {
            return new ResponseEntity<>(cities, HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(cities, HttpStatus.OK);
        }
    }
    @GetMapping("/infoCity/{id}")
    public ResponseEntity<City> cityInfo(@PathVariable("id") Long id)
    {
        Optional<City> optionalCity = cityService.findById(id);

        if (optionalCity.isEmpty())
        {
            return new ResponseEntity<>(optionalCity.get(), HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(optionalCity.get(), HttpStatus.OK);
        }
    }
    @PutMapping("/updateCity/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") Long id)
    {
        Optional<City> cityOptional =cityService.findById(id);
        if (!cityOptional.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }
    @DeleteMapping("/deleteCity/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable("id") Long id)
    {
        Optional<City> optionalCity = cityService.findById(id);
        cityService.delete(optionalCity.get());
        return new ResponseEntity<>(optionalCity.get(), HttpStatus.NO_CONTENT);
    }

}
