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

import com.waterlab.bean.SourceWater;
import com.waterlab.dao.SourceWaterDao;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class SourceWaterDaoImpl implements SourceWaterDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(SourceWater sourceWater) {
		Session session = sessionFactory.getCurrentSession();
		session.save(sourceWater);
	}

	@Override
	public SourceWater getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		SourceWater sourceWater = (SourceWater) session.get(SourceWater.class, id);
		return sourceWater;
	}

	@Override
	public void update(SourceWater sourceWater) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sourceWater);
	}

	@Override
	public void delete(SourceWater sourceWater) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(sourceWater);
	}

	@Override
	public Map<String, Object> queryPageInfo(int limit, int offset) {
		String hql = "from SourceWater as s order by s.id desc"; 
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		List<SourceWater> sourceWaterList = query.list();
		
		String sql = "select count(*) from SourceWater";
		int total = Integer.parseInt(session.createQuery(sql).uniqueResult().toString());
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", sourceWaterList); //rows返回分页后的数据
		return map;
	}

	@Override
	public void deleteById(int id) {
		SourceWater sourceWater = getById(id);
		delete(sourceWater);
	}

}
