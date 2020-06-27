package com.tianfu.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DButils {
	private static String dbUrl = "jdbc:mysql://localhost:3306/mqtt_data?useUnicode=true&amp;characterEncoding=utf8";
	private static String userName = "root";
	private static String passWord = "ab123654";
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	//获取数据库连接
	public Connection getConnection() throws Exception{
		Class.forName(jdbcName);
		Connection connection= (Connection) DriverManager.getConnection(dbUrl,userName,passWord);
				return connection;
		
	}
	
	//关闭连接
	public void close(Connection connection,Statement statement) throws SQLException {
		if (connection != null) {
			statement.close();
			connection.close();
		}
		
	}
}
