package com.benson.springbootpractice.dao;

import com.benson.springbootpractice.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public City findCityByIdFromDB(Long id) {
        String sql = "select * from city where id=?;";
        City mycity= jdbcTemplate.queryForObject(sql, new RowMapper<City>() {
            @Override
            public City mapRow(ResultSet resultSet, int i) throws SQLException {
                // resultSet save all columns values based on index
                City temp = new City();
                temp.setId(resultSet.getLong(1));
                temp.setProvinceId(resultSet.getLong(2));
                temp.setCityName(resultSet.getString(3));
                temp.setDescription(resultSet.getString(4));
                return temp;

            }
        }, id);
        return mycity;

    }


    @Override
    public void updateByIdFromDB(City city) {
        String sql = "update city set city_name=?, province_id=?, description=? where id=?;";
        int res = jdbcTemplate.update(sql, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,city.getCityName());
                preparedStatement.setLong(2,city.getProvinceId());
                preparedStatement.setString(3, city.getDescription());
                preparedStatement.setLong(4,city.getId());
            }
        });
        System.out.println("update success");

    }

    @Override
    public void addCityFromDB(City city) {
        String sql = "insert into city values(?,?,?,?);";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setLong(1,city.getId());
                preparedStatement.setLong(2,city.getProvinceId());
                preparedStatement.setString(3,city.getCityName());
                preparedStatement.setString(4,city.getDescription());
            }
        });
        System.out.println("add success");
    }

    @Override
    public void deleteByIdFromDB(Long id) {
        String sql = "delete from city where id=?;";
        jdbcTemplate.update(sql,id);
        System.out.println("delete success");
    }

}
