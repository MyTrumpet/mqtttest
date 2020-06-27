package com.tianfu.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.tianfu.po.User;
import com.tianfu.po.mqtt_save;
import com.tianfu.util.DButils;

public class MqttSaveDao {

	private static String SQL = "";
	
	public static int addMqttSave(String topic,int Qos,String message) throws Exception {
		DButils dButils = new DButils();
		SQL = "insert into mqtt_save values(null,'"+topic+"','"+Qos+"','"+message+"')";
		System.out.println(SQL);
		Connection connection = dButils.getConnection();
		Statement statement = (Statement) connection.createStatement();
		int result = statement.executeUpdate(SQL);
		System.out.println(result + "行受影响"+"：插入数据为："+topic+","+Qos+","+message);
		dButils.close(connection, statement);
		
		return result;
	}
	
public static List<mqtt_save> getAllMqtt_saves() throws Exception{
		
		List<mqtt_save> lists = new ArrayList<mqtt_save>();
		try {
			SQL = "select * from mqtt_save";
			DButils dButils = new DButils();
			Connection connection = dButils.getConnection();
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mqtt_save mqttsave = new mqtt_save();
				mqttsave.setMessageid(rs.getInt("messageid"));
				mqttsave.setQos(rs.getInt("Qos"));
				mqttsave.setTopic(rs.getString("topic"));
				mqttsave.setMessage(rs.getString("message"));
				lists.add(mqttsave);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return lists;
	}

	/*
	 * public ResultSet query(String sql,Object... args) throws Exception { DButils
	 * dButils = new DButils(); Connection connection = dButils.getConnection();
	 * PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
	 * for (int i = 0; i < args.length; i++) { ps.setObject(i + 1, args[i]); }
	 * return ps.executeQuery(); }
	 */

}
