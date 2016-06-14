package com.drawthink.iguyuan.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DBConnect {

	public static DruidDataSource dataSource;  
	static {  
		try {  
			dataSource = new DruidDataSource();  
			dataSource.setUsername("sa");  
			dataSource.setPassword("*windows*");  
			dataSource.setUrl("jdbc:sqlserver://192.168.0.168:2433;databaseName=ZHGY");  
			dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			dataSource.setFilters("stat");
			dataSource.setMaxActive(20);
			dataSource.setInitialSize(1);  
			dataSource.setMaxWait(60000);  
			dataSource.setTimeBetweenEvictionRunsMillis(60000); 
			dataSource.setMinEvictableIdleTimeMillis(300000);
			dataSource.setPoolPreparedStatements(true);
			dataSource.setMaxOpenPreparedStatements(20);
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}  
	/** 
	 * 从连接池中获取数据源链接 
	 *  
	 * @author gaoxianglong 
	 *  
	 * @return Connection 数据源链接 
	 */  
	public static DruidPooledConnection getConnection() {  
		DruidPooledConnection conn = null;  
		if (null != dataSource) {  
			try {  
				conn = dataSource.getConnection();  
			} catch (SQLException e) {  
				e.printStackTrace();  
			}  
		}  
		return conn;  
	}
}
