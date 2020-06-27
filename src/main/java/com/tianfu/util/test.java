package com.tianfu.util;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class test {

	public static void main(String[] args) {
		String string = "{\"username\": \"wyt\",\"user_mac\":\"41703534\", "
				+ "\"sportcontents\": [{  \"create_time\":\"2019/11/12\",\"tmp\": \"36.6\",\"hr\":\"95\"},"
				+ "{ \"create_time\":\"2019/11/12\", \"tmp\": \"37.5\",\"hr\":\"80\"}]}\r\n" + 
				"";
		Gson gson = new Gson();    
        //把JSON数据转化为对象
        SportDataBean sportData = gson.fromJson(string, new TypeToken<SportDataBean>(){}.getType());
        System.out.println(sportData.toString());
        System.out.println(sportData.getSportcontents());
        
	}
}
