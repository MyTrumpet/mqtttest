package com.tianfu.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.tianfu.po.SportData;
import com.tianfu.po.mqtt_save;
import com.tianfu.util.DButils;

public class SportDataDao {
	private static String SQL = "";

	public static int addSportData(int user_mac, String createtime,float temp,int hr) throws Exception {
		DButils dButils = new DButils();
		System.out.println(dButils);
		SQL = "insert into sportdata values(null,'" + user_mac + "','" + createtime + "','"+ temp +"','"+ hr +"')";
		System.out.println(SQL);
		Connection connection = dButils.getConnection();
		Statement statement = (Statement) connection.createStatement();
		int result = statement.executeUpdate(SQL);
		System.out.println(result + "行受影响" + "：插入数据为：" + user_mac + "," + createtime+","+ temp +","+ hr );
		dButils.close(connection, statement);

		return result;
	}
	
public static List<SportData> getAllSportDatas() throws Exception{
		
		List<SportData> lists = new ArrayList<SportData>();
		try {
			SQL = "select * from sportdata";
			DButils dButils = new DButils();
			Connection connection = dButils.getConnection();
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SportData sportData = new SportData();
				sportData.setId(rs.getInt("id"));
				sportData.setUser_mac(rs.getInt("user_mac"));
				sportData.setCreatetime(rs.getString("createtime"));
				sportData.setTemp(rs.getFloat("temp"));
				sportData.setHr(rs.getInt("hr"));
				lists.add(sportData);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return lists;
	}
}
