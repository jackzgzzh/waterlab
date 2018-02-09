package com.waterlab.service.impl;

import java.util.Map;

import com.waterlab.bean.SourceWater;
import com.waterlab.dao.SourceWaterDao;
import com.waterlab.service.SourceWaterService;

public class SourceWaterServiceImpl implements SourceWaterService{

	private SourceWaterDao sourceWaterDao;

	public SourceWaterDao getSourceWaterDao() {
		return sourceWaterDao;
	}

	public void setSourceWaterDao(SourceWaterDao sourceWaterDao) {
		this.sourceWaterDao = sourceWaterDao;
	}

	@Override
	public void add(SourceWater sourceWater) {
		sourceWaterDao.add(sourceWater);
	}

	@Override
	public SourceWater getById(int id) {
		SourceWater sourceWater = sourceWaterDao.getById(id);
		return sourceWater;
	}

	@Override
	public void update(SourceWater sourceWater) {
		sourceWaterDao.update(sourceWater);
	}

	@Override
	public void delete(SourceWater sourceWater) {
		sourceWaterDao.delete(sourceWater);
	}

	@Override
	public Map<String, Object> queryPageInfo(int limit, int offset) {
		return sourceWaterDao.queryPageInfo(limit, offset);
	}

	@Override
	public void deleteById(int id) {
		sourceWaterDao.deleteById(id);
	}

}
