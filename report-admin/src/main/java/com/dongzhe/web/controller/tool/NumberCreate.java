package com.dongzhe.web.controller.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lenovo
 * @date 2020/4/18 9:15
 */
public class NumberCreate {

    private final static Object lock = new Object();
    public static String getNumber() {
        String schemeNum = "";
        synchronized(lock) {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddhhmmss");
            schemeNum = sdf.format(new Date());
            try {
                Thread.sleep(999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return schemeNum;
    }
}
