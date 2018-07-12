package top.xjrlife.dynamic.dao;

import org.apache.ibatis.annotations.Param;
import top.xjrlife.dynamic.pojo.Power;
import top.xjrlife.dynamic.pojo.PowerExample;

import java.util.List;

public interface PowerMapper {
    long countByExample(PowerExample example);

    int deleteByExample(PowerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Power record);

    int insertSelective(Power record);

    List<Power> selectByExampleWithBLOBs(PowerExample example);

    List<Power> selectByExample(PowerExample example);

    Power selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Power record, @Param("example") PowerExample example);

    int updateByExampleWithBLOBs(@Param("record") Power record, @Param("example") PowerExample example);

    int updateByExample(@Param("record") Power record, @Param("example") PowerExample example);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKeyWithBLOBs(Power record);

    int updateByPrimaryKey(Power record);
}