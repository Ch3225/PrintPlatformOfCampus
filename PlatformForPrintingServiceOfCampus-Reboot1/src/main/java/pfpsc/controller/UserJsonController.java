package pfpsc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pfpsc.constant.CodeConstant;
import pfpsc.constant.RequestMapConstant;
import pfpsc.exception.DefinedException;
import pfpsc.model.pojo.User;
import pfpsc.service.impl.IUserService;


@Controller
public class UserJsonController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(RequestMapConstant.login)
    @ResponseBody
	public String login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,@RequestParam(value="phone")String phone,@RequestParam(value="password")String password) {
    	User user=new User();
    	user.setPhonenumber(phone);
    	user.setPassword(password);
		try {
			User loggedUser = userService.login(user);
			if(loggedUser!=null) {
				httpServletRequest.getSession().setAttribute("user", loggedUser);
				return CodeConstant.CODE_SUCCESS;
			}
			else{
				return CodeConstant.CODE_UNKNOWNERROR;
			}
		} catch (DefinedException e) {
			e.printStackTrace();
			return CodeConstant.CODE_NOTFILLED;
		}
	}

}
