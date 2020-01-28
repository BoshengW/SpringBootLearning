package com.benson.springbootpractice.ToolFunc;

import com.benson.springbootpractice.domain.City;
import org.json.JSONException;
import org.json.JSONObject;

public class CvtJson {
    public static City cvtJsonToCity(String cityJson) throws JSONException {
        JSONObject myCityJson = new JSONObject(cityJson);
        City myCity = new City();
        myCity.setId((int) myCityJson.get("id"));
        myCity.setProvinceId((int) myCityJson.get("province_id"));
        myCity.setCityName((String) myCityJson.get("city_name"));
        myCity.setDescription((String) myCityJson.get("description"));

        return myCity;
    }
}
