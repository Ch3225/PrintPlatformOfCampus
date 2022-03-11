package pfpsc.dao;

import pfpsc.pojo.ItemMethod;

public interface ItemMethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemMethod record);

    int insertSelective(ItemMethod record);

    ItemMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemMethod record);

    int updateByPrimaryKey(ItemMethod record);
}