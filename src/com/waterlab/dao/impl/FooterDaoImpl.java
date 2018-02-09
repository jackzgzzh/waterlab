package com.waterlab.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.waterlab.bean.Footer;
import com.waterlab.dao.FooterDao;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class FooterDaoImpl implements FooterDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(Footer footer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(footer);
	}

	@Override
	public Footer getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Footer footer =  (Footer) session.get(Footer.class, id);
		return footer;
	}

	@Override
	public void update(Footer footer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(footer);
	}

	@Override
	public void delete(Footer footer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(footer);
	}

}
