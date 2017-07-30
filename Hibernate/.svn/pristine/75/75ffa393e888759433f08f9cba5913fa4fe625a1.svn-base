package com.huiji.utils;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {
	
	private static Gson gson=null;
	
	static{
		if(gson==null){
			gson=new Gson();
		}
	}
	
	private JsonUtil(){}
	
	/**
	 * Object转json
	 * @param obj
	 * @return
	 */
	public static String bean2Json(Object obj){
		if(gson!=null){
			return gson.toJson(obj);
		}
		return null;
	}
	
	/**
	 * 转成Object
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T> T json2Bean(String json,Class<T> classOfT){
		T t=null;
		if(gson!=null){
			t= gson.fromJson(json, classOfT);
		}
		return t;
	}
	
	/**
	 * 转成List
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T> List<T> json2List(String json,Class<T> classOfT){
		List<T> t=null;
		if(gson!=null){
			t=gson.fromJson(json, new TypeToken<List<T>>(){}.getType());
		}
		return t;
	}
	
	/**
	 * 转成List中有Map的
	 * @param json
	 * @return
	 */
	public static <T> List<Map<String,T>> json2ListMap(String json){
		List<Map<String,T>> list=null;
		if(gson!=null){
			list=gson.fromJson(json, new TypeToken<List<Map<String,T>>>(){}.getType());
		}
		return list;
	}
	
	/**
	 * 转成Map
	 * @param json
	 * @return
	 */
	public static <T> Map<String,T> json2Map(String json){
		Map<String,T> map=null;
		if(gson!=null){
			map=gson.fromJson(json,new TypeToken<Map<String,T>>(){}.getType());
		}
		return map;
	}
}
