package com.benson.springbootpractice.controllers;

import com.benson.springbootpractice.ToolFunc.CvtJson;
import com.benson.springbootpractice.domain.City;
import com.benson.springbootpractice.service.CityService;
import org.json.JSONException;
import org.json.JSONObject;
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
    public void deleteById(@PathVariable("id") int id) {
        cityService.deleteCity(id);
        System.out.println("Delete "+ id + " success");
    }

    @RequestMapping(value = "/city/add", method=RequestMethod.POST)
    public String addCity(@RequestBody String jsonCity) throws JSONException {
        // convert city json string into json object
        City myCity = CvtJson.cvtJsonToCity(jsonCity);
        System.out.println(myCity.getCityName());
        cityService.addCity(myCity);
        return myCity.toString();
    }
    @RequestMapping(value = "/city/update", method=RequestMethod.PUT)
    public String updateCity(@RequestBody String jsonCity) throws JSONException {
        // convert json string from front end to City Object
        City myCity = CvtJson.cvtJsonToCity(jsonCity);
        cityService.updateCity(myCity);
        return myCity.toString();

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
