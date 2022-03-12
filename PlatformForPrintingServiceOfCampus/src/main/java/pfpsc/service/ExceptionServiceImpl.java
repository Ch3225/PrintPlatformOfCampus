package pfpsc.service;

import pfpsc.pojo.User;
import pfpsc.service.exception.UserException;
import pfpsc.service.impl.IExceptionService;

public class ExceptionServiceImpl implements IExceptionService {

    @Override
    public void statusException(User user) throws UserException {
        if (user != null){
        	if(user.getId()==null) {
        		throw new UserException("用户状态异常");
        	} else {
        		
        	}
        }
        else {
        	throw new UserException("用户未登录");
        }
    }

}
