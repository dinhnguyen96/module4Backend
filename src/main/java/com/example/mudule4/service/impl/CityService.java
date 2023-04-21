package com.example.mudule4.service.impl;

import com.example.mudule4.model.City;
import com.example.mudule4.repository.ICityRepository;
import com.example.mudule4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService
{
    @Autowired
    private ICityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }


    @Override
    public void save(City city)
    {
        cityRepository.save(city);
    }

    @Override
    public void delete(City city)
    {
        cityRepository.delete(city);

    }
}
