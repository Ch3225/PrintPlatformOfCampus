package pfpsc.service.impl;

import pfpsc.pojo.User;
import pfpsc.service.exception.UserException;

public interface IUserService {
    User showInfo(int id);
    String getStatus(String username) throws UserException;
}
