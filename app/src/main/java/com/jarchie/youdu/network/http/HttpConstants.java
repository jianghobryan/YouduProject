package com.jarchie.youdu.network.http;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youdu.network.http
 * 文件名:   HttpConstants
 * 创建者:   Jarchie
 * 创建时间: 17/2/14 下午5:06
 * 描述:     所有请求相关地址
 */

public class HttpConstants {
    /**
     * 方便我们切换测试服务器与主站服务器的地址
     */
    private static final String ROOT_URL = "http://imooc.com/api";
    /**
     * 首页产品请求接口
     */
    public static String HOME_RECOMMAND = ROOT_URL + "/product/home_recommand.php";

    /**
     * 请求本地产品列表
     */
    public static String PRODUCT_LIST = ROOT_URL + "/fund/search.php";

    /**
     * 本地产品列表更新时间措请求
     */
    public static String PRODUCT_LATESAT_UPDATE = ROOT_URL + "/fund/upsearch.php";

    /**
     * 登陆接口
     */
    public static String LOGIN = ROOT_URL + "/user/login_phone.php";

    /**
     * 检查更新接口
     */
    public static String CHECK_UPDATE = ROOT_URL + "/config/check_update.php";

    /**
     * 课程详情接口
     */
    public static String COURSE_DETAIL = ROOT_URL + "/product/course_detail.php";
}
