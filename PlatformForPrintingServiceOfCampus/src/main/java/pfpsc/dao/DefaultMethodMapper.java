package pfpsc.dao;

import pfpsc.pojo.DefaultMethod;

public interface DefaultMethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DefaultMethod record);

    int insertSelective(DefaultMethod record);

    DefaultMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DefaultMethod record);

    int updateByPrimaryKey(DefaultMethod record);
}