package com.example.demo.service;

import com.google.gson.JsonObject;

public interface ConnectionService {

    public JsonObject apiCall(String connectUrl, String method, JsonObject jsonObject);
    public JsonObject apiCall2(String connectUrl, String method, JsonObject jsonObject);
    public JsonObject apiCall3(String connectUrl, String method, String json);

}
