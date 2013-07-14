package com.br.brazilpanels.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Utils {

	
	public static String toJson(Object T){    		
		Gson gson = new Gson();
		return gson.toJson(T);
	}
  	
 	public static String toJsonTree(Object T){     		
 		Gson gson = new Gson();   
		JsonElement result=gson.toJsonTree(T);
		return result.toString();
	}
 	
	public static Object toGenericObject(String json,Class clazz){
 		Gson gson = new Gson();  
 		return gson.fromJson(json,clazz);
 	}
 	
	public  static Object toGenericObject(String json, Type type){
		Gson gson = new Gson();  
 		return gson.fromJson(json, type);
 	}

}
