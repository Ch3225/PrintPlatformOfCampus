package pfpsc.dao;

import pfpsc.pojo.ShopReference;

public interface ShopReferenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopReference record);

    int insertSelective(ShopReference record);

    ShopReference selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopReference record);

    int updateByPrimaryKey(ShopReference record);
}