package com.benson.springbootpractice.domain;


import javax.persistence.*;

// This class specify the data frame in city table
@Entity
@Table(name="city")
public class City {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="province_Id")
    private Long province_id;
    @Column(name="city_name")
    private String city_name;
    @Column(name="description")
    private String description;

    public City(Long id,Long province_id, String city_name, String description) {
        super();
        this.id = id;
        this.province_id = province_id;
        this.city_name = city_name;
        this.description = description;
    }

    public City() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return province_id;
    }

    public void setProvinceId(Long provinceId) {
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
}
