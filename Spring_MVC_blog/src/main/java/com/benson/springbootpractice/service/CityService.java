package com.benson.springbootpractice.service;

import com.benson.springbootpractice.domain.City;

import java.util.List;

public interface CityService {


    List<City> findAllCity();
    /*
    * check city info based on id
    *
    *
    *  */
    List<City> findAll();
//    void addCity(City city);

////    Long updateCity(City city);

//    void deleteById(Long id);
//
//    City findCityById(Long id);


}
