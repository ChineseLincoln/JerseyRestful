package com.drawthink.iguyuan.dao;

import java.util.List;

import com.drawthink.iguyuan.model.City;
import com.drawthink.iguyuan.model.County;
import com.drawthink.iguyuan.model.Province;

public interface AreaDao {

	List<Province> getProvince();

	List<City> getCity(String province);
	
	List<County> getCounty(String city);
}
