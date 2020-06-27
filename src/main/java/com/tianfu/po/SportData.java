package com.tianfu.po;

public class SportData {
	private int id;
	private int user_mac;
	private String createtime;
	private float temp;
	private int hr;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_mac() {
		return user_mac;
	}
	public void setUser_mac(int user_mac) {
		this.user_mac = user_mac;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	@Override
	public String toString() {
		return "SportData [id=" + id + ", user_mac=" + user_mac + ", createtime=" + createtime + ", temp=" + temp
				+ ", hr=" + hr + "]";
	}
	
	

}
