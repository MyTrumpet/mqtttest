package com.tianfu.util;

import java.util.List;

public class SportDataBean {
	private String username;
	private int user_mac;
	private List<SportContent> sportcontents;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUser_mac() {
		return user_mac;
	}
	public void setUser_mac(int user_mac) {
		this.user_mac = user_mac;
	}
	public List<SportContent> getSportcontents() {
		return sportcontents;
	}
	public void setSportcontents(List<SportContent> sportcontents) {
		this.sportcontents = sportcontents;
	}
	@Override
	public String toString() {
		return "SportDataBean [username=" + username + ", user_mac=" + user_mac + ", sportcontents=" + sportcontents
				+ "]";
	}
	
	
	
}
