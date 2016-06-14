package com.drawthink.iguyuan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.drawthink.iguyuan.dao.AdvertisementDao;
import com.drawthink.iguyuan.model.ConvenientBanner;
import com.drawthink.iguyuan.model.Splash;

@Resource
public class AdvertisementDaoImpl implements AdvertisementDao {

	@Override
	public Splash getSplash() {
		// TODO 等待数据库表
		Splash splash = new Splash();
		splash.setAdvertisement("http://img1.imgtn.bdimg.com/it/u=2209935342,4126101605&fm=21&gp=0.jpg");
		return splash;
	}

	@Override
	public List<ConvenientBanner> getConvenientBanner() {
		// TODO 等待数据库表
		List<ConvenientBanner> list = new ArrayList<>();
		ConvenientBanner convenientBanner1 = new ConvenientBanner();
		convenientBanner1.setImage("http://img4.imgtn.bdimg.com/it/u=3362729433,2556301463&fm=21&gp=0.jpg");
		convenientBanner1.setUrl("http://www.baidu.com");
		list.add(convenientBanner1);
		ConvenientBanner convenientBanner2 = new ConvenientBanner();
		convenientBanner2.setImage("http://img0.imgtn.bdimg.com/it/u=1276008914,611451016&fm=21&gp=0.jpg");
		convenientBanner2.setUrl("http://www.baidu.com");
		list.add(convenientBanner2);
		ConvenientBanner convenientBanner3 = new ConvenientBanner();
		convenientBanner3.setImage("http://imgsrc.baidu.com/forum/w=580/sign=159ab41af51f3a295ac8d5c6a927bce3/f02eacaf2edda3cce517ade404e93901203f921f.jpg");
		convenientBanner3.setUrl("http://www.baidu.com");
		list.add(convenientBanner3);
		return list;
	}

}
