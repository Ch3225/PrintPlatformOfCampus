package pfpsc.dao;

import pfpsc.pojo.PreferencePosition;

public interface PreferencePositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PreferencePosition record);

    int insertSelective(PreferencePosition record);

    PreferencePosition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PreferencePosition record);

    int updateByPrimaryKey(PreferencePosition record);
}