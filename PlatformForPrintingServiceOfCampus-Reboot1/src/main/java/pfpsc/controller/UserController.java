package pfpsc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfpsc.constant.PageNameConstant;
import pfpsc.constant.RequestMapConstant;
import pfpsc.service.impl.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	
    @RequestMapping(RequestMapConstant.index)
    public String index(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
    	return PageNameConstant.index;
    }
    
    @RequestMapping(RequestMapConstant.login)
    public String login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
    	return PageNameConstant.login;
    }
    
    @RequestMapping(RequestMapConstant.register)
    public String register(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
    	return PageNameConstant.register;
    }
}
