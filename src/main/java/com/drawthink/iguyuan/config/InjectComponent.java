package com.drawthink.iguyuan.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.drawthink.iguyuan.dao.AdvertisementDao;
import com.drawthink.iguyuan.dao.AreaDao;
import com.drawthink.iguyuan.dao.impl.AdvertisementDaoImpl;
import com.drawthink.iguyuan.dao.impl.AreaDaoImpl;
import com.drawthink.iguyuan.manager.AdvertisementManager;
import com.drawthink.iguyuan.manager.AreaManager;
import com.drawthink.iguyuan.manager.impl.AdvertisementManagerImpl;
import com.drawthink.iguyuan.manager.impl.AreaManagerImpl;

public class InjectComponent extends AbstractBinder{

	@Override
	protected void configure() {
		//inject AdvertisementService
		bind(AdvertisementManagerImpl.class).to(AdvertisementManager.class);
		bind(AdvertisementDaoImpl.class).to(AdvertisementDao.class);
		
		//inject AreaService
		bind(AreaManagerImpl.class).to(AreaManager.class);
		bind(AreaDaoImpl.class).to(AreaDao.class);
		
		
	}

}
