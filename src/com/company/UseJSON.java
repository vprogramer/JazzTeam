package com.company;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class UseJSON {
    private String path;
    private JSONObject object;

    public UseJSON(String path){
        this.path = path;
        this.object = new JSONObject();
    }

    public String readJSON(long num){
        JSONParser parser = new JSONParser();
        try{
            this.object = (JSONObject) parser.parse(new FileReader(this.path));
            String number = (String) object.get(Long.toString(num));
            return number;
        }
        catch (IOException | ParseException ex){
            System.out.println(ex);
            return "";
        }

    }

    public String readJSON(String name, int index){
        JSONParser parser = new JSONParser();
        try{
            this.object = (JSONObject) parser.parse(new FileReader(this.path));
            JSONArray messages = (JSONArray) object.get(name);
            return messages.get(index).toString();
        }
        catch (IOException | ParseException ex){
            System.out.println(ex);
            return "";
        }

    }
}
