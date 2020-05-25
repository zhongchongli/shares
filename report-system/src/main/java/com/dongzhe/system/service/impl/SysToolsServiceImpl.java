package com.dongzhe.system.service.impl;

import com.dongzhe.system.service.ISysToolsService;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 * @date 2020/4/14 18:02
 */
@Service
public class SysToolsServiceImpl implements ISysToolsService {


    @Override
    public String getFixedLength(String source, Integer len, String cha) {
        return null;
    }

    @Override
    public String lpad(int length, int number) {
        String f = "%0" + length + "d";
        return String.format(f, number);
    }




    public static void main(String[] args) {
        SysToolsServiceImpl test = new SysToolsServiceImpl();
        System.out.println(test.lpad(10, 23));
    }
}
