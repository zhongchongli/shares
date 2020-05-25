package com.dongzhe.web.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zcl on 2020/04/20.
 */
public class ObjectToNameValueUtils {

    public static List<NameValuePair> getParamsByObject(List<NameValuePair> params, Object o){

        List<Map<String,Object>> list = ObjectUtils.getFiledsInfo(o);
        for(Map<String,Object> map :list){
            String type = (String)map.get("type");
            String name = (String)map.get("name");
            Object value = map.get("value");
            if(value!=null){
                if(type.equals("class java.lang.Long")||type.equals("class java.lang.String")
                        ||type.equals("class java.lang.Integer")||type.equals("class java.lang.Float")
                        ||type.equals("class java.lang.Double")||type.equals("class java.lang.Boolean")
                        ||type.equals("class java.math.BigDecimal")){

                    params.add(new BasicNameValuePair(name,value.toString()));
                }else if(type.equals("interface java.util.List")||type.equals("class java.util.ArrayList")){
                    List  menuIds= (List)value;
                    String objectClass = menuIds.get(0).getClass().toString();
                    if(objectClass.equals("class java.lang.Long")||objectClass.equals("class java.lang.String")
                            ||objectClass.equals("class java.lang.Integer")||objectClass.equals("class java.lang.Float")
                            ||objectClass.equals("class java.lang.Double")||objectClass.equals("class java.lang.Boolean")){

                        String v= StringUtils.join(menuIds.toArray(),",");
                        params.add(new BasicNameValuePair(name,v));
                    }
                }else if(type.equals("class java.util.Date")){

                    Date d = (Date)value;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    params.add(new BasicNameValuePair(name,sdf.format(d)));
//                    String v=JSONObject.toJSONString(value);
//                    params.add(new BasicNameValuePair(name,v));
                }else{
                    String v=JSONObject.toJSONString(value);
                    params.add(new BasicNameValuePair(name,v));
                }
            }

        }

        return params;
    }
}
