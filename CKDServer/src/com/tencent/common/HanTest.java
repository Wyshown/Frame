package com.tencent.common;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by Administrator on 2017/7/19.
 */
public class HanTest {

    public static void main(String arg[]){
        JsonObject baseJson = new JsonObject();
        baseJson.addProperty("code","");
        baseJson.addProperty("desc","");

        JsonArray jsonArray = new JsonArray();
        jsonArray.add(baseJson);
        jsonArray.add(baseJson);

        new HanTest().test(1,"成功",19,jsonArray);
    }

    public  void test(Integer code,String desc,Integer count,JsonArray jsonArray) {
        JsonObject baseJson = new JsonObject();
        JsonObject dataJson = new JsonObject();
        baseJson = new JsonObject();
        dataJson = new JsonObject();
        baseJson.addProperty("code",code);
        baseJson.addProperty("desc",desc);
        dataJson.addProperty("count",count);
        dataJson.add("data",jsonArray);
        baseJson.add("data",dataJson);
        System.out.println(baseJson);
    }
}
