package com.benson.springbootpractice.dao;

import com.benson.springbootpractice.domain.City;

import java.util.List;

public interface CityDao {

    List<City> findAllCityFromDB();

    List<City> findAllFromDB();

//    void addCityFromDB(City city);
//
//    void deleteByIdFromDB(Long id);

}
