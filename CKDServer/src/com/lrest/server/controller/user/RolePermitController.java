package com.lrest.server.controller.user;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lrest.server.controller.BaseController;
import com.lrest.server.dao.user.RolePermitDao;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.lrest.server.utils.UtilBase.getJsonAsInt;

/**
 @Describe: 权限管理 权限控制
 @Author: @韩武洽 @Wyshown
 @Date: 2017/7/19 21:09
*/
@Path("/rolePermitDao")
public class RolePermitController extends BaseController{

    @Inject
    private RolePermitDao rolePermitDao;


    /**
     @Describe: {"roleNum":"11"}
     @Return: 查询角色查询出所有的角色权限以为子权限
     @Author: @韩武洽 @Wyshown
     @Date: 2017/7/19 21:09
    */
    @POST
    @Path("/findRolePermitAndSubPermitByRoleNum")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JsonObject findRolePermitAndSubPermitByRoleNum(String query) throws Exception {
        try{
            this.jsonObject = new JsonParser().parse(query).getAsJsonObject();
            Integer roleNum = getJsonAsInt(this.jsonObject, "roleNum");
            this.jsonArray = this.rolePermitDao.findRolePermitAndSubPermitByRoleNum(roleNum);
            return success(this.jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }

}
