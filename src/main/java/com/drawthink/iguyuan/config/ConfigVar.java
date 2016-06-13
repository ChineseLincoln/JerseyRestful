package com.drawthink.iguyuan.config;

public class ConfigVar {
	public static final String URL="http://192.168.0.46";
	public static final String PORT = ":8080";
	public static final String PROJECT = "/";
	public static final String UPLOAD_IMAGE_FLODER  = "image/";
	
	public static final String PUBLISHER_DIR = "/home/lincoln/AndroidStudioWorkSpace/GuYuanProject/Code/IGuYuanJerseyApi/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/iguyuan.api/";
	
	public static final String getUplaodImageURL(){
		return URL+PORT+PROJECT+UPLOAD_IMAGE_FLODER;
	}
	
	public static final String getUploadImageStoreDir(){
		return PUBLISHER_DIR + UPLOAD_IMAGE_FLODER;
	}
}
