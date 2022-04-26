package pfpsc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pfpsc.constant.CodeConstant;
import pfpsc.constant.EntityPropertyConstant;
import pfpsc.constant.RequestMapConstant;
import pfpsc.exception.DefinedException;
import pfpsc.model.pojo.User;
import pfpsc.service.impl.IUserService;


@Controller
public class UserJsonController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(RequestMapConstant.vertifyLogin)
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

	@RequestMapping(RequestMapConstant.vertifyRegister)
    @ResponseBody
	public String register(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@RequestParam(value="phone")String phone,
			@RequestParam(value="password")String password,
			@RequestParam(value="actor")String actor) {
    	User user=new User();
    	user.setPhonenumber(phone);
    	user.setPassword(password);
    	switch (actor) {
		case "student": {
			user.setProperty(EntityPropertyConstant.USER_PROPERTY_CUSTOMER.toString());
			break;
		}
		case "shoppper": {
			user.setProperty(EntityPropertyConstant.USER_PROPERTY_SHOPPER.toString());
			break;
		}
		default:
			return CodeConstant.CODE_UNKNOWNERROR;
		}
		try {
			User loggedUser = userService.register(user);
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
