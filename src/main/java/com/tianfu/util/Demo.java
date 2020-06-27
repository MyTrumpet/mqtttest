package com.tianfu.util;

import java.util.List;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.tianfu.dao.LightOnDao;
import com.tianfu.dao.MqttSaveDao;
import com.tianfu.dao.UserDao;
import com.tianfu.po.LightOn;
import com.tianfu.po.User;
import com.tianfu.po.mqtt_save;

public class Demo {

	public static void main(String[] args) throws Exception {
		/*
		 * UserDao userDao = new UserDao(); userDao.addUser("sdjlsjf", "32156");
		 * userDao.login("sdjlsjf", "32156"); MqttSaveDao mqttSaveDao = new
		 * MqttSaveDao(); List<mqtt_save> lists1 = mqttSaveDao.getAllMqtt_saves();
		 * System.out.println(lists1.size());
		 * 
		 * List<User> lists = userDao.getAllUser(); System.out.println(lists.size());
		 */

		/*
		 * LightOnDao lightOnDao = new LightOnDao(); lightOnDao.addLightOn("SCMY00001",
		 * "MY00001", "2020-6-21 21:20", 321, 1); LightOn lightOn =
		 * lightOnDao.getLatestLight(); System.out.println(lightOn.toString());
		 */

		String messString = "{\"treet_number\": \"SCMY00001\", \"light_content\": [{\"light_number\":\"MY00001\","
				+ "\"acquisition_time\":\"2019-11-12\", \"light_intensity\": \"350\",\"turnonoff\":\"0\"}]}";
		Gson gson = new Gson();
		System.out.println(messString);
		LightOnBean lightOnBean = gson.fromJson(messString, LightOnBean.class);
		System.out.println("转化后的数据：" + lightOnBean.toString());

	}
}
