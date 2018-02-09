package com.waterlab.service.impl;

import java.util.List;
import java.util.Map;

import com.waterlab.bean.FinishedWater;
import com.waterlab.dao.FinishedWaterDao;
import com.waterlab.service.FinishedWaterService;

public class FinishedWaterServiceImpl implements FinishedWaterService {
	
	private FinishedWaterDao finishedWaterDao;
	
	public FinishedWaterDao getFinishedWaterDao() {
		return finishedWaterDao;
	}

	public void setFinishedWaterDao(FinishedWaterDao finishedWaterDao) {
		this.finishedWaterDao = finishedWaterDao;
	}

	@Override
	public void add(FinishedWater finishedWater) {
		finishedWaterDao.add(finishedWater);
	}

	@Override
	public FinishedWater getById(int id) {
		FinishedWater finishedWater = finishedWaterDao.getById(id);
		return finishedWater;
	}

	@Override
	public void update(FinishedWater finishedWater) {
		finishedWaterDao.update(finishedWater);
	}

	@Override
	public void delete(FinishedWater finishedWater) {
		finishedWaterDao.delete(finishedWater);
	}

	@Override
	public void deleteById(int id) {
		finishedWaterDao.deleteById(id);
	}

	@Override
	public Map<String, Object> queryPageInfo(int limit, int offset) {
		return finishedWaterDao.queryPageInfo(limit, offset);
	}

	@Override
	public List<FinishedWater> getFinishedWater(int limit, int offset) {
		return finishedWaterDao.getFinishedWater(limit, offset);
	}

}
