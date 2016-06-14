package com.drawthink.iguyuan.api;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.drawthink.iguyuan.config.ConfigVar;
import com.drawthink.iguyuan.exceptions.BaseException;
import com.drawthink.iguyuan.exceptions.ExceptionKeys;

@Path("/images/{image}")
public class ImageService {
	
	@Context
	HttpServletRequest request;

	@GET
	@Produces({"image/jpeg","image/gif ","image/png",MediaType.APPLICATION_JSON})
	public Response getImage(@PathParam("image") String image) {
	String localPath = request.getSession().getServletContext().getRealPath("");
	String filePath = ConfigVar.getUploadImageStoreDir(localPath)+File.separator+image;
	  File f = new File(filePath);
	  if (!f.exists()) {
	    throw new BaseException(ExceptionKeys.IMAGE_FILE_NOT_FOUND,404);
	  }
	  return Response.ok(f).header("Accept-Ranges", "bytes").build();
	}
}
