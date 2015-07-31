package com.selenium.rajesh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParser {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("F:\\Workfiles\\FrogStore\\SiteTagApi\\output.json");
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(reader);
		JsonArray arrayJ = (JsonArray)object.get("output");
		Iterator it = arrayJ.iterator();
		for(int i=0;i<arrayJ.size();i++){
			JsonObject obj = (JsonObject)it.next();
			System.out.println(obj.get("uuid"));
			obj=null;
		}
	}

}
