package pfpsc.dao.impl;

import java.util.List;

import pfpsc.model.pojo.Shop;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer id);
    
    List<Shop> selectAllShop();
    
    List<Shop> selectShopByName(String value);
    
    Shop selectShopByOwnerId(Integer userId);
    
    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}