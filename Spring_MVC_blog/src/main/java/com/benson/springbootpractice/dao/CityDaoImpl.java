package com.benson.springbootpractice.dao;

import com.benson.springbootpractice.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<City> findAllCityFromDB() {
        String sql = String.format("select city_name from city;");
        List list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public List<City> findAllFromDB() {
        String sql = String.format("select * from city;");
        List list = jdbcTemplate.queryForList(sql);
        return list;

    }

//    @Override
//    public void addCityFromDB(City city) {
//
//
//    }
//
//    @Override
//    public void deleteByIdFromDB(Long id) {
//
//    }
}
