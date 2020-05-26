package com.dongzhe.common.constant;

import java.sql.SQLTransactionRollbackException;

/**
 * 通用常量信息
 * 
 * @author zcl
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 自动去除表前缀
     */
    public static String AUTO_REOMVE_PRE = "true";

    /**
     * 当前记录起始索引
     */
    public static String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static String IS_ASC = "isAsc";

    /**
     * 审核通过
     */
    public static String AUDIT_SUCC = "1";

    /**
     * 审核驳回
     */
    public static String AUDIT_FAIL = "9";


    //报表周期(0 日、1 周、2 月、3 季、4 年)
    public interface REPORT_PERIOD {
        String DAY = "0";        //日报
        String WEEK = "1";       //周报
        String MONTH = "2";      //月报
        String QUARTER = "3";    //季报
        String YEAR = "4";       //年报
    }


    /**
     * 动态数据库接口地址
     */
    public static String PREFIX_INTERFACE_URL = "http://hq.sinajs.cn/list";

    public static  String PREFIX_ALL_LIST_URL = "http://api.k780.com/?app=finance.stock_list&category=hs&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";

    public interface PREFIX_ALL_LIST {
        String URL = "http://api.k780.com/";
        String APP = "finance.stock_list";
        String CATEGORY = "hs";
        String APPKEY = "10003";
        String SIGN = "b59bc3ef6191eb9f747dd4e83c99f2a4";
        String FORMAT = "json";
    }

    public interface PREFIX_TENCENT{
        //http://qt.gtimg.cn/q=sz000858
        String URL = "http://qt.gtimg.cn/";
        String APP = "finance.stock_list";
        String CATEGORY = "hs";
        String APPKEY = "10003";
        String SIGN = "b59bc3ef6191eb9f747dd4e83c99f2a4";
        String FORMAT = "json";
    }

    public interface PREFIX_NET163{
        //http://quotes.money.163.com/service/chddata.html?code=0600756&start=20160902&end=20171108&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;VOTURNOVER
        String URL = "http://quotes.money.163.com/service/chddata.html";
        //code="0600756";    start=20160902 end=20171108 fields=TCLOSE;HIGH;LOW;TOPEN;LCOSE;CHG;PCHG;VOTURNOVER
    }
}
