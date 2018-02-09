package com.waterlab.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.waterlab.bean.Header;
import com.waterlab.dao.HeaderDao;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class HeaderDaoImpl implements HeaderDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(Header header) {
		Session session = sessionFactory.getCurrentSession();
		session.save(header);
	}

	@Override
	public Header getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Header header =  (Header) session.get(Header.class, id);
		return header;
	}

	@Override
	public void update(Header header) {
		Session session = sessionFactory.getCurrentSession();
		session.update(header);
	}

	@Override
	public void delete(Header header) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(header);
	}

	@Override
	public Header findHeader() {
		String hql = "from Header as h order by h.id desc";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		return (Header) query.list().get(0);
	}

}
