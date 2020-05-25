package com.dongzhe.system.service;

import com.dongzhe.system.domain.SysUserTemp;
import com.dongzhe.system.domain.SysUserTempExample;
import java.util.List;

public interface ISysUserTempService {
    long countByExample(SysUserTempExample example);

    int deleteByExample(SysUserTempExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysUserTemp record);

    List<SysUserTemp> selectByExample(SysUserTempExample example);

    List<SysUserTemp> selectByExampleAgree(SysUserTempExample example);

    SysUserTemp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserTemp record);

    public int updateLeader(SysUserTemp user);

    List<SysUserTemp>  listNoGroup();
}