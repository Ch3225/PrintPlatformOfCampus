package pfpsc.dao;

import pfpsc.pojo.DefaultShop;

public interface DefaultShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DefaultShop record);

    int insertSelective(DefaultShop record);

    DefaultShop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DefaultShop record);

    int updateByPrimaryKey(DefaultShop record);
}