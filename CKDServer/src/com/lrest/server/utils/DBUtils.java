package com.lrest.server.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lrest.server.constant.Constants;
import org.jooq.Record;
import org.jooq.Result;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Collection;
import java.util.Map;

/**
 * DESCRIPTION: aa
 *
 * @Author 韩武洽
 * @Date 2016-11
 * @Time 04 14:06
 **/
public class DBUtils {
    public static final String filterStr = "gch_user_general.";

    // 防止其他类调用
    private DBUtils(){

    }

    //将查询数据转换为jsonArray
    public static JsonArray dataChangeJsonArray(Result<Record> record) {
        try {
            // 元数据的数量
            int count = record.fieldsRow().size();
            String[] colNames = new String[count];
            String field = "";
            for(int i = 0; i < count; i++){
                // 字段名称
                field = record.field(i).toString();
                if (field.contains(".")) {
                    colNames[i] = field.substring(field.lastIndexOf(".") + 1,field.length());
                }
                else {
                    colNames[i] = field;
                }
            }

            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            // 循环结果集列表条数
            for (int i = 0,ii = record.size(); i < ii; i++) {
                jsonObject = new JsonObject();
                // 循环无数据字段量
                for (int j = 0; j < count; j++) {
                    jsonObject.addProperty(
                            colNames[j].replaceAll("\"",""),
                            record.getValue(i,j) != null ? record.getValue(i,j).toString() : "");
                }
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //将查询数据转换为jsonObject
    public static JsonObject dataChangeJsonObject(Record record) {
        try {
            JsonObject jsonObject = new JsonObject();
            if (record != null) {
                // 元数据的数量
                int count = record.fieldsRow().size();
                String[] colNames = new String[count];
                String field = "";
                for(int i = 0; i < count; i++){
                    // 字段名称
                    field = record.field(i).toString();
                    if (field.contains(".")) {
                        colNames[i] = field.substring(field.lastIndexOf(".") + 1,field.length());
                    }
                    else {
                        colNames[i] = field;
                    }
                }
                for (int j = 0; j < count; j++) {
                    jsonObject.addProperty(
                            colNames[j].replaceAll("\"",""),
                            record.getValue(j) != null ? record.getValue(j).toString() : "");
                }

                return jsonObject;
            } else  {
                return  jsonObject;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------------------------------------------------

    /**.
     * @param result 返回的list对象
     * @param rs  返回rs结果集
     * @author 韩武洽
    [2015年7月3日 上午10:27:48]
     */
    public static void getDatas(Collection result, ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();//元数据信息

            int count = rsmd.getColumnCount();//字段数量

            String[] colNames = new String[count];

            for(int i=1; i<=count; i++){
                colNames[i-1] = rsmd.getColumnLabel(i).toLowerCase();//字段名称(别名)
            }
            while(rs.next()){
                JsonObject item=new JsonObject();
                for(int i=1;i<=count;i++){
                    if (rsmd.getColumnTypeName(i) == "VARCHAR") {
                        if (rs.getString(colNames[i-1]) == null) {
                            item.addProperty(colNames[i-1], "");
                        } else {
                            item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                        }
                    }

                    else if (rsmd.getColumnTypeName(i) == "INT"
                            || rsmd.getColumnTypeName(i) == "LONG"
                            || rsmd.getColumnTypeName(i) == "BIGINT"
                            ||rsmd.getColumnTypeName(i) == "DECIMAL") {
                        if (rs.getString(colNames[i-1])  != null) {
                            item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                        } else {
                            item.addProperty(colNames[i-1], Constants.INT_ZERO);
                        }
                    }

                    else if (rsmd.getColumnTypeName(i) == "INT UNSIGNED") {
                        if (rs.getString(colNames[i-1])  != null) {
                            item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                        } else {
                            item.addProperty(colNames[i-1], Constants.INT_ZERO);
                        }
                    }
                    else{
                        item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                    }
                }
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**.
     *
     * @param rs  返回rs结果集
     *          但此方法是通过<code>Map</code>类put方法进行操作的
     * @author 韩武洽
    [2015年7月3日 上午10:27:48]
     */
    public static void getDatas(JsonArray jsonArray,ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();//元数据信息

            int count = rsmd.getColumnCount();//字段数量
            String[] colNames = new String[count];
            for(int i=1; i<=count; i++){
                colNames[i-1] = rsmd.getColumnLabel(i).toLowerCase();//字段名称(别名)
            }
            while(rs.next()){
                JsonObject item=new JsonObject();
                for(int i=1;i<=count;i++){
                    if (rsmd.getColumnTypeName(i) == "VARCHAR") {
                        if (rs.getString(colNames[i-1]) == null) {
                            item.addProperty(colNames[i-1], "");
                        } else {
                            item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                        }
                    }

                    else if (rsmd.getColumnTypeName(i) == "INT"
                            || rsmd.getColumnTypeName(i) == "LONG"
                            || rsmd.getColumnTypeName(i) == "BIGINT"
                            ||rsmd.getColumnTypeName(i) == "DECIMAL") {
                        if (rs.getString(colNames[i-1])  != null) {
                            item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                        } else {
                            item.addProperty(colNames[i-1], Constants.INT_ZERO);
                        }
                    }

                    else if (rsmd.getColumnTypeName(i) == "INT UNSIGNED") {
                        if (rs.getString(colNames[i-1])  != null) {
                            item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                        } else {
                            item.addProperty(colNames[i-1], Constants.INT_ZERO);
                        }
                    }
                    else{
                        item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                    }
                }
                jsonArray.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**.
     * @param jsonArray JsonArray
     * @param rs  ResultSet
     * @param dataFormatter 格式化的时间戳
     * @author 韩武洽
    [2015年7月14日 上午11:00:33]
     */
    public static void getDatas(JsonArray jsonArray,ResultSet rs, String dataFormatter) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();//元数据信息

            int count = rsmd.getColumnCount();//字段数量

            String[] colNames = new String[count];

            for(int i=1; i<=count; i++){
                colNames[i-1] = rsmd.getColumnLabel(i).toLowerCase();//字段名称(别名)
            }
            while(rs.next()){
                JsonObject item=new JsonObject();
                for(int i=1;i<=count;i++){

                    //对时间戳类型进行封装
                    if (rsmd.getColumnTypeName(i) == "TIMESTAMP") {
                        item.addProperty(colNames[i-1], DateUtil.timestampToStr(
                                rs.getTimestamp(rsmd.getColumnLabel(i)),dataFormatter));
                    }
                    else if (rsmd.getColumnTypeName(i) == "VARCHAR") {
                        if (rs.getString(colNames[i-1]) == null) {
                            item.addProperty(colNames[i-1], "");
                        } else {
                            item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                        }
                    }

                    //对BIT类型进行封装
                    else if (rsmd.getColumnTypeName(i) == "BIT") {
                        item.addProperty(colNames[i-1], (rs.getBoolean(colNames[i-1])) ? 1 : 0);
                    }

                    else if (rsmd.getColumnTypeName(i) == "INT UNSIGNED") {
                        item.addProperty(colNames[i-1], Constants.INT_ZERO);
                    }

                    else{
                        item.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                    }
                }
                jsonArray.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void getDatas(JsonObject jsonbject,ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();//元数据信息

            int count = rsmd.getColumnCount();//字段数量

            String[] colNames = new String[count];

            for(int i=1; i<=count; i++){
                colNames[i-1] = rsmd.getColumnLabel(i).toLowerCase();//字段名称(别名)
            }
            while(rs.next()){

                for(int i=1;i<=count;i++){

                    if (rsmd.getColumnTypeName(i) == "VARCHAR") {
                        if (rs.getString(colNames[i-1]) == null) {
                            jsonbject.addProperty(colNames[i-1], "");
                        } else {
                            jsonbject.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                        }
                    }
                    else if (rsmd.getColumnTypeName(i) == "INT"
                            || rsmd.getColumnTypeName(i) == "LONG"
                            || rsmd.getColumnTypeName(i) == "BIGINT"
                            ||rsmd.getColumnTypeName(i) == "DECIMAL") {
                        if (rs.getString(colNames[i-1])  != null) {
                            jsonbject.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                        } else {
                            jsonbject.addProperty(colNames[i-1], Constants.INT_ZERO);
                        }
                    }
                    //对BIT类型进行封装
                    else if (rsmd.getColumnTypeName(i) == "BIT") {
                        jsonbject.addProperty(colNames[i-1],(rs.getBoolean(colNames[i-1])) ? 1 : 0);
                    }

                    else if (rsmd.getColumnTypeName(i) == "INT UNSIGNED") {
                        jsonbject.addProperty(colNames[i-1], Constants.INT_ZERO);
                    }

                    else{
                        jsonbject.addProperty(colNames[i-1], rs.getString(colNames[i-1]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getDatas(Map<String,Object> map, ResultSet rs, String dataFormatter) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();//元数据信息

            int count = rsmd.getColumnCount();//字段数量

            String[] colNames = new String[count];

            for(int i=1; i<=count; i++){
                colNames[i-1] = rsmd.getColumnLabel(i).toLowerCase();//字段名称(别名)
            }
            while(rs.next()){
//	          JsonObject item=new JsonObject();
                for(int i=1;i<=count;i++){

                    //对时间戳类型进行封装
                    if (rsmd.getColumnTypeName(i) == "TIMESTAMP") {
                        map.put(colNames[i-1], DateUtil.timestampToStr(
                                rs.getTimestamp(rsmd.getColumnLabel(i)),dataFormatter));
                    }
                    //对BIT类型进行封装
                    else if (rsmd.getColumnTypeName(i) == "BIT") {
                        map.put(colNames[i-1],(rs.getBoolean(colNames[i-1]))?1:0);
                    }
                    else{
                        map.put(colNames[i-1], rs.getString(colNames[i-1]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**.
     * @param result  返回的list对象
     * @param rs  返回rs结果集
     * @param clazz 类的class对象 @see <code>T_ORGMENU.class</code>
     * @return  此方法是通过调用类<code>Class<T></code>类中的setter方法赋值的
     * @author  韩武洽 [2015年7月2日 下午8:58:16]
     */
    public static Collection getDatas(Collection result, ResultSet rs, Class clazz) {
        try {
            while (rs.next()) {
                // 创建类的实例
                Object vo = clazz.newInstance();
                // 获取本对象的属性
                Field[] fields = clazz.getDeclaredFields();
                // 获取父类的属性
                // Field[] superFields = clazz.getSuperclass().getDeclaredFields();
                // //父类的属性和自己的属性相加
                // Field[] allFields = addFields(superFields, fields);
                // 遍历所有的属性
                for (Field field : fields) {

                    // 获得setter方法的方法名
                    String setterMethodName = getSetterMethodName(field.getName());

                    // 获得setter方法
                    if (!setterMethodName.equals("setSerialVersionUID")) {
                        Method setterMethod = clazz.getMethod(setterMethodName,field.getType());
                        invokeMethod(rs, field, vo, setterMethod);
                    }

                }
                result.add(vo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 执行一个方法, 从ResultSet中获取一个字段的数据, 调用vo的setter方法
    private static void invokeMethod(ResultSet rs, Field field, Object vo,
                                     Method setterMethod) {
        try {
            // 当使用ResultSet获取某个字段的时候, 如果没有该字段, 会出现SQLException, 在这里忽略该异常
            String value = rs.getString(field.getName());
            // 从ResultSet中获取与该对象属性名一致的字段, 并执行setter方法
            setterMethod.invoke(vo, value);

        } catch (Exception e) {
            // 忽略异常
        }
    }

    // 根据属性名获得setter方法的方法名
    private static String getSetterMethodName(String fieldName) {
        String begin = fieldName.substring(0, 1).toUpperCase();
        String end = fieldName.substring(1, fieldName.length());
        String methodName = "set" + begin + end;
        return methodName;
    }
















}
