package com.lrest.server.controller.food;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lrest.server.controller.BaseController;
import com.lrest.server.dao.food.FoodKindDao;
import com.lrest.server.services.DB;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;

import static com.lrest.server.utils.DBUtils.dataChangeJsonArray;

/**
 * Created by Administrator on 2017/7/18.
 */
@Path("/food")
public class FoodController extends BaseController {

    @Inject
    private FoodKindDao foodDao;

    @POST
    @Path("/posthan")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JsonObject get(String query) throws Exception {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {
            create.transaction(configuration -> {
//                JsonObject json = new JsonParser().parse(query).getAsJsonObject().get("query").getAsJsonObject();
//                this.jsonArray = json.get("payGoods").getAsJsonArray();
                this.jsonObject = new JsonParser().parse(query).getAsJsonObject();

                this.jsonObject = this.foodDao.getJsonByBean(this.jsonObject);

                StringBuffer sql = new StringBuffer();
                sql.append(" SELECT \n");
                sql.append(" kind.ID AS id, \n");
                sql.append(" kind.FOOD_KIND_NAME AS foodKindName, \n");
                sql.append(" kind.FOOD_KIND AS foodKind, \n");
                sql.append(" kind.IMAGE_URL AS imageUrl \n");
                sql.append(" FROM food_food_kind AS kind \n");
                sql.append(" LIMIT 10 \n");
                Result<Record> records = create.fetch(sql.toString());
                 this.jsonArray = dataChangeJsonArray(records);
            });
            return success(this.jsonArray.size(),this.jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }
}
