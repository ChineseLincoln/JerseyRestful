package com.drawthink.iguyuan.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.drawthink.iguyuan.manager.AdvertisementManager;
import com.drawthink.iguyuan.manager.AreaManager;
import com.drawthink.iguyuan.manager.impl.AdvertisementManagerImpl;
import com.drawthink.iguyuan.manager.impl.AreaManagerImpl;

public class InjectComponent extends AbstractBinder{

	@Override
	protected void configure() {
		bind(AdvertisementManagerImpl.class).to(AdvertisementManager.class);
		bind(AreaManagerImpl.class).to(AreaManager.class);
	}

}
