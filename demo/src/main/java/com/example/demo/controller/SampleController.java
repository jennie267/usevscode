package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.Connection;
import com.example.demo.service.ConnectionService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    ConnectionService connectionService;

    @ResponseBody
    @GetMapping("/start")
    public String startApi(){
        String url = Connection.getBaseUrl()+"/start";
        String method = "POST";
        JsonObject obj = new JsonObject();
        obj.addProperty("problem", "1");
        JsonObject jsonObject = connectionService.apiCall(url, method, obj);
        String authKey = jsonObject.get("auth_key").toString();
        Connection.setAuthKey(authKey.replaceAll("\"", ""));
        System.out.println(Connection.getAuthKey());

        return jsonObject.toString();
    }

    @ResponseBody
    @GetMapping("/locations")
    public String locationApi(){
        String url = Connection.getBaseUrl()+"/locations";
        String method = "GET";
        JsonObject obj = new JsonObject();
        JsonObject jsonObject = connectionService.apiCall2(url, method, obj);

        return jsonObject.toString();
    }

    @ResponseBody
    @GetMapping("/trucks")
    public String truckApi(){
        String url = Connection.getBaseUrl()+"/trucks";
        String method = "GET";
        JsonObject obj = new JsonObject();
        JsonObject jsonObject = connectionService.apiCall2(url, method, obj);

        return jsonObject.toString();
    }

    @ResponseBody
    @GetMapping("/simulate")
    public String simulateApi(){
        Gson gson = new Gson();
        String url = Connection.getBaseUrl()+"/simulate";
        String method = "PUT";

        List<Map<String, Object>> treeList =new ArrayList<Map<String,Object>>();
        Map map = new HashMap<>();
        map.put("truck_id", 0);
        map.put("command", new int[]{2, 5, 4, 1, 6});
        treeList.add(map);
        Map pMap = new HashMap<>();
        pMap.put("commands", treeList);

        System.out.println(gson.toJson(pMap).toString());

        for(int i = 0; i<720 ; i++)
        {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            connectionService.apiCall3(url, method, gson.toJson(pMap).toString());
        }

        JsonObject jsonObject = connectionService.apiCall2(Connection.getBaseUrl()+"/score", "GET", new JsonObject());

        return jsonObject.toString();
        
        
        //gson.toJson(pMap);
        // JsonObject jsonObject = connectionService.apiCall3(url, method, gson.toJson(pMap).toString());

        // return jsonObject.toString();
    }

    @GetMapping("/score")
    public String scoreApi(){
        String url = Connection.getBaseUrl()+"/score";
        String method = "GET";
        JsonObject obj = new JsonObject();
        JsonObject jsonObject = connectionService.apiCall2(url, method, obj);

        return jsonObject.toString();
    }


    
}
