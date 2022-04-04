package pfpsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfpsc.dao.impl.notused.UserMapper;
import pfpsc.exception.DefinedException;
import pfpsc.model.pojo.User;
import pfpsc.service.impl.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	UserMapper userMapper;

	@Override
	public User login(User user) throws DefinedException {
		User selectedUser=userMapper.selectByPhoneAndPassword(user);
		if(selectedUser!=null) {
			return selectedUser;
		}else {
			throw new DefinedException("101",user);
		}
	}

	@Override
	public User register(User user) throws DefinedException {
		User selectedUser=userMapper.selectByPhone(user);
		if(selectedUser!=null) {
			throw new DefinedException("102",user);
		}else {
			Integer integer=userMapper.insert(user);
			if(integer>0&&user.getId()!=null) {
				return user;
			}
			else {
				throw new DefinedException("001",user);
			}
		}
	}

}
