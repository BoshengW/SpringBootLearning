package com.benson.springbootpractice.service;

import com.benson.springbootpractice.domain.City;

import java.util.List;

public interface CityService {


    List<City> findAllCity();

    List<City> findAll();
    void addCity(City city);
    void updateCity(City city);
    void deleteCity(Long id);



}
