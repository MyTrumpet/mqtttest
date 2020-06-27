package com.tianfu.util;

import java.util.List;

public class LightOnBean {
	/*
	  "{\"treet_number\": \"SCMY00001\", \"light_content\": [{\"light_number\":\"MY00001\","
	+ "\"acquisition_time\":\"2019/11/12\", \"light_intensity\": \"350\",\"turnonoff\":\"0\"}]}";
	 */
	private String treet_number;
	private List<LightContent> light_content;
	public String getTreet_number() {
		return treet_number;
	}
	public void setTreet_number(String treet_number) {
		this.treet_number = treet_number;
	}
	public List<LightContent> getLight_content() {
		return light_content;
	}
	public void setLight_content(List<LightContent> light_content) {
		this.light_content = light_content;
	}
	

	
	@Override
	public String toString() {
		return "LightOnBean [treet_number=" + treet_number + ", light_content=" + light_content + "]";
	}
	
	
	

}
