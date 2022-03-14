package pfpsc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pfpsc.pojo.User;
import pfpsc.pojo.UserInfo;
import pfpsc.service.exception.UserException;
import pfpsc.service.impl.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	
    @RequestMapping("/login")
	public String login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,@RequestParam(value="username")String username,@RequestParam(value="password")String password) {
    	User user = userService.login(username,password);
		//userService.verifyCode(request.getParameter("verifyCode"), verifyCode.getText());
		// 创建 Session，保持登录状态
		if(user!=null) {
			httpServletRequest.getSession().setAttribute("user", user);
			return "myinfo";
		}
		return "login";
	}
    @RequestMapping("/myinfo")
    @ResponseBody
    public UserInfo myinfo(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
    	User user= (User)(httpServletRequest.getSession().getAttribute("user"));
    	UserInfo userInfo=userService.showInfo(user.getId());
    	return userInfo;
    }
    
    @RequestMapping("/test")
    @ResponseBody
    public UserInfo test() {
    	return userService.showInfo(1);
    }
}
