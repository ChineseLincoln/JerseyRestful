package com.drawthink.iguyuan.config;

import java.io.File;

public class ConfigVar {
	public static final String URL="http://192.168.0.46";
	public static final String PORT = ":8080";
	public static final String PROJECT = "api";
	public static final String UPLOAD_IMAGE_FLODER  = "images";
	
	public static final String getUplaodImageURL(){
		return URL+PORT+"/"+PROJECT+"/"+UPLOAD_IMAGE_FLODER+"/";
	}
	
	public static final String getUploadImageStoreDir(String localPath){
		return localPath + File.separator + UPLOAD_IMAGE_FLODER;
	}
}
