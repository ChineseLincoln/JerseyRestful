package com.drawthink.iguyuan.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.drawthink.iguyuan.manager.AdvertisementManager;

@Resource
public class AdvertisementManagerImpl implements AdvertisementManager{

	@Override
	public String getSplash() {
		return "1.png";
	}

	@Override
	public List<String> getConvenientBanner() {
		List<String> list = new ArrayList<>();
		list.add("1.png");
		list.add("2.png");
		list.add("3.png");
		return list;
	}

}
