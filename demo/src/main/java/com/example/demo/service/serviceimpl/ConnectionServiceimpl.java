package com.example.demo.service.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.demo.Connection;
import com.example.demo.service.ConnectionService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.stereotype.Service;

@Service
public class ConnectionServiceimpl implements ConnectionService {

    @Override
    public JsonObject apiCall(String connectUrl, String method, JsonObject jsonObject){
    	try {
            URL url = new URL(connectUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("X-Auth-Token", Connection.getXAuthToken());        
            conn.setRequestProperty("Content-Type", Connection.getContentType());
            conn.setDoOutput(true);

            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            osw.write(jsonObject.toString());
            osw.flush();
            osw.close();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            if (conn.getResponseCode() != 200) {
                System.out.println("Failed: HTTP error code : " + conn.getResponseCode());
            	throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseCode());
            } else {
                System.out.println("발송 성공");
            }
            
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
                return new JsonParser().parse(line).getAsJsonObject();
            }
            br.close();           
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("RestCall Fail : " + e.getMessage());
        }
        return null;
    }

    @Override
    public JsonObject apiCall2(String connectUrl, String method, JsonObject jsonObject){
    	try {
            URL url = new URL(connectUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(method);   
            conn.setRequestProperty("Authorization", Connection.getAuthKey());         
            conn.setRequestProperty("Content-Type", Connection.getContentType());
            conn.setDoOutput(true);

 
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            if (conn.getResponseCode() != 200) {
                System.out.println("Failed: HTTP error code : " + conn.getResponseCode());
            	throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseCode());
            } else {
                System.out.println("발송 성공");
            }
            
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
                return new JsonParser().parse(line).getAsJsonObject();
            }
            br.close();           
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("RestCall Fail : " + e.getMessage());
        }
        return null;
    }

    @Override
    public JsonObject apiCall3(String connectUrl, String method, String json){
    	try {
            URL url = new URL(connectUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Authorization", Connection.getAuthKey());         
            conn.setRequestProperty("Content-Type", Connection.getContentType());
            conn.setDoOutput(true);

            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            osw.write(json);
            osw.flush();
            osw.close();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            if (conn.getResponseCode() != 200) {
                System.out.println("Failed: HTTP error code : " + conn.getResponseCode());
            	throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseCode());
            } else {
                System.out.println("발송 성공");
            }
            
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
                return new JsonParser().parse(line).getAsJsonObject();
            }
            br.close();           
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("RestCall Fail : " + e.getMessage());
        }
        return null;
    }


    
}
