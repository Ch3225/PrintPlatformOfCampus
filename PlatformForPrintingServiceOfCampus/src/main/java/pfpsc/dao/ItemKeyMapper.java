package pfpsc.dao;

import pfpsc.pojo.ItemKey;

public interface ItemKeyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemKey record);

    int insertSelective(ItemKey record);

    ItemKey selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemKey record);

    int updateByPrimaryKey(ItemKey record);
}