package com.drawthink.iguyuan.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.drawthink.iguyuan.dao.AreaDao;
import com.drawthink.iguyuan.db.DBConnect;
import com.drawthink.iguyuan.model.City;
import com.drawthink.iguyuan.model.County;
import com.drawthink.iguyuan.model.Province;

@Resource
public class AreaDaoImpl implements AreaDao {


	public List<Province> getProvince(){
		final String sql = "Select dataName as provinceId, dataValue as provinceName "
				+ "From dic_Content "
				+ "Where dtid=71 "
				+ "And dataValue Like '__0000' "
				+ "Order By cSort, dcid, dataValue";
		DruidPooledConnection conn = DBConnect.getConnection();  
		List<Province> result = new ArrayList<>();
		try {  
			result = new QueryRunner().query(conn ,sql, new BeanListHandler<Province>(Province.class));
		} catch (Exception e) {  
			e.printStackTrace();  
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		return result;
	}

	@Override
	public List<City> getCity(String province) {
		final String sql = "Select dataName as cityName, dataValue as cityId"
				+ " From dic_Content "
				+ "Where dtid=71 "
				+ "And dataValue Like '"+province.substring(0,2)+"%' "
				+ "And dataValue Like '____00' "
				+ "And dataValue Not Like '__0000' "
				+ "Order By cSort, dcid, dataValue";
		DruidPooledConnection conn = DBConnect.getConnection();  
		List<City> result = new ArrayList<>();
		try {  
			result = new QueryRunner().query(conn ,sql, new BeanListHandler<City>(City.class));
		} catch (Exception e) {  
			e.printStackTrace();  
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		return result;
	}

	@Override
	public List<County> getCounty(String city) {
		final String sql="Select dataName as countyName, dataValue as countyId "
				+ "From dic_Content "
				+ "Where dtid=71 "
				+ "And dataValue Like '"+city.substring(0,4)+"%' "
				+ "And dataValue Not Like '____00' "
				+ "Order By cSort, dcid, dataValue ";
		DruidPooledConnection conn = DBConnect.getConnection();  
		List<County> result = new ArrayList<>();
		try {  
			result = new QueryRunner().query(conn ,sql, new BeanListHandler<County>(County.class));
		} catch (Exception e) {  
			e.printStackTrace();  
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		return result;
	}
}
