package pfpsc.dao;

import pfpsc.pojo.MethodListItem;

public interface MethodListItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MethodListItem record);

    int insertSelective(MethodListItem record);

    MethodListItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MethodListItem record);

    int updateByPrimaryKey(MethodListItem record);
}