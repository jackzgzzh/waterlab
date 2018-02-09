package com.waterlab.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.waterlab.bean.User;
import com.waterlab.service.UserService;

public class UserLoginAction extends ActionSupport implements ModelDriven<User>,ServletRequestAware{
	
	private UserService userService;
	private User user;
	private HttpServletRequest request;
	
	public boolean check(User user){	
		return userService.findUserByNP(user);
	}
	
	public String login() {
		if (check(user)) {
			User otherUser = userService.getUserByName(user);
			request.getSession().setAttribute("userInfo", otherUser);
			return "success";
		} else {
			return "error";
		}
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		if(user == null){
			user = new User();
		}
		return user;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
