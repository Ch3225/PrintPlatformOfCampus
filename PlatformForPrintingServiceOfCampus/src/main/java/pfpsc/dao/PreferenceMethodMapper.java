package pfpsc.dao;

import pfpsc.pojo.PreferenceMethod;

public interface PreferenceMethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PreferenceMethod record);

    int insertSelective(PreferenceMethod record);

    PreferenceMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PreferenceMethod record);

    int updateByPrimaryKey(PreferenceMethod record);
}