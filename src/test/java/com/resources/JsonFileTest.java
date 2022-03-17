package com.resources;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

@Data
public class JsonFileTest {

    private String line = "[{\"username\":\"tomsmith\",\"password\":\"SuperSecretPassword!\",\"url\":\"https://the-internet.herokuapp.com\"}]";

    public String checkResource(String jsonElement) {
        JSONArray recs = new JSONArray(getLine());
        for (Object data : recs) {
            JSONObject obj = ((JSONObject) data);
            jsonElement = obj.getString(jsonElement);
        }
        return jsonElement;
    }
}
