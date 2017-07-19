package com.lrest.server;

/**
 * Created by angrycans on 15/7/7.
 */

import com.lrest.server.services.*;
import com.lrest.server.services.session.SessionManager;


import com.mysql.jdbc.StringUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.container.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;


@PreMatching
public class RequestFilter implements ContainerRequestFilter {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    private SystemManager systemManager;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MultivaluedMap<String, String> requestheaders = requestContext.getHeaders();
//        log.debug("Executing REST RequestFilter getAbsolutePath >" + requestContext.getUriInfo().getAbsolutePath());
//        log.debug("Executing REST RequestFilter header >" + requestContext.getUriInfo().getPath());
//        log.debug("Executing REST RequestFilter getMethod >" + requestContext.getMethod());

        if (systemManager.SYSCODE != 1) {
//            log.error("System error " + systemManager.dump());
            requestContext.abortWith(Response.status(Response.Status.EXPECTATION_FAILED).entity(systemManager.LASTERR).build());
            return;
        }

        if (requestContext.getMethod().equalsIgnoreCase("options")) {
            MultivaluedMap<String, String> headers = requestContext.getHeaders();
            requestContext.abortWith(Response.ok().build());
            return;
        }

        ArrayList<String> ignorelist = new ArrayList<String>();
        ignorelist.add("/");
        ignorelist.add("login/");
        ignorelist.add("nl/");

        String urlpath = requestContext.getUriInfo().getPath() + "/";
        for (int i = 0; i < ignorelist.size(); i++) {
            if (urlpath.substring(0, urlpath.indexOf("/") + 1).equalsIgnoreCase(ignorelist.get(i))) {
//                log.info("no login enter");
                return;
            }
        }

        String sid = requestContext.getHeaderString("sessionid");
        if (StringUtils.isNullOrEmpty(sid)) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(systemManager.LASTERR).build());
            return;
        } else {
//            log.debug("sid =" + sid);
            String authsid = SessionManager.getInstance().getSID(sid);
//            log.debug("sid =" + sid + " authsid=" + authsid);
            if (StringUtils.isNullOrEmpty(authsid)) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                return;
            }

        }
    }
}


