package com.tianfu.dao;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.tianfu.po.LightOn;
import com.tianfu.po.mqtt_save;
import com.tianfu.util.DButils;

public class LightOnDao {

	private static String SQL = "";

	public static int addLightOn(String street_number, String light_number, String acquisition_time,
			int light_intensity, int turnonoff) throws Exception {

		DButils dButils = new DButils();
		SQL = "insert into lighton values(null,'" + street_number + "','" + light_number + "','" + acquisition_time
				+ "','" + light_intensity + "','" + turnonoff + "')";
		System.out.println(SQL);
		Connection connection = dButils.getConnection();
		Statement statement = (Statement) connection.createStatement();
		int result = statement.executeUpdate(SQL);
		System.out.println(result + "行受影响" + "：插入数据为：" + street_number + "," + light_number + "," + acquisition_time
				+ "," + light_intensity + "," + turnonoff);
		dButils.close(connection, statement);
		return result;
	}

	public static LightOn getLatestLight() {
		LightOn lightOn = new LightOn();
		try {
			SQL = "select * from lighton order by acquisition_time,id desc limit 0,1";
			DButils dButils = new DButils();
			Connection connection = dButils.getConnection();
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lightOn.setTreet_number(rs.getString("treet_number"));
				lightOn.setLight_number(rs.getString("light_number"));
				lightOn.setAcquisition_time(rs.getString("acquisition_time"));
				lightOn.setLight_intensity(rs.getInt("light_intensity"));
				lightOn.setTurnonoff(rs.getInt("turnonoff"));

			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lightOn;
	}
}
