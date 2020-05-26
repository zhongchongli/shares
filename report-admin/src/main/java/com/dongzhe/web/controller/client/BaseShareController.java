package com.dongzhe.web.controller.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongzhe.common.annotation.Log;
import com.dongzhe.common.base.AjaxResult;
import com.dongzhe.common.constant.Constants;
import com.dongzhe.common.constant.UserConstants;
import com.dongzhe.common.enums.BusinessType;
import com.dongzhe.framework.util.ShiroUtils;
import com.dongzhe.framework.web.base.BaseController;
import com.dongzhe.project.pojo.BaseShareDO;
import com.dongzhe.project.pojo.BaseShareExample;
import com.dongzhe.system.service.IBaseShareService;
import com.dongzhe.web.util.HttpClientUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * @author Lenovo
 * @date 2020/4/22 14:55
 */
//@RestController
@Controller
@RequestMapping("/client/baseShare")
public class BaseShareController extends BaseController {
    private String prefix = "client/baseShare";

    @Autowired
    IBaseShareService baseShareService;

    private static final Logger logger = LoggerFactory.getLogger(BaseShareController.class);
    private HttpClientUtil httpClientUtil = new HttpClientUtil();

    private String prefixSupply = "http://hq.sinajs.cn/list";

    @RequiresPermissions("client:share:view")
    @GetMapping()
    public String datasource()
    {
        return prefix + "/baseShare";
    }

//    @RequiresPermissions("client:share:list")
//    @GetMapping("/listByPage")
//    @ResponseBody
//    public List<DbInfo> listByPage(DbInfo dbInfo)
//    {
//        startPage();
//        DbInfoExample example = new DbInfoExample();
//        DbInfoExample.Criteria criteria = example.createCriteria();
//        if(null!=dbInfo.getName() && !"".equals(dbInfo.getName())){
//            criteria.andNameLike("%" + dbInfo.getName() + "%");
//        }
//
//        criteria.andDelFlagEqualTo("0");
//        List<DbInfo> dbInfoList = dbInfoService.selectByExample(example);
//        return dbInfoList;
//    }

    @RequiresPermissions("client:share:list")
    @GetMapping("/list")
    @ResponseBody
    public List<BaseShareDO> list(BaseShareDO dbInfo)
    {
        BaseShareExample example = new BaseShareExample();
        BaseShareExample.Criteria criteria = example.createCriteria();
        if(null!=dbInfo.getName() && !"".equals(dbInfo.getName())){
            criteria.andNameLike("%" + dbInfo.getName() + "%");
        }
        if(null!=dbInfo.getCode() && !"".equals(dbInfo.getCode())){
            criteria.andCodeLike("%" + dbInfo.getCode() + "%");
        }
        if(null!=dbInfo.getShortCode() && !"".equals(dbInfo.getShortCode())){
            criteria.andShortCodeLike("%" + dbInfo.getShortCode() + "%");
        }
        if(null!=dbInfo.getCodeType() && !"".equals(dbInfo.getCodeType())){
            criteria.andCodeTypeEqualTo(dbInfo.getCodeType());
        }

        List<BaseShareDO> dbInfoList = baseShareService.selectByExample(example);
        return dbInfoList;
    }

    /**
     * 更新股票基本信息
     * @return
     */
    @RequiresPermissions("client:share:add")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(){
        int iRet = 0;
        //"http://api.k780.com/?app=finance.stock_list&category=hs&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
        String jsonresutl= httpClientUtil.executeByGET(Constants.PREFIX_ALL_LIST.URL +"?app=" + Constants.PREFIX_ALL_LIST.APP +
                "&category=" + Constants.PREFIX_ALL_LIST.CATEGORY + "&appkey=" + Constants.PREFIX_ALL_LIST.APPKEY +
                "&sign=" + Constants.PREFIX_ALL_LIST.SIGN + "&format=" + Constants.PREFIX_ALL_LIST.FORMAT);
        System.out.println("jsonresutl:" + jsonresutl);
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(jsonresutl);
//        com.alibaba.fastjson.JSONArray jsonArray = com.alibaba.fastjson.JSONArray.parseArray(jsonresutl);
        //	"success": "1",
        //	"result": {
        //		"totline": "4997",
        //		"disline": "4997",
        //		"page": "1",
        //		"lists": [{
        //			"symbol": "sh500038",
        //			"sname": "基金通乾"
        //		}, {
        if(null!=jsonObject && "1".equals(jsonObject.getString("success"))){
            Integer totline = 0;
            Integer disline = 0;
            totline = jsonObject.getJSONObject("result").getInteger("totline");
            disline = jsonObject.getJSONObject("result").getInteger("disline");
            JSONArray lists = jsonObject.getJSONObject("result").getJSONArray("lists");
            List<BaseShareDO> shareList = new ArrayList<>();
            if(null!=lists && lists.size()>0){
                for (int i = 0; i < lists.size(); i++) {
                    JSONObject item =  lists.getJSONObject(i);
                    BaseShareDO baseShare = new BaseShareDO();
                    baseShare.setCode(item.getString("symbol"));
                    baseShare.setName(item.getString("sname"));
                    baseShare.setShortCode(item.getString("symbol"));
                    shareList.add(baseShare);
                }
            }
            iRet = baseShareService.insertOrUpdateBatch(shareList);
            System.out.println("insertOrUpdateBatch:" + iRet);
        }
//        System.out.println("json:" + jsonArray.toString());
        return toAjax(iRet);
    }

