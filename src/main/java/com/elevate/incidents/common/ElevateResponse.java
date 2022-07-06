package com.elevate.incidents.common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;


public class ElevateResponse {
    public JSONObject getResponse(String url) throws IOException, ParseException {
        String username = "elevateinterviews";
        String password = "ElevateSecurityInterviews2021";
        String response = "";
        URL weburl=new URL(url);
        HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization",
                "Basic " + Base64.getEncoder().encodeToString(
                        (username + ":" + password).getBytes()
                )
        );
        int responseCode = conn.getResponseCode();
        if(responseCode == 200){
            Scanner scanner = new Scanner(conn.getInputStream());
            while(scanner.hasNextLine()){
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();
        }
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject)parser.parse(response);
        return obj;
    }
}
