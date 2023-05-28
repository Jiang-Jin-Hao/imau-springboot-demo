package com.example.utils;


import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Result {

    public static String okGetString(String message, Object data) {
        Map<String, Object> map = new HashMap<>();

        map.put("code", 200);
        map.put("message", message);

        map.put("data", data);

        return JSONObject.toJSONString(map);
    }

    public static String failGetString(String message) {
        Map<String, Object> map = new HashMap<>();

        map.put("code", 400);
        map.put("message", message);

        return JSONObject.toJSONString(map);
    }

}
