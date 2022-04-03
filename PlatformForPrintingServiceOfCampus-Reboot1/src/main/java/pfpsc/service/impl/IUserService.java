package pfpsc.service.impl;

import pfpsc.exception.DefinedException;
import pfpsc.model.pojo.User;

public interface IUserService {
	User login(User user) throws DefinedException;
	User register(User user) throws DefinedException;
}
