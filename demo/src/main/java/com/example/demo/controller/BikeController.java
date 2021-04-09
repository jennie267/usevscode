package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.example.demo.Connection;
import com.example.demo.model.Location;
import com.example.demo.model.StartValue;
import com.example.demo.service.ConnectService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BikeController {

    @Autowired
    ConnectService connectService;

    @GetMapping("/start")
    public String startApi(){
        String url = Connection.getBaseUrl()+"/start";
        JsonObject obj = new JsonObject();
        obj.addProperty("problem", "1");
        //JsonObject jsonObject = connectService.startApi(url, obj);
        String rtn = connectService.startApi(url, obj);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        StartValue sv = gson.fromJson(rtn, StartValue.class);
        System.out.println("모델 바꿈  " +sv.getAuthKey());
        Connection.setAuthKey(sv.getAuthKey());
        System.out.println(Connection.getAuthKey());

        return sv.getAuthKey();
    }

    @GetMapping("/locations")
    public String locationApi(){
        String url = Connection.getBaseUrl()+"/locations";
        String rtn = connectService.locationApi(url);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        // Location[] arr = gson.fromJson(rtn, Location[].class);
        // List<Location> list = Arrays.asList(arr);
        Map<String,List<Location>> rtnMap = gson.fromJson(rtn, new TypeToken<Map<String,List<Location>>>(){}.getType());
        List<Location> list = rtnMap.get("locations");
        for (Location location : list) {
            System.out.println(location.toString());

        }
        return rtnMap.toString();
    }

    
}
