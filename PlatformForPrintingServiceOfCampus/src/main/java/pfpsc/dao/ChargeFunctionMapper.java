package pfpsc.dao;

import pfpsc.pojo.ChargeFunction;

public interface ChargeFunctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChargeFunction record);

    int insertSelective(ChargeFunction record);

    ChargeFunction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChargeFunction record);

    int updateByPrimaryKeyWithBLOBs(ChargeFunction record);

    int updateByPrimaryKey(ChargeFunction record);
}