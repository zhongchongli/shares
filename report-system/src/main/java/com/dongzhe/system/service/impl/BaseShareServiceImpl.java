package com.dongzhe.system.service.impl;

import com.dongzhe.project.pojo.BaseShareDO;
import com.dongzhe.project.pojo.BaseShareExample;
import com.dongzhe.system.mapper.client.BaseShareMapper;
import com.dongzhe.system.service.IBaseShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 * @date 2020/5/22 22:08
 */
@Service
public class BaseShareServiceImpl implements IBaseShareService {
    @Autowired
    BaseShareMapper baseShareMapper;

    @Override
    public long countByExample(BaseShareExample example) {
        return baseShareMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(BaseShareExample example) {
        return baseShareMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return baseShareMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseShareDO record) {
        return baseShareMapper.insertSelective(record);
    }

    @Override
    public List<BaseShareDO> selectByExample(BaseShareExample example) {
        return baseShareMapper.selectByExample(example);
    }

    @Override
    public BaseShareDO selectByPrimaryKey(Long id) {
        return baseShareMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseShareDO record) {
        return baseShareMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int addBatch(Map<String, Object> map2) {
        return baseShareMapper.addBatch(map2);
    }

    @Override
    public int insertOrUpdateBatch(List<BaseShareDO> listToInsert) {
        return baseShareMapper.insertOrUpdateBatch(listToInsert);
    }

    @Override
    public int insertOrUpdateOne(Map<String, Object> map) {
        return baseShareMapper.insertOrUpdateOne(map);
    }

}
