package com.drawthink.iguyuan.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.drawthink.iguyuan.config.ConfigVar;
import com.drawthink.iguyuan.constants.ExceptionKeys;
import com.drawthink.iguyuan.vo.BaseException;
import com.drawthink.iguyuan.vo.BaseResponse;
import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;

@Path("file")
public class FileService {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> upload(@FormDataParam("file") InputStream fis,
			@FormDataParam("file") FormDataContentDisposition disposition){
		if(Strings.isNullOrEmpty(disposition.getFileName())){
			throw new BaseException(ExceptionKeys.FILE_UPLOAD_FAILE,"文件为空");
		}
		String refileName = Calendar.getInstance().getTimeInMillis() + "." +
        				Files.getFileExtension(disposition.getFileName());
		String saveFilePath = ConfigVar.getUploadImageStoreDir()
				+File.separator
				+refileName;
		File imageFloder = new File(ConfigVar.getUploadImageStoreDir());
		if(!imageFloder.exists()){
			imageFloder.mkdirs();
		}
        File file = new File(saveFilePath);    
		OutputStream os;
		try {
			os = new FileOutputStream(file);
			ByteStreams.copy(fis, os);
			BaseResponse<String> response = new BaseResponse<>(ConfigVar.getUplaodImageURL()+refileName);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
			throw new BaseException(ExceptionKeys.FILE_UPLOAD_FAILE,e.getCause());
		}
		
	}

}
