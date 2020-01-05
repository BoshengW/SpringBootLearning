package com.benson.springbootpractice.controllers;

import com.benson.springbootpractice.domain.City;
import com.benson.springbootpractice.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@RestController
public class CityRestController {
    @Autowired
    private CityService cityService;

//    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
//    public City findOneCity(@PathVariable("id") Long id) {
//        return cityService.findCityById(id);
//    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/cityall")
    public List<City> findAllCity() {
        System.out.println("Jump in /api/city");
        return cityService.findAllCity();
    }

    @GetMapping("/showall")
    public List<City> findAll() {
        System.out.println("Jump in /api/cityall");
        return cityService.findAll();
    }

    @RequestMapping(value = "/city/{id}", method=RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
        System.out.println("Delete "+ id + " success");
    }

    @RequestMapping(value = "/city/add", method=RequestMethod.POST)
    public void addCity(@RequestBody City city) {
        // model a
        // rowmapper
        System.out.println(city.getCityName());
        System.out.println(city.getId());
        System.out.println(city.getProvinceId());
        System.out.println(city.getDescription());
        cityService.addCity(city);
        System.out.println("add successfully");
    }
    @RequestMapping(value = "/city/update", method=RequestMethod.PUT)
    public void updateCity(@RequestBody City city) {

        cityService.updateCity(city);
        System.out.println("update successfully");
    }

//    @PostMapping("/api/city/post")
//    public String post(HttpServletRequest request) throws IOException {
//
////        StringBuffer req1 = new StringBuffer();
////        String line = null;
////        BufferedReader reader = request.getReader();
////        while((line=reader.readLine())!=null) {
////            req1.append(line);
////        }
//        return req;
//    }
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
