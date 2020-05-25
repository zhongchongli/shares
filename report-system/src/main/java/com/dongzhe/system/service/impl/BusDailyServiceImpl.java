package com.dongzhe.system.service.impl;

import com.dongzhe.project.pojo.BusDailyDO;
import com.dongzhe.project.pojo.BusDailyExample;
import com.dongzhe.system.mapper.client.BusDailyMapper;
import com.dongzhe.system.service.IBusDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lenovo
 * @date 2020/5/22 22:16
 */
@Service
public class BusDailyServiceImpl implements IBusDailyService {
    @Autowired
    BusDailyMapper busDailyMapper;

    @Override
    public long countByExample(BusDailyExample example) {
        return busDailyMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(BusDailyExample example) {
        return busDailyMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return busDailyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BusDailyDO record) {
        return busDailyMapper.insertSelective(record);
    }

    @Override
    public List<BusDailyDO> selectByExample(BusDailyExample example) {
        return busDailyMapper.selectByExample(example);
    }

    @Override
    public BusDailyDO selectByPrimaryKey(Long id) {
        return busDailyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BusDailyDO record) {
        return busDailyMapper.updateByPrimaryKeySelective(record);
    }


}
