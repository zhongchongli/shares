package com.dongzhe.web.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by zcl on 2020/04/20.
 */
public class HttpClientUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * 初始化HttpClient
     */
    private CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * POST方式调用
     *
     * @param url
     * @param object 参数为pojo对象
     * @return 响应字符串
     * @throws java.io.UnsupportedEncodingException
     */
    public String executeByPOST(String url, Object object) {

        List<NameValuePair> params =new ArrayList<>();
        ObjectToNameValueUtils.getParamsByObject(params,object);
        String responseJson = executeByPOST(url, params);
        return responseJson;
    }

//    public String executeByPOST(String url, JSONObject object) {
//        if(!url.startsWith("http")) {
//            url = "http://" + url;
//        }
//        HttpPost httpPost = new HttpPost(url);
//        CloseableHttpClient client = HttpClients.createDefault();
//        String responseJson = null;
//        //        json方式
////        JSONObject jsonParam = new JSONObject();
////        jsonParam.put("name", "admin");
////        jsonParam.put("pass", "123456");
//        StringEntity entity = new StringEntity(object.toString(),"utf-8");//解决中文乱码问题
//        entity.setContentEncoding("UTF-8");
//        entity.setContentType("application/json");
//        httpPost.setEntity(entity);
//        System.out.println();
//
//        try {
//            HttpResponse resp = client.execute(httpPost);
//            if(resp.getStatusLine().getStatusCode() == 200) {
//                HttpEntity he = resp.getEntity();
//                responseJson = EntityUtils.toString(he,"UTF-8");
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return responseJson;
//    }

    /**
     * httpClient请求处理数据
     * @param url  发送地址
     * @param jsonObj  Json格式数据
     * @return executeByPOST executeByPost
     */
    public String executeByPOST(String url, JSONObject jsonObj){
        if(!url.startsWith("http")) {
            url = "http://" + url;
        }
        HttpClientBuilder hcb = HttpClientBuilder.create();
        CloseableHttpClient client = hcb.build();
        String responseJson = null;
        //设置超时时间
        //client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
        //client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-type", "application/json; charset=utf-8");
        post.setHeader("Connection", "Close");

        //构建消息实体,发送Json格式的数据请求
        if(jsonObj != null) {
            StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
        }

        CloseableHttpResponse response = null;
        String responseContent = "";
        try {
            response = client.execute(post);
            HttpEntity entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            responseJson = responseContent;
            //校验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != HttpStatus.SC_OK){
                log.info("请求出错: " + statusCode);
                return null;
            } else {
//                return response.toString();
                return responseJson;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != post) {
                try {
                    post.releaseConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return responseJson;
    }

    public String executeByPOST1(String url, JSONObject object) {
        if(!url.startsWith("http")) {
            url = "http://" + url;
        }
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String responseJson = null;

        //设置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(120000).setConnectTimeout(120000)
                .setSocketTimeout(120000).build();
        httpPost.setConfig(requestConfig);
        //添加请求参数
        if(object != null){
            httpPost.setEntity(new StringEntity(object.toString(),"UTF-8"));
        }
        try {
            //执行request请求，得到对方的response响应
            CloseableHttpResponse response = client.execute(httpPost);
            //处理对方的response响应
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String responseContent = EntityUtils.toString(entity, "UTF-8");
            responseJson = responseContent;
//            JSONObject jsonObject = JSON.parseObject(responseContent);
            //关闭response和httpClient
            response.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            HttpResponse resp = client.execute(httpPost);
//            if(resp.getStatusLine().getStatusCode() == 200) {
//                HttpEntity he = resp.getEntity();
//                responseJson = EntityUtils.toString(he,"UTF-8");
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return responseJson;
    }




    /**
     * POST方式调用
     *
     * @param url
     * @param params 参数为NameValuePair键值对对象
     * @return 响应字符串
     * @throws java.io.UnsupportedEncodingException
     */
    public String executeByPOST(String url, List<NameValuePair> params) {
        if(!url.startsWith("http")) {
            url = "http://" + url;
        }
        HttpPost post = new HttpPost(url);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseJson = null;
        try {
            if (params != null) {
                post.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
            }
            responseJson = httpClient.execute(post, responseHandler);
            log.info(url+" HttpClient POST请求结果：" + responseJson);
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
            log.info(url+" HttpClient POST请求异常：" + e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
            log.info(url+" HttpClient POST请求异常：" + e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.info(url+" HttpClient POST请求异常：" + e.getMessage());
        }
        finally {
            httpClient.getConnectionManager().closeExpiredConnections();
            httpClient.getConnectionManager().closeIdleConnections(30, TimeUnit.SECONDS);
        }
        return responseJson;
    }

    /**
     * Get方式请求
     *
     * @param url 带参数占位符的URL，例：http://ip/User/user/center.aspx?_action=GetSimpleUserInfo&codes={0}&email={1}
     * @param params 参数值数组，需要与url中占位符顺序对应
     * @return 响应字符串
     * @throws java.io.UnsupportedEncodingException
     */
    public String executeByGET(String url, Object[] params) {
        String messages = MessageFormat.format(url, params);
        HttpGet get = new HttpGet(messages);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseJson = null;
        try {
            responseJson = httpClient.execute(get, responseHandler);
            log.info("HttpClient GET请求结果：" + responseJson);
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
            log.error("HttpClient GET请求异常：" + e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
            log.error("HttpClient GET请求异常：" + e.getMessage());
        }
        finally {
            httpClient.getConnectionManager().closeExpiredConnections();
            httpClient.getConnectionManager().closeIdleConnections(30, TimeUnit.SECONDS);
        }
        return responseJson;
    }

    /**
     * @param url
     * @return
     */
    public String executeByGET(String url) {
        if(!url.startsWith("http")) {
            url = "http://" + url;
        }
        HttpGet get = new HttpGet(url);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseJson = null;
        try {
            responseJson = httpClient.execute(get, responseHandler);
            log.info(url+" HttpClient GET请求结果：" + responseJson);
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
            log.error(url+" HttpClient GET请求异常：" + e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
            log.error(url+" HttpClient GET请求异常：" + e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error(url+" HttpClient GET请求异常：" + e.getMessage());
        }
        finally {
            httpClient.getConnectionManager().closeExpiredConnections();
            httpClient.getConnectionManager().closeIdleConnections(30, TimeUnit.SECONDS);
        }
        return responseJson;
    }

}

