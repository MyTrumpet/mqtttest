package com.tianfu.po;

public class mqtt_save {
	private int messageid;
	private String topic;
	private int  Qos;
	private String message;
	public int getMessageid() {
		return messageid;
	}
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getQos() {
		return Qos;
	}

	public void setQos(int qos) {
		Qos = qos;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	@Override
	public String toString() {
		return "mqtt_save [messageid=" + messageid + ", topic=" + topic + ", Qos=" + Qos + ", message=" + message + "]";
	}
	
}