    //
    @RequiresPermissions("client:share:add")
    @PostMapping("/getAllDatas")
    @ResponseBody
    public AjaxResult getAllDatas(BaseShareDO dbInfo) {
        int iRet = 0;

        //"http://hq.sinajs.cn/list=sz000100,sz000725,sz000001";
        BaseShareExample example = new BaseShareExample();
        BaseShareExample.Criteria criteria = example.createCriteria();
        if(null!=dbInfo.getName() && !"".equals(dbInfo.getName())){
            criteria.andNameLike("%" + dbInfo.getName() + "%");
        }
        if(null!=dbInfo.getCode() && !"".equals(dbInfo.getCode())){
            criteria.andCodeLike("%" + dbInfo.getCode() + "%");
        }
        if(null!=dbInfo.getShortCode() && !"".equals(dbInfo.getShortCode())){
            criteria.andShortCodeLike("%" + dbInfo.getShortCode() + "%");
        }
        if(null!=dbInfo.getCodeType() && !"".equals(dbInfo.getCodeType())){
            criteria.andCodeTypeEqualTo(dbInfo.getCodeType());
        }
        String sCodes = "sz000100,sz000725,sz000001";
        List<BaseShareDO> baseShareList = baseShareService.selectByExample(example);
        if(null!=baseShareList && baseShareList.size()>0){
//            for (int i = 0; i < baseShareList.size(); i++) {
//                BaseShareDO baseShareDO =  baseShareList.get(i);
//                if(i==0){
//                    sCodes = baseShareDO.getCode();
//                }else{
//                    sCodes += "," + baseShareDO.getCode();
//                }
//            }

            int listSize=baseShareList.size();
            int toIndex=100;
            Map<String, List> map = new HashMap();     //用map存起来新的分组后数据
            int keyToken = 0;
            for(int i = 0;i<baseShareList.size();i+=100){
                if(i+100>listSize){        //作用为toIndex最后没有100条数据则剩余几条newList中就装几条
                    toIndex=listSize-i;
                }
                List newList = baseShareList.subList(i,i+toIndex);
                map.put("keyName"+keyToken, newList);
                keyToken++;
            }

            for(String key : map.keySet()){
                List newList = map.get(key);
//                String value = String.join(",", newList);
//                System.out.println(key+":"+value);
                for (int i = 0; i < newList.size(); i++) {
                    BaseShareDO baseShareDO =  (BaseShareDO)newList.get(i);
                    if(i==0){
                        sCodes = baseShareDO.getCode();
                    }else{
                        sCodes += "," + baseShareDO.getCode();
                    }
                }
                String jsonresutl= httpClientUtil.executeByGET(Constants.PREFIX_INTERFACE_URL +"=" + sCodes);
                System.out.println("jsonresutl:" + jsonresutl);
                //var hq_str_sh500038="基金通乾,0.000,0.938,0.938,0.000,0.000,0.000,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,2020-05-25,09:00:00,03,";
            }


        }


//        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(jsonresutl);
//        var hq_str_sz000100="TCL科技,5.080,5.120,4.950,5.100,4.860,4.950,4.960,464721432,2301751881.340,2910478,4.950,909500,4.940,832600,4.930,915200,4.920,682300,4.910,3389522,4.960,1691000,4.970,1646500,4.980,2551400,4.990,2876700,5.000,2020-05-22,15:00:03,00";
//        var hq_str_sz000725="京东方Ａ,3.850,3.870,3.770,3.860,3.750,3.760,3.770,548595439,2084535368.710,10438306,3.760,14360200,3.750,4455900,3.740,3649700,3.730,2831600,3.720,2405217,3.770,4318232,3.780,4980194,3.790,4101900,3.800,3245200,3.810,2020-05-22,15:00:03,00";
//        var hq_str_sz000001="平安银行,13.330,13.400,12.920,13.340,12.920,12.920,12.930,85623733,1119433491.010,304700,12.920,676900,12.910,646200,12.900,252300,12.890,271300,12.880,55700,12.930,57406,12.940,83040,12.950,68700,12.960,135200,12.970,2020-05-22,15:00:03,00";
//        if(null!=jsonObject && "1".equals(jsonObject.getString("success"))){
//            Integer totline = 0;
//            Integer disline = 0;
//            totline = jsonObject.getJSONObject("result").getInteger("totline");
//            disline = jsonObject.getJSONObject("result").getInteger("disline");
//            JSONArray lists = jsonObject.getJSONObject("result").getJSONArray("lists");
//            List<BaseShareDO> shareList = new ArrayList<>();
//            if(null!=lists && lists.size()>0){
//                for (int i = 0; i < lists.size(); i++) {
//                    JSONObject item =  lists.getJSONObject(i);
//                    BaseShareDO baseShare = new BaseShareDO();
//                    baseShare.setCode(item.getString("symbol"));
//                    baseShare.setName(item.getString("sname"));
//                    baseShare.setShortCode(item.getString("symbol"));
//                    shareList.add(baseShare);
//                }
//            }
//            iRet = baseShareService.insertOrUpdateBatch(shareList);
//            System.out.println("insertOrUpdateBatch:" + iRet);
//        }

        return toAjax(iRet);
    }

