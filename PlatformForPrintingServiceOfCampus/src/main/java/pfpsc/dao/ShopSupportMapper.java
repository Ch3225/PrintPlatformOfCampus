package pfpsc.dao;

import pfpsc.pojo.ShopSupport;

public interface ShopSupportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopSupport record);

    int insertSelective(ShopSupport record);

    ShopSupport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopSupport record);

    int updateByPrimaryKey(ShopSupport record);
}