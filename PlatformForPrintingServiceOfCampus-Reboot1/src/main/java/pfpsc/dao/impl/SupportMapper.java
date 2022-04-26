package pfpsc.dao.impl;

import pfpsc.model.pojo.Support;

public interface SupportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Support record);

    int insertSelective(Support record);

    Support selectByPrimaryKey(Integer id);
    
    Support selectByShopAndMethod(Support support);

    int updateByPrimaryKeySelective(Support record);

    int updateByPrimaryKey(Support record);
}