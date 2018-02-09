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

import com.waterlab.bean.FinishedWater;
import com.waterlab.bean.SourceWater;
import com.waterlab.dao.FinishedWaterDao;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class FinishedWaterDaoImpl implements FinishedWaterDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(FinishedWater finishedWater) {
		Session session = sessionFactory.getCurrentSession();
		session.save(finishedWater);
	}

	@Override
	public FinishedWater getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		FinishedWater finishedWater = (FinishedWater) session.get(FinishedWater.class, id);
		return finishedWater;
	}

	@Override
	public void update(FinishedWater finishedWater) {
		Session session = sessionFactory.getCurrentSession();
		session.update(finishedWater);
	}

	@Override
	public void delete(FinishedWater finishedWater) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(finishedWater);
	}

	@Override
	public void deleteById(int id) {
		FinishedWater finishedWater = getById(id);
		delete(finishedWater);
	}

	@Override
	public Map<String, Object> queryPageInfo(int limit, int offset) {
		String hql = "from FinishedWater as f order by f.id desc"; 
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		List<FinishedWater> finishedWaterList = query.list();
		
		String sql = "select count(*) from FinishedWater";
		int total = Integer.parseInt(session.createQuery(sql).uniqueResult().toString());
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", finishedWaterList); //rows返回分页后的数据
		return map;
	}
	
	//为linechart提供数据
	@Override
	public List<FinishedWater> getFinishedWater(int limit,int offset) {
		String hql = "from FinishedWater as f order by f.id desc";
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		List<FinishedWater> finishedWaterList = query.list();
		return finishedWaterList;
	}

}
