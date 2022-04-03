package pfpsc.dao.impl;

import pfpsc.model.pojo.Lock;

public interface LockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lock record);

    int insertSelective(Lock record);

    Lock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lock record);

    int updateByPrimaryKey(Lock record);
}