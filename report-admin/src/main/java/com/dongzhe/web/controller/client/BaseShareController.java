package com.dongzhe.web.controller.client;

import com.dongzhe.common.annotation.Log;
import com.dongzhe.common.base.AjaxResult;
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

    @RequiresPermissions("client:datasource:list")
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
