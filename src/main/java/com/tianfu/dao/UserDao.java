package com.tianfu.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.tianfu.po.User;
import com.tianfu.util.DButils;

public class UserDao {
	static User user = null;
	private static String SQL = "";
	
	public static int addUser(String UserName,String PassWord) throws Exception {
		DButils dButils = new DButils();
		SQL = "insert into user values(null,'"+UserName+"','"+PassWord+"')";
		Connection connection = dButils.getConnection();
		Statement statement = (Statement) connection.createStatement();
		int result = statement.executeUpdate(SQL);
		System.out.println(result + "行受影响"+"：插入数据为："+UserName+","+PassWord);
		dButils.close(connection, statement);
		
		return result;
	}
	
	public static User login(String username,String password) {
		DButils dButils = new DButils();
		SQL="select * from user where username = ? and password = ?";
		PreparedStatement pstmt = null;
		try {
			Connection connection = dButils.getConnection();
			pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			 //这里的意思将用户名和密码填到SQL语句的问号处
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			//得到数据库的查询结果
			ResultSet rSet = pstmt.executeQuery();
			if (rSet.next()) {
				user = new User();
				user.setUsername(rSet.getString("username"));
				user.setPassword(rSet.getString("password"));
			}
			/* System.out.println(username.toString()); */
			connection.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static List<User> getAllUser() throws Exception{
		
		List<User> lists = new ArrayList<User>();
		try {
			SQL = "select * from user";
			DButils dButils = new DButils();
			Connection connection = dButils.getConnection();
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				lists.add(user);
			}
			connection.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return lists;
	}
	
	
}
