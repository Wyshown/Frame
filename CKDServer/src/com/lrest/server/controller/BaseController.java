package com.lrest.server.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import java.util.UUID;

/**
 * Created by acans on 16/6/23.
 */
public class BaseController {
    public final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    // 定义父级公共参数 供子类使用
    public JsonObject jsonObject = new JsonObject();
    public JsonArray jsonArray = new JsonArray();

    JsonObject baseJson = new JsonObject();
    JsonObject dataJson = new JsonObject();

    @Context
    public HttpServletRequest req;
    @Context
    HttpServletResponse res;


    public  JsonObject success() {
        baseJson = new JsonObject();
        dataJson = new JsonObject();

        baseJson.addProperty("code",0);
        baseJson.addProperty("desc","success");

        baseJson.add("data",dataJson);
        return baseJson;
    }

    public JsonObject success(JsonObject jsonObject) {
        baseJson = new JsonObject();

        baseJson.addProperty("code",0);
        baseJson.addProperty("desc","success");

        baseJson.add("data",jsonObject);
        return baseJson;
    }

    public JsonObject success(JsonArray jsonArray) {
        baseJson = new JsonObject();

        baseJson.addProperty("code",0);
        baseJson.addProperty("desc","success");

        baseJson.add("data",jsonArray);
        return baseJson;
    }

    public JsonObject success(Integer count,JsonArray jsonArray) {
        baseJson = new JsonObject();
        dataJson = new JsonObject();

        baseJson.addProperty("code",0);
        baseJson.addProperty("desc","success");

        dataJson.addProperty("count",count);
        dataJson.add("data",jsonArray);
        baseJson.add("data",dataJson);
        return baseJson;
    }

    /**
     * @return  返回Json 如下
    {
        "code":"0",
        "desc":"error",
        "data":{}
    }
     */
    public  JsonObject error() {
        baseJson = new JsonObject();
        dataJson = new JsonObject();

        baseJson.addProperty("code",-1);
        baseJson.addProperty("desc","error");

        baseJson.add("data",dataJson);
        return baseJson;
    }

    public  JsonObject error(String desc) {
        baseJson = new JsonObject();
        dataJson = new JsonObject();

        baseJson.addProperty("code",-1);
        baseJson.addProperty("desc",desc);

        baseJson.add("data",dataJson);
        return baseJson;
    }

    public  JsonObject error(int code,String desc) {
        baseJson = new JsonObject();
        dataJson = new JsonObject();

        baseJson.addProperty("code",code);
        baseJson.addProperty("desc",desc);

        baseJson.add("data",dataJson);
        return baseJson;
    }
}