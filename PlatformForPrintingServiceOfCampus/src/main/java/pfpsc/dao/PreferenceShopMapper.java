package pfpsc.dao;

import pfpsc.pojo.PreferenceShop;

public interface PreferenceShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PreferenceShop record);

    int insertSelective(PreferenceShop record);

    PreferenceShop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PreferenceShop record);

    int updateByPrimaryKey(PreferenceShop record);
}