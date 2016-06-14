package com.drawthink.iguyuan.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.drawthink.iguyuan.manager.AreaManager;
import com.drawthink.iguyuan.model.City;
import com.drawthink.iguyuan.model.County;
import com.drawthink.iguyuan.model.Province;
import com.drawthink.iguyuan.vo.BaseResponse;

@Path("area")
public class AreaService {
	
	@Inject
	AreaManager areaManager;
	
	@GET
	@Path("province")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProvince(){
		BaseResponse<List<Province>> entity = new BaseResponse<>(areaManager.getProvince());
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge((int)TimeUnit.DAYS.toSeconds(1)*365);
		return Response.status(200)
				.cacheControl(cacheControl)
				.entity(entity).build();
	}
	
	@GET
	@Path("city")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCity(@QueryParam(value = "provinceId") String provinceId){
		BaseResponse<List<City>> entity = new BaseResponse<>(areaManager.getCity(provinceId));
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge((int)TimeUnit.DAYS.toSeconds(1)*365);
		return Response.status(200)
				.cacheControl(cacheControl)
				.entity(entity).build();
	}
	
	@GET
	@Path("county")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCounty(@QueryParam(value = "cityId") String cityId){
		BaseResponse<List<County>> entity = new BaseResponse<>(areaManager.getCounty(cityId));
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge((int)TimeUnit.DAYS.toSeconds(1)*365);
		return Response.status(200)
				.cacheControl(cacheControl)
				.entity(entity).build();
	}
}
