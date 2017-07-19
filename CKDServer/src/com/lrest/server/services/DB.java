package com.lrest.server.services;

/**
 * Created by acans on 16/6/17.
 */

import com.zaxxer.hikari.HikariDataSource;

import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.sql.*;

@Singleton
public class DB {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    private static HikariDataSource dataSource;
    //static private   Connection driverConnection;
    //private Statement driverStatement;


    public DB(){

            dbinit();

    }


    public void dbinit()
    {
//        log.debug("init db");

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            DatabasePool Pooling = new DatabasePool();
            if (!Pooling.getStoragePooling())
            {
                return;
            }
            this.dataSource = Pooling.getDatabase();

            //this.driverConnection = this.dataSource.getConnection();
           // this.driverStatement = this.driverConnection.createStatement();
            SystemManager.putCode(1,1,"");

//            log.debug("db init ok");
        }

        catch (Exception e)
        {
            e.printStackTrace();

            SystemManager.putCode(-1,1,"mysql error");
//            log.debug("init db error");
        }
    }

    public static  Connection getConn(){
        try {

            return dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void quit(){

        dataSource.close();
    }

    public HikariDataSource getDataSource()
    {
        return this.dataSource;
    }

    public   void testDb(){
        try{
            PreparedStatement ps;
            ResultSet rs;
            String sql="select id from T_USER limit 10";
            ps = DB.getConn().prepareStatement(sql);

            rs=ps.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**.
     * @param conn
     * @param sql
     * @return
     * @author 韩武洽
    [2015年6月24日 下午1:39:48]
     */
    public  static PreparedStatement getPs(Connection conn,String sql){
        PreparedStatement ps = null;
        try {
            ps =  conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    /**.
     * @param conn
     * @param ps
     * @param rs
     * @author 韩武洽
    [2015年6月24日 下午1:47:53]
     */
    public static void closeMemory(Connection conn, PreparedStatement ps, ResultSet rs){

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    /**.
     * @param conn
     * @author 韩武洽
    [2015年6月24日 下午1:47:53]
     */
    public static void closeMemory(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void closeMemory(Connection conn, PreparedStatement ps){

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void closeMemory(PreparedStatement ps){

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
