package pfpsc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfpsc.service.impl.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	
    @RequestMapping("/index")
    public String blank_customer(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
    	return "index";
    }
    
    
}
