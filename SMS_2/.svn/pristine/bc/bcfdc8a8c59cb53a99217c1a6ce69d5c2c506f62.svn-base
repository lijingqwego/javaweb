package com.huiji.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class JsonReader {
	public static JSONObject stream2Json(HttpServletRequest request){
		ServletInputStream in=null;
		InputStreamReader isr=null;
		BufferedReader bufr=null;
		JSONObject json=null;
		try {
			in = request.getInputStream();
			isr=new InputStreamReader(in,"utf-8");
			bufr=new BufferedReader(isr);
			String line=null;
			StringBuilder sb=new StringBuilder();
			while((line=bufr.readLine())!=null){
				sb.append(line);
			}
			in.close();
			isr.close();
			bufr.close();
			System.out.println(sb.toString());
			json= JSONObject.fromObject(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
		
	}
}
