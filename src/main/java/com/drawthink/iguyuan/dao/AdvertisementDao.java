package com.drawthink.iguyuan.dao;

import java.util.List;

import com.drawthink.iguyuan.model.ConvenientBanner;
import com.drawthink.iguyuan.model.Splash;

public interface AdvertisementDao {

	Splash getSplash();

	List<ConvenientBanner> getConvenientBanner();
	
}
