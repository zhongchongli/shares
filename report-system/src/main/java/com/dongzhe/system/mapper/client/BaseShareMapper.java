package com.dongzhe.system.mapper.client;

import com.dongzhe.project.pojo.BaseShareDO;
import com.dongzhe.project.pojo.BaseShareExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseShareMapper {
    long countByExample(BaseShareExample example);

    int deleteByExample(BaseShareExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(BaseShareDO record);

    List<BaseShareDO> selectByExample(BaseShareExample example);

    BaseShareDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseShareDO record);

    int addBatch(Map<String, Object> map2);

    /**
     * 存在更新,否则插入
     * @param listToInsert
     * @return
     */
    int insertOrUpdateBatch(@Param("list") List<BaseShareDO> listToInsert);

    /**
     * 存在就更新，否则插入一个
     * @param map
     * @return
     */
    int insertOrUpdateOne(Map<String,Object> map);
}