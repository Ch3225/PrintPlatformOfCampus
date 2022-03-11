package pfpsc.dao;

import pfpsc.pojo.StateProperty;

public interface StatePropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StateProperty record);

    int insertSelective(StateProperty record);

    StateProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StateProperty record);

    int updateByPrimaryKeyWithBLOBs(StateProperty record);

    int updateByPrimaryKey(StateProperty record);
}