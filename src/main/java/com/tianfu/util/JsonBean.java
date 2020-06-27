package com.tianfu.util;

import java.util.List;

public class JsonBean {
	private String gateway_mac;
	private List<Content> content;
	public String getGateway_mac() {
		return gateway_mac;
	}
	public void setGateway_mac(String gateway_mac) {
		this.gateway_mac = gateway_mac;
	}
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "JsonBean [gateway_mac=" + gateway_mac + ", content=" + content + "]";
	}
	
	
}
