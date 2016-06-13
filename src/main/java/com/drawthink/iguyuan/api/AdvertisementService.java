package com.drawthink.iguyuan.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.drawthink.iguyuan.manager.AdvertisementManager;
import com.drawthink.iguyuan.vo.BaseResponse;

@Path("advertisement")
public class AdvertisementService {

	@Inject AdvertisementManager manager ;

	@GET
	@Path("splash")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSplah(){
		BaseResponse<String> entity = new BaseResponse<>(manager.getSplash());
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge((int)TimeUnit.HOURS.toSeconds(1));
		return Response.status(200)
				.cacheControl(cacheControl)
				.entity(entity).build();
	}
	
	@GET
	@Path("convenientBanner")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConvenientBanner(){
		BaseResponse<List<String>> entity = new BaseResponse<>(manager.getConvenientBanner());
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge((int)TimeUnit.HOURS.toSeconds(1));
		return Response.status(200)
				.cacheControl(cacheControl)
				.entity(entity).build();
	}

}
