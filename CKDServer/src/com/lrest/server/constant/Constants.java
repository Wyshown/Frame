package com.lrest.server.constant;

/**
 * DESCRIPTION: 用来放通用的常量
 *
 * @Author 韩武洽
 * @Date 2016-09
 * @Time 13 11:52
 **/
public final class Constants {

    private Constants(){

    }

    public static final String STRING_COLLECTION_NULL = "[]";


    /** -------Userinfo_general-----------常量属性-----------------start-------------------  */


    /***角色: 免登录用户 */
    public static final String GENERAL_ROLE_NONEEDLOGIN = "0";
    /***角色: 普通用户 */
    public static final Integer GENERAL_ROLE_GENERALUSER = 1;
    /***角色: 4S店会员(关联到4S店自定管理4S店主键) */
    public static final Integer GENERAL_ROLE_USER4S = 2;
    /***角色: 经销商 */
    public static final Integer GENERAL_ROLE_DEALERSUSER = 3;


    public static final String GENERAL_ID = "-1";
    // 给普通用户默认生成的密码
    public static final String GENERAL_PASSWD = "123456";
    public static final String GENERAL_USER_NAME = "gouchehui";
    public static final String GENERAL_TEL = "10086";
    public static final String GENERAL_EMAIL = "001@qq.com";
    public static final String GENERAL_HEAD_URL = "http://yichenghui.oss-cn-shanghai.aliyuncs.com/gouchehui/web/Upload/headimg/8f14e45fceea167a5a36dedd4bea2543.jpg";
    public static final String GENERAL_NAME = "购车惠";

    public static final String GENERAL_NICK = "1";
    public static final String GENERAL_SEX = "1";
    public static final String GENERAL_BIRTHDAY = "2000-10-10";
    public static final String GENERAL_PROVINCE_ID = "";
    public static final String GENERAL_CITY_ID = "";
    public static final String GENERAL_DISTRICT_ID = "";
    public static final String GENERAL_ADDRESS = "";
    public static final String GENERAL_POSTCODE = "";
    public static final String GENERAL_REMARK = "";

    public static final String GENERAL_SESSESSION_ID = "hanwuqia";
    public static final String GENERAL_SESSION_TOKEN = "hanwuqiaTest";
    public static final String MEMORY_SESSION_CURRENTTIME = "2548980610000";

    /** -------Userinfo_general常量属性-----------------end-------------------  */

    /**
     * Integer类型常量:
     */
    public static final Integer INT_MINUS_ONE = -1;
    public static final Integer INT_MINUS_TWO = -2;
    public static final Integer INT_ZERO = 0;
    public static final Integer INT_ONE = 1;
    public static final Integer INT_TWO = 2;
    public static final Integer INT_THREE = 3;
    public static final Integer INT_FOUR = 4;
    public static final Integer INT_FIVE = 5;

    public static final Integer INT_ONE_HUNDRED = 100;
    public static final Integer INT_ONE_MILLION = 1000000;


    /**
     *  Long类型常量:
     */
    public static final Long LONG_FIVE_MINUTE_MILLIS = 5 * 60 * 1000l;

}
