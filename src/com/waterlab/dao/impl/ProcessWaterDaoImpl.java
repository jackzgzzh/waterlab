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

import com.waterlab.bean.ProcessWater;
import com.waterlab.dao.ProcessWaterDao;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ProcessWaterDaoImpl implements ProcessWaterDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(ProcessWater processWater) {
		Session session = sessionFactory.getCurrentSession();
		session.save(processWater);
	}

	@Override
	public ProcessWater getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		ProcessWater processWater = (ProcessWater) session.get(ProcessWater.class, id);
		return processWater;
	}

	@Override
	public void update(ProcessWater processWater) {
		Session session = sessionFactory.getCurrentSession();
		session.update(processWater);
	}

	@Override
	public void delete(ProcessWater processWater) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(processWater);
	}

	@Override
	public void deleteById(int id) {
		ProcessWater processWater = this.getById(id);
		this.delete(processWater);
	}

	@Override
	public Map<String, Object> queryPageInfo(int limit, int offset) {
		String hql = "from ProcessWater as p order by p.id desc";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);		
		List<ProcessWater> processWaterList = query.list();
		
		String sql = "select count(*) from ProcessWater";
		int total = Integer.parseInt(session.createQuery(sql).uniqueResult().toString());
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", processWaterList);
		
		return map;
	}

	@Override
	public ProcessWater getProcessWater() {
		String hql = "from ProcessWater as p order by p.id desc";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		ProcessWater processWater = (ProcessWater) query.list().get(0);
		
		return processWater;
	}

}
