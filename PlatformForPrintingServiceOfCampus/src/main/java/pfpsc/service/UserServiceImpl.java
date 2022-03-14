package pfpsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public User login(String phone, String password) {
		UserInfo userInfo=userInfoDao.selectByPhoneNumber(phone);
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

	@Override
	@Transactional
	public User registerAsCustomer(String phone, String password) {
		User user=new User();
		user.setPassword(password);
		userDao.insertSelective(user);
		Integer id=user.getId();
		UserInfo userInfo=new UserInfo();
		userInfo.setPhonenumber(phone);
		userInfo.setName(phone);
		userInfo.setId(id);
		userInfoDao.insertSelective(userInfo);
		return user;
	}





}
