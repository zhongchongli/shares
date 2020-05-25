package com.dongzhe.system.service;

import com.dongzhe.project.pojo.BusDailyDO;
import com.dongzhe.project.pojo.BusDailyExample;
import java.util.List;

public interface IBusDailyService {
    long countByExample(BusDailyExample example);

    int deleteByExample(BusDailyExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(BusDailyDO record);

    List<BusDailyDO> selectByExample(BusDailyExample example);

    BusDailyDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BusDailyDO record);

}