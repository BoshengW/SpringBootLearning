package com.benson.springbootpractice.dao;

import com.benson.springbootpractice.domain.City;

import java.util.List;

public interface CityDao {

    // 增删改查
    List<City> findAllCityFromDB();
    List<City> findAllFromDB();

    City findCityByIdFromDB(int id);
    void updateByIdFromDB(City city);
    void addCityFromDB(City city);
    void deleteByIdFromDB(int id);

}
