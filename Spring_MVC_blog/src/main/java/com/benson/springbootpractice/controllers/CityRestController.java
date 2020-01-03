package com.benson.springbootpractice.controllers;

import com.benson.springbootpractice.domain.City;
import com.benson.springbootpractice.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityRestController {
    @Autowired
    private CityService cityService;

//    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
//    public City findOneCity(@PathVariable("id") Long id) {
//        return cityService.findCityById(id);
//    }
    @GetMapping("/api/index")
    public String index() {
        return "index";
    }
    @GetMapping("/api/city")
    public List<City> findAllCity() {
        System.out.println("success");
        return cityService.findAllCity();
    }

    @GetMapping("/api/cityall")
    public List<City> findAll() {
        return cityService.findAll();
    }
//
//    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
//    public void createCity(@RequestBody City city) {
//        cityService.addCity(city);
//    }
//
//    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
//    public void modifyCity(@RequestBody City city) {
//        cityService.updateCity(city);
//    }
//
//    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
//    public void modifyCity(@PathVariable("id") Long id) {
//        cityService.deleteById(id);
}
