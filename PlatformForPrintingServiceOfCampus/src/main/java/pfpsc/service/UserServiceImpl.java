package pfpsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfpsc.dao.UserInfoMapper;
import pfpsc.dao.UserMapper;
import pfpsc.pojo.User;
import pfpsc.pojo.UserInfo;
import pfpsc.service.exception.UserException;
import pfpsc.service.impl.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	public UserMapper userDao;
	
	@Autowired
	public UserInfoMapper userInfoDao;
	
	public User login(String username, String password) {
		UserInfo userInfo=userInfoDao.selectByPhoneNumber(username);
		Integer id=userInfo.getId();
		User user=userDao.selectByPrimaryKey(id);
		if(password.equals(user.getPassword())) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public UserInfo showInfo(int id) {
		return userInfoDao.selectByPrimaryKey(id);
	}



}
