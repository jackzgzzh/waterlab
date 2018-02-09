package com.waterlab.dao;

import java.util.Map;

import com.waterlab.bean.User;

public interface UserDao {
	
	public void add(User user);
	
	public User getById(int id);
	
	public void update(User user);
	
	public void delete(User user);
	
	//根据用户名和密码查询
	public boolean getByNP(User user);
	
	public boolean getByName(User user);
	
	public User findByName(User user);
	
	public void deleteById(int id);
	
	public Map<String,Object> queryPageInfo(int limit,int offset);
	
	
}
