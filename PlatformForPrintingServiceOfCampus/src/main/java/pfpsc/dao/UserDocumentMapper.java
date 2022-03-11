package pfpsc.dao;

import pfpsc.pojo.UserDocument;

public interface UserDocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDocument record);

    int insertSelective(UserDocument record);

    UserDocument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDocument record);

    int updateByPrimaryKey(UserDocument record);
}