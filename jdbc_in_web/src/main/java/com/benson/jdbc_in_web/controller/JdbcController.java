package com.benson.jdbc_in_web.controller;


import org.springframework.web.bind.annotation.*;
import org.json.*;
@RestController
public class JdbcController {

    @PostMapping("/json")
    public String getJson(@RequestBody String jsonStr) throws JSONException {
        System.out.println(jsonStr);
        JSONObject jo = new JSONObject(jsonStr);
        System.out.println(jo);
        return jo.toString();
    }

    @PutMapping("/jsonUpdate")
    // if you want to send back a json data, you must use @Requestbody
    public String updateJson(@RequestBody String jsonStr) throws JSONException {
        // when get json from web side, you will receive a string of json not a direct json object
        JSONObject jo2 = new JSONObject(jsonStr);
        System.out.println(jo2);
        return jo2.toString();
    }
}
