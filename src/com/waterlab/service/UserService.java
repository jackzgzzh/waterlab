package com.waterlab.service;

import java.util.Map;

import com.waterlab.bean.User;

public interface UserService {
	public void addUser(User user);
	
	public User getById(int id);
	
	public boolean findUserByNP(User user);
	
	public boolean findUserByName(User user);
	
	public User getUserByName(User user);
	
	public void update(User user);
	
	public void delete(User user);
	
	public void deleteById(int id);
	
	public Map<String,Object> queryPageInfo(int limit,int offset);
	
}
