package com.benson.springbootpractice.domain;


import javax.persistence.*;

// This class specify the data frame in city table
@Entity
@Table(name="city")
public class City {
    @Id
    @GeneratedValue
    private int id;

    private int province_id;
//    @Column(name="city_name")
    private String city_name;
//    @Column(name="description")
    private String description;

    public City() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return province_id;
    }

    public void setProvinceId(int provinceId) {
        this.province_id = provinceId;
    }

    public String getCityName() {
        return city_name;
    }

    public void setCityName(String cityName) {
        this.city_name = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id: " + id + " province_id: " + province_id + " city_name: " + city_name + " description: " + description;
    }
}
