package com.dongzhe.system.service;

/**
 * @author Lenovo
 * @date 2020/4/14 18:00
 */
public interface ISysToolsService {

    /**
     * 获取定长字符串
     *
     * @param source 源字符串（待处理字符串）
     * @param len    目标字符串长度
     * @param cha    补齐字符
     * @return 目标字符串
     */
    public String getFixedLength(String source, Integer len, String cha);

    /**
     * 补齐不足长度
     * @param length 长度
     * @param number 数字
     * @return
     */
    public String lpad(int length, int number);

}
