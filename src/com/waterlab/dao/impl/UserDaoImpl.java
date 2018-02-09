package com.waterlab.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.waterlab.bean.User;
import com.waterlab.dao.UserDao;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public User getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User  user =  (User) session.get(User.class, id);
		return user;
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	@Override
	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

	@Override
	public boolean getByNP(User user) {
		boolean flag = false;
		String hql = "from User u where u.userName = ? and u.password = ?";
		Session session = sessionFactory.getCurrentSession();

		try {
			Query query = session.createQuery(hql);
			query.setString(0, user.getUserName());
			query.setString(1, user.getPassword());
			if(query.list().size() > 0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean getByName(User user) {
		boolean flag = false;
		String hql = "from User u where u.userName = ?";
		Session session = sessionFactory.getCurrentSession();
		List<User> listUser = null;
		try {
			Query query = session.createQuery(hql);
			query.setString(0, user.getUserName());
			if(query.list().size()>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public void deleteById(int id) {
		User user = this.getById(id);
		this.delete(user);
	}

	@Override
	public Map<String, Object> queryPageInfo(int limit, int offset) {
		String hql = "from User as u order by u.id desc";
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		List<User> userList = query.list();
		
		String sql = "select count(*) from User";
		int total = Integer.parseInt(session.createQuery(sql).uniqueResult().toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", userList);
		
		return map;
	}

	@Override
	public User findByName(User user) {
		String hql = "from User u where u.userName = ?";
		Session session = sessionFactory.getCurrentSession();
		List<User> listUser = null;
		try {
			Query query = session.createQuery(hql);
			query.setString(0, user.getUserName());
			listUser = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser.get(0);
	}


}
