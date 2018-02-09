package com.waterlab.service.impl;

import java.util.Map;

import com.waterlab.bean.User;
import com.waterlab.dao.UserDao;
import com.waterlab.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
		
	@Override
	public void addUser(User user) {
		userDao.add(user);
	}

	@Override
	public User getById(int id) {
		User user = userDao.getById(id);
		return user;
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void deleteById(int id) {
		userDao.deleteById(id);
	}

	@Override
	public Map<String, Object> queryPageInfo(int limit, int offset) {
		return userDao.queryPageInfo(limit, offset);
	}

	@Override
	public boolean findUserByNP(User user) {	
		return userDao.getByNP(user);
	}

	@Override
	public boolean findUserByName(User user) {
		return userDao.getByName(user);
	}

	@Override
	public User getUserByName(User user) {
		return userDao.findByName(user);
	}

}
