package pfpsc.service.impl;

import pfpsc.pojo.User;
import pfpsc.pojo.UserInfo;
import pfpsc.service.exception.UserException;

public interface IUserService {
    UserInfo showInfo(int id);
    User login(String phone,String password);
    User registerAsCustomer(String phone,String password);
}