    @RequiresPermissions("client:share:add")
    @PostMapping("/getHistory")
    @ResponseBody
    public AjaxResult getHistory(){
        String url = "http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=sz000100&scale=60&ma=no&datalen=1023";
        return toAjax(1);
    }

    public static void main(String[] args) {
            URL ur = null;
            try {
                //搜狐行情历史接口
//          ur = new URL(");
                //新浪行情历史接口
                ur = new URL("http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=sz000100&scale=60&ma=no&datalen=102300");
                HttpURLConnection uc = (HttpURLConnection) ur.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ur.openStream(),"GBK"));
                String line;
                while((line = reader.readLine()) != null){
                    System.out.println(line);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    /**
     * 新增
     */
//    @GetMapping("/add/{id}")
//    public String add(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        DbInfo dbInfo = null;
//
//        dbInfo = new DbInfo();
//        dbInfo.setCreateBy(ShiroUtils.getUserId());
//        dbInfo.setCreateTime(new Date());
//
//        mmap.put("dbInfo", dbInfo);
//        return prefix + "/add";
//    }

    /**
     * 新增保存数据源
     */
//    @Log(title = "数据源管理", businessType = BusinessType.INSERT)
//    @RequiresPermissions("client:datasource:add")
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(DbInfo dbInfo)
//    {
//        dbInfo.setCreateBy(ShiroUtils.getUserId());
//        ShiroUtils.clearCachedAuthorizationInfo();
//        return toAjax(dbInfoService.insertSelective(dbInfo));
//    }

    /**
     * 修改数据源
     */
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        DbInfoExample example = new DbInfoExample();
//        example.createCriteria().andIdEqualTo(id);
//        List<DbInfo> list = dbInfoService.selectByExample(example);
//        if(null!=list && list.size()>0) {
//            mmap.put("dbInfo", list.get(0));
//        }
//        return prefix + "/edit";
//    }

    /**
     * 修改保存数据源
     */
//    @Log(title = "数据源管理", businessType = BusinessType.UPDATE)
//    @RequiresPermissions("client:datasource:edit")
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(DbInfo dbInfo)
//    {
//        dbInfo.setUpdateBy(ShiroUtils.getUserId());
//        dbInfo.setUpdateTime(new Date());
//        return toAjax(dbInfoService.updateByPrimaryKeySelective(dbInfo));
//    }


}
