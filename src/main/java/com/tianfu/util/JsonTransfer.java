package com.tianfu.util;

import com.google.gson.Gson;

public class JsonTransfer {
	
	public JsonBean Transfer(String Jsonstring) {
		Gson gson = new Gson();
		
		JsonBean jsonBean = gson.fromJson(Jsonstring, JsonBean.class);
		
		return jsonBean;
	}

	public static void main(String[] args) {
		String string = "{\"gateway_mac\": \"666666999999\", \r\n" + 
				"\"content\": [\r\n" + 
				"{ \r\n" + 
				"\"tag_mac\": \"112233445566\", \r\n" + 
				"\"tmp\": \"36.6\",\r\n" + 
				"\"rssi\":\"2D\"},\r\n" + 
				"{ \r\n" + 
				"\"tag_mac\": \"AABBCCDDEEFF\", \r\n" + 
				"\"tmp\": \"37.5\",\r\n" + 
				"\"rssi\":\"2D\"\r\n" + 
				"}]}\r\n" + 
				"";
		JsonTransfer jsonTransfer = new JsonTransfer();
		JsonBean jsonBean = jsonTransfer.Transfer(string);
		System.out.println(jsonBean.getGateway_mac());

	}

}
