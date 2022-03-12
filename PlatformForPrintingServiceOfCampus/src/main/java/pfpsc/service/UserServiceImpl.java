package pfpsc.service;

import org.springframework.beans.factory.annotation.Autowired;

import pfpsc.dao.UserMapper;
import pfpsc.pojo.User;
import pfpsc.service.exception.UserException;
import pfpsc.service.impl.IUserService;

public class UserServiceImpl implements IUserService{
	
	@Autowired
	public UserMapper userDao;

	@Override
	public User showInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatus(String username) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
