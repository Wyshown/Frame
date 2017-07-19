package com.lrest.server.controller;

/**
 * Created by acans on 16/6/21.
 */

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lrest.server.dao.user.UserDao;
import com.lrest.server.services.DB;
import com.lrest.server.services.session.SessionManager;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.util.UUID;

import static com.lrest.server.utils.DBUtils.dataChangeJsonArray;
import static com.lrest.server.utils.UtilBase.getJsonAsString;

@Path("/login")
public class LoginController extends BaseController {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
    @Inject
    private UserDao userDao;

    /**
     * @Return: 生成sessionid信息
     * @Author: @韩武洽 @Wyshown
     * @Date: 2017/7/19 19:49
     */
    public JsonObject generateSessionIdInfo(String _uid) {
        JsonObject jsonObject = new JsonObject();
        String _token = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        String sid = SessionManager.getInstance().createSID(_token, _uid);
        res.setHeader("sessionid", sid);

        jsonObject.addProperty("sessionid", sid);
        jsonObject.addProperty("token", _token);
        return jsonObject;

    }


    /**
     @Describe: 登录接口
     @Return:
     {"loginName":"ckd","loginPwd":"123456"}
     @Author: @韩武洽 @Wyshown
     @Date: 2017/7/19 20:16
    */
    @POST
    @Path("/doLogIn")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JsonObject doLogin(String query) {
        try {
            this.jsonObject = new JsonParser().parse(query).getAsJsonObject();
            String loginName = getJsonAsString(this.jsonObject, "loginName");
            String loginPwd = getJsonAsString(this.jsonObject, "loginPwd");

            this.jsonObject = this.userDao.doLogin(loginName, loginPwd);
            System.out.println(this.jsonObject.isJsonNull());
            System.out.println(this.jsonObject.isJsonPrimitive());
            System.out.println(this.jsonObject.isJsonObject());
            if (!this.jsonObject.isJsonNull() && !this.jsonObject.equals("{}")) {
                this.jsonObject.add("session", generateSessionIdInfo(getJsonAsString(this.jsonObject, "id")));
                return success(this.jsonObject);
            } else  {
                return error("登录失败,用户不存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }


}
