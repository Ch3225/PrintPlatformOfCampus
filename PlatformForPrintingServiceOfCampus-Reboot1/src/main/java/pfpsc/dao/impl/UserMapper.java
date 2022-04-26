package pfpsc.dao.impl;

import pfpsc.model.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByPhone(User user);
    
    User selectByPhoneAndPassword(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}