package com.lrest.server;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

@PreMatching
public class ResponseFilter implements ContainerResponseFilter{
    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {

        MultivaluedMap<String, Object> responseheaders = responseContext.getHeaders();
        responseheaders.add("Access-Control-Allow-Origin", "*");
        responseheaders.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
        responseheaders.add("Access-Control-Allow-Headers", " accept, sessionid,content-type,access-control-allow-origin");
    }
}


