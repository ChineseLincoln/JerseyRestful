package com.drawthink.iguyuan.manager.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import com.drawthink.iguyuan.dao.AreaDao;
import com.drawthink.iguyuan.manager.AreaManager;
import com.drawthink.iguyuan.model.City;
import com.drawthink.iguyuan.model.County;
import com.drawthink.iguyuan.model.Province;

@Resource
public class AreaManagerImpl implements AreaManager{
	
	@Inject
	AreaDao areaDao;

	@Override
	public List<Province> getProvince() {
		return areaDao.getProvince();
	}

	@Override
	public List<City> getCity(String province) {
		return areaDao.getCity(province);
	}

	@Override
	public List<County> getCounty(String city) {
		return areaDao.getCounty(city);
	}

	
	
}
