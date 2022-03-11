package pfpsc.dao;

import pfpsc.pojo.ItemChoice;

public interface ItemChoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemChoice record);

    int insertSelective(ItemChoice record);

    ItemChoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemChoice record);

    int updateByPrimaryKey(ItemChoice record);
}