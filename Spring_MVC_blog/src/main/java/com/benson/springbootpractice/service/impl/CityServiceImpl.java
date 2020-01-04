package com.benson.springbootpractice.service.impl;

import com.benson.springbootpractice.dao.CityDao;
import com.benson.springbootpractice.domain.City;
import com.benson.springbootpractice.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
//
//    @Autowired
//    private CityDao cityDao; // need to implement CityDao interface and put implementation as Repository

    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> findAllCity() {
        List<City> mycity = cityDao.findAllCityFromDB();
        return mycity;
    }

    @Override
    public List<City> findAll() {
        List<City> mylist = cityDao.findAllFromDB();
        return mylist;
    }

    @Override
    public void addCity(City city) {
        cityDao.addCityFromDB(city);
    }

    @Override
    public void updateCity(City city) {
        cityDao.updateByIdFromDB(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityDao.deleteByIdFromDB(id);
    }

//    @Override
//    public void addCity(City city) {
//        jdbcTemplate.update("insert into city values(?,?,?,?)" , city.getId(),city.getProvinceId(),city.getCityName(),city.getDescription());
//
//    }
//
//    @Override
//    public void deleteById (Long id){
//        jdbcTemplate.update("delete from city where id = ?", id);
//    }
}
