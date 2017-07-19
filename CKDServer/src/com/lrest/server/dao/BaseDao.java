package com.lrest.server.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lrest.server.services.DB;
import com.lrest.server.utils.DBUtils;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;


public class BaseDao<T> {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int result = 0;
    private Class<T> persistentClass;

    DB db = new DB();

    // 定义父级公共参数 供子类使用
    public JsonObject jsonObject = new JsonObject();
    public JsonArray jsonArray = new JsonArray();

    public BaseDao() {
    }

    /**
     * @Author: @韩武洽 @Wyshown
     * @Return: 和实体类匹配 查询出所有的匹配项
     * @Date: 2017/7/18 22:38
     */
    public JsonObject getJsonByBean(JsonObject obj) throws Exception {
        JsonObject resultJson = new JsonObject();
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        persistentClass = (Class<T>) type.getActualTypeArguments()[0];
        try {
            Method[] methods = persistentClass.getMethods();
            String methodName = "";
            String entityName = "";
            //进行循环
            for (Method method : methods) {
                //判断方法上是否存在Column这个注解
                if (method.isAnnotationPresent(Column.class)) {
                    Column col = method.getAnnotation(Column.class);
                    methodName = method.getName();
                    entityName = subStrMethodNameToEntityName(methodName);
                    if (obj.has(entityName)) {
                        resultJson.add(col.name(), obj.get(entityName));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return resultJson;
    }

    /**
     * @return 根据属性名查询(properyName为属性名
     * @throws SQLException
     */
    public JsonArray findByPropery(String properyName, Object properyValue) throws Exception {
        JsonArray jsonArray = new JsonArray();
        try {
            conn = db.getConn();
            ParameterizedType type = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            persistentClass = (Class<T>) type.getActualTypeArguments()[0];

            String sql = "select * from " + persistentClass.getAnnotation(Table.class).name()
                    + " where " + properyName + " =\"" + properyValue + "\"";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            DBUtils.getDatas(jsonArray, rs);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            db.closeMemory(conn, ps, rs);
        }
        return jsonArray;
    }

    /**
     * @Author: @韩武洽 @Wyshown
     * @Return: 保存(参数为字符串)加入事务管理中
     * @Date: 2017/7/18 22:58
     */
    @SuppressWarnings({"unchecked"})
    public int save(Connection conn, JsonObject json) throws Exception {
        try {
            if (conn == null) {
                return 0;
            }

            Iterator<Map.Entry<String, JsonElement>> keys = json.entrySet().iterator();
            Iterator<Map.Entry<String, JsonElement>> valuekeys = json.entrySet().iterator();
            ParameterizedType type = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            persistentClass = (Class<T>) type.getActualTypeArguments()[0];
            StringBuffer sql = new StringBuffer();
            sql.append("insert into " + persistentClass.getAnnotation(Table.class).name() + " ( ");
            while (keys.hasNext()) {
                sql.append(keys.next().getKey().toString() + ",");
            }
            // 去除最后一个多余的逗号
            sql.deleteCharAt(sql.length() - 1);
            sql.append(") VALUES (");
            while (valuekeys.hasNext()) {
                sql.append("\"" + valuekeys.next().getValue().getAsString().replaceAll("\"", "\'") + "\",");
            }
            // 去除最后一个多余的逗号
            sql.deleteCharAt(sql.length() - 1);
            sql.append(")");

            ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            DB.closeMemory(conn, ps);
        }
        return result;

    }

    /**
     * @Author: @韩武洽 @Wyshown
     * @Return: 更新(部分字段，不需要全部的字段, id为必须的)加入事务管理中
     * @Date: 2017/7/18 22:54
     */
    public int update(Connection conn, JsonObject json) throws Exception {
        try {
            if (conn == null) {
                return 0;
            }
            ParameterizedType type = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            persistentClass = (Class<T>) type.getActualTypeArguments()[0];
            StringBuffer sql = new StringBuffer();
            sql.append("update " + persistentClass.getAnnotation(Table.class).name() + " set ");

            int id = json.get("ID").getAsInt();
            // 去除字符串中ID
            json.remove("ID");

            if (!json.isJsonNull() && json.isJsonObject()) {
                //json为空时则不操作
                Iterator<Map.Entry<String, JsonElement>> keys = json.entrySet().iterator();
                Map.Entry<String, JsonElement> map;
                while (keys.hasNext()) {
                    map = keys.next();
                    sql.append(map.getKey().toString() + "= " + "\"" + map.getValue().getAsString().replaceAll("\"", "\'") + "\",");
                }
                sql.deleteCharAt(sql.length() - 1);
                sql.append(" where id =" + id);
                json.addProperty("id", id);//把Id再加上，后面可能会用到
                ps = conn.prepareStatement(sql.toString());
                ps.executeUpdate();
                result = id;
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            DB.closeMemory(ps);
        }
        return result;
    }

    /**
     * @param methodName
     * @return 去掉方法的前三个 并把第4个设置为小写 如： getName ==> name
     */
    public static String subStrMethodNameToEntityName(String methodName) {
        return methodName.substring(3, 4).toLowerCase() + methodName.substring(4, methodName.length());
    }

}
