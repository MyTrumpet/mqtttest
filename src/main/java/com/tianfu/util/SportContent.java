package com.tianfu.util;

public class SportContent {
	private String create_time;
	private float tmp;
	private int hr;
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public float getTmp() {
		return tmp;
	}
	public void setTmp(float tmp) {
		this.tmp = tmp;
	}
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	@Override
	public String toString() {
		return "SportContent [create_time=" + create_time + ", tmp=" + tmp + ", hr=" + hr + "]";
	}
	

}
