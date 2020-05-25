package com.dongzhe.system.service;

import com.dongzhe.project.pojo.BaseShareDO;
import com.dongzhe.project.pojo.BaseShareExample;
import java.util.List;

public interface IBaseShareService {
    long countByExample(BaseShareExample example);

    int deleteByExample(BaseShareExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(BaseShareDO record);

    List<BaseShareDO> selectByExample(BaseShareExample example);

    BaseShareDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseShareDO record);

}