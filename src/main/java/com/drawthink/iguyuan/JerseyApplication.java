package com.drawthink.iguyuan;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.drawthink.iguyuan.config.FastJsonFeature;
import com.drawthink.iguyuan.config.InjectComponent;
import com.drawthink.iguyuan.exceptions.ExceptionMappingResource;
import com.drawthink.iguyuan.filter.AuthorizationRequestFilter;

@ApplicationPath("/api")
public class JerseyApplication extends ResourceConfig {
    public JerseyApplication() {
        packages("com.drawthink.iguyuan.api");
        register(LoggingFeature.class);
        register(MultiPartFeature.class);
        register(FastJsonFeature.class);
        register(ExceptionMappingResource.class);
        register(new InjectComponent());
//        register(AuthorizationRequestFilter.class);
    }
}