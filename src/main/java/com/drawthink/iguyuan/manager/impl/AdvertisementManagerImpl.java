package com.drawthink.iguyuan.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import com.drawthink.iguyuan.dao.AdvertisementDao;
import com.drawthink.iguyuan.manager.AdvertisementManager;
import com.drawthink.iguyuan.model.ConvenientBanner;
import com.drawthink.iguyuan.model.Splash;

@Resource
public class AdvertisementManagerImpl implements AdvertisementManager{
	
	@Inject
	AdvertisementDao dao;

	@Override
	public Splash getSplash() {
		return dao.getSplash();
	}

	@Override
	public List<ConvenientBanner> getConvenientBanner() {
		return dao.getConvenientBanner();
	}

}
