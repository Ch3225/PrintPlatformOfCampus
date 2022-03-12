package pfpsc.service.impl;

import pfpsc.pojo.User;
import pfpsc.service.exception.UserException;

public interface IExceptionService {
    void statusException(User user) throws UserException;
}
