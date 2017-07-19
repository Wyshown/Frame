package com.lrest.server.dao.user;

import com.google.gson.JsonArray;
import com.lrest.server.constant.UserConstants;
import com.lrest.server.dao.BaseDao;
import com.lrest.server.entity.user.TRolePermitEntity;
import com.lrest.server.services.DB;
import com.lrest.server.utils.UtilBase;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static com.lrest.server.utils.DBUtils.dataChangeJsonArray;

/**
 @Describe: 权限管理
 @Author: @韩武洽 @Wyshown
 @Date: 2017/7/19 21:06
*/
public class RolePermitDao extends BaseDao<TRolePermitEntity> {

    private JsonArray resultJsonArray;

    /**
     * @Return: 查询角色查询出所有的角色权限
     * @Author: @韩武洽 @Wyshown
     * @Date: 2017/7/19 20:49
     */
    public JsonArray findRolePermitByRoleNum(DSLContext create, Integer roleNum, Integer pid) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT \n");
        sql.append(" funcTree.ID AS id, \n");
        sql.append(" funcTree.PID AS pid, \n");
        sql.append(" funcTree.FUNC_TITLE AS funcTitle, \n");
        sql.append(" funcTree.PLATFORM AS platform, \n");
        sql.append(" funcTree.FUNC_CODE AS funcCode, \n");
        sql.append(" funcTree.SEQ AS seq \n");

        sql.append(" FROM t_role_permit AS rolePermin \n");
        sql.append(" LEFT JOIN t_func_tree AS funcTree ON rolePermin.FUNC_TREE_ID = funcTree.ID \n");
        sql.append(" WHERE rolePermin.ROLE_NUM = '" + roleNum + "' \n");
        sql.append(" AND funcTree.PID = '" + pid + "' \n");
        return dataChangeJsonArray(create.fetch(sql.toString()));
    }

    /**
     * @Return: 查询角色查询出所有的角色权限以为子权限
     * @Author: @韩武洽 @Wyshown
     * @Date: 2017/7/19 20:49
     */
    public JsonArray findRolePermitAndSubPermitByRoleNum(Integer roleNum) {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {
            create.transaction(configuration -> {
                resultJsonArray = new JsonArray();
                this.jsonArray = findRolePermitByRoleNum(create, roleNum, UserConstants.TFuncTreeConstants.FUNC_TREE_PID);

                for (int i = 0; i < this.jsonArray.size(); i++) {
                    this.jsonObject = this.jsonArray.get(i).getAsJsonObject();
                    this.jsonObject.add("nextLevel",
                            findRolePermitByRoleNum(create, roleNum, UtilBase.getJsonAsInt(this.jsonObject, "id")));
                    resultJsonArray.add(this.jsonObject);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJsonArray;
    }
}
