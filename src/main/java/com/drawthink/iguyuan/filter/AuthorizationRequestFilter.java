package com.drawthink.iguyuan.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.drawthink.iguyuan.utils.Base64;
import com.drawthink.iguyuan.utils.Des3;
import com.google.common.base.Strings;

@Provider
@PreMatching
public class AuthorizationRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		String authStr = Strings.nullToEmpty(requestContext.getHeaderString("your auth"));
		if(Strings.isNullOrEmpty(authStr)){
			requestContext.abortWith(Response
					.status(Response.Status.UNAUTHORIZED)
					.entity("REQUEST UNAUTHORIZED")
					.build());
		}else{
			byte[] base64DecodeStr = Base64.decode(authStr);
			byte[] desDecodeStr;
			try {
				desDecodeStr = Des3.des3DecodeCBC(Des3.secretKey, Des3.iv, base64DecodeStr);
				String decodeStr = new String(desDecodeStr);
				if(!decodeStr.startsWith("auth keys")){
					requestContext.abortWith(Response
							.status(Response.Status.UNAUTHORIZED)
							.entity("ENCRYPTION ERROR")
							.build());
				}
			} catch (Exception e) {
				requestContext.abortWith(Response
						.status(Response.Status.UNAUTHORIZED)
						.entity("ENCRYPTION ERROR")
						.build());
				e.printStackTrace();
			}
		}
	}
}
