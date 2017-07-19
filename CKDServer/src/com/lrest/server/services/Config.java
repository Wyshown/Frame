package com.lrest.server.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Config {
    private static  final Logger log = LoggerFactory.getLogger("Config");
    public static int session_timeout;

    public static int use_mysql;
    public static String mysql_jdbcurl;
    public static String mysql_user;
    public static String mysql_password;

    public static int use_redis;
    public static String redis_ip;
    public static int redis_port;
    public static String OSS;


    private static Config instance = new Config();
    public static Config getInsatnce(){
        return instance;
    }



    private Config(){
        log.info("Config instance create");
        ResourceBundle resourceBoudle = null;

        try {
            resourceBoudle = new PropertyResourceBundle(
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream(
                                    "config/config.properties"));

            this.session_timeout=Integer.parseInt(resourceBoudle.getString("session_timeout"));
            this.use_mysql=Integer.parseInt(resourceBoudle.getString("use_mysql"));
            this.mysql_jdbcurl=resourceBoudle.getString("mysql_jdbcurl");
            this.mysql_user=resourceBoudle.getString("mysql_user");
            this.mysql_password=resourceBoudle.getString("mysql_password");

            this.use_redis=Integer.parseInt(resourceBoudle.getString("use_redis"));
            this.redis_ip=resourceBoudle.getString("redis_ip");
            this.redis_port=Integer.parseInt(resourceBoudle.getString("redis_port"));
            this.OSS=resourceBoudle.getString("OSS");
        } catch (Exception e) {
            e.printStackTrace();
            // LOGGER.error("Error loading messages properties", ex);
        }

    }

}
