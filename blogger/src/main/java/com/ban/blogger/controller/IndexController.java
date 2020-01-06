package com.ban.blogger.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {
//    @GetMapping
//    public List index() {
//        List<String> list = new ArrayList<String>();
//        list.add("Hello");
//        list.add("World");
//        return list;
//    }
//    // broswer
//    @GetMapping("/index2")
//    public Map index2() {
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put("a",1);
//        map.put("b",2);
//        map.put("c",3);
//        return map;
//    }
//    @GetMapping("/json")
//    public String index3() {
//        Gson gson = new Gson();
//        String json = "{\"name\":\"mkyong\"}";
//        return json;
//    }
//    @GetMapping("index6")
//    public String index6(){
//
//        JsonObject jsonObject = new JsonObject();
//        JsonObject jsonObject1 = new JsonObject();
//        // json tree structure
//        jsonObject.add("key",jsonObject1);
//        jsonObject1.add("key1",new JsonObject());
//        jsonObject1.add("key2",new JsonObject());
//
//        return jsonObject.toString();
//    }


}
