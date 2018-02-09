package com.waterlab.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.waterlab.bean.User;
import com.waterlab.common.MessageFor;
import com.waterlab.service.UserService;

public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserService userService;
	
	/*
	 * admin_success: 表示管理用户登录
	 * common_success：表示一般用户登录
	 */
	public String loginTo(){
		User user = (User) request.getSession().getAttribute("userInfo");
		int userRole = user.getUserRole();
		if(userRole == 2){
			return "admin_success"; 
		}
		if(userRole == 1){
			return "common_success";
		}
		return null;
	}
	
	public String moveForward(){
		String id = request.getParameter("id");
		if(id.equals("user_admin")){
			return "user_admin";
		}
		
		return NONE;
	}
	
	/*----------用户管理------------*/
	//分页
	public void getPageInfo(){
		response.setCharacterEncoding("utf-8");		
		try {
			int limit = Integer.parseInt(request.getParameter("limit")); 
			int offset = Integer.parseInt(request.getParameter("offset")); 
			Map<String, Object> map = userService.queryPageInfo(limit, offset);
			int total = (Integer) map.get("total");
			
			List<User> userList = (List<User>) map.get("rows");
			String userData = JSON.toJSONString(userList);
			
			String json = "{\"total\":" + total + ",\"rows\":" + userData
					+ "}";
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteByList(){
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		try {
			String[] userIdList = request.getParameterValues("idList");
			for(int i = 0;i < userIdList.length;i++){
				int id = Integer.parseInt(userIdList[i]);
				userService.deleteById(id);
			}
			String json = JSON.toJSONString(message);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//修改按钮
	public void update(){
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		try {
			String userModal = request.getParameter("userModal");
			User user = JSON.parseObject(userModal,User.class);
			userService.update(user);
			
			String json = JSON.toJSONString(message);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//新增按钮
	public void add(){
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();

		try {
			String addUserModal = request.getParameter("addUserModal");
			User user = JSON.parseObject(addUserModal,User.class);
			if(!userService.findUserByName(user)){
				userService.addUser(user);
				message.setSuccess(true);
			}else{
				message.setSuccess(false);
			}
			String json = JSON.toJSONString(message);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
