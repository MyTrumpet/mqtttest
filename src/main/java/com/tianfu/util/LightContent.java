package com.tianfu.util;

public class LightContent {
	

	/*
	 * String messString =
	 * "{\"treet_number\": \"SCMY00001\", \"light_content\": [{\"light_number\":\"MY00001\","
	 * +
	 * "\"acquisition_time\":\"2019-11-12\", \"light_intensity\": \"350\",\"turnonoff\":\"0\"}]}"
	 * ;
	 */
	private String light_number;
	private String acquisition_time;
	private int light_intensity;
	private int turnonoff;
	public String getLight_number() {
		return light_number;
	}
	public void setLight_number(String light_number) {
		this.light_number = light_number;
	}
	public String getAcquisition_time() {
		return acquisition_time;
	}
	public void setAcquisition_time(String acquisition_time) {
		this.acquisition_time = acquisition_time;
	}
	public int getLight_intensity() {
		return light_intensity;
	}
	public void setLight_intensity(int light_intensity) {
		this.light_intensity = light_intensity;
	}
	public int getTurnonoff() {
		return turnonoff;
	}
	public void setTurnonoff(int turnonoff) {
		this.turnonoff = turnonoff;
	}
	@Override
	public String toString() {
		return "LightContent [light_number=" + light_number + ", acquisition_time=" + acquisition_time
				+ ", light_intensity=" + light_intensity + ", turnonoff=" + turnonoff + "]";
	}
	
}