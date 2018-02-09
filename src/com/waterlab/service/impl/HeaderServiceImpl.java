package com.waterlab.service.impl;

import com.waterlab.bean.Header;
import com.waterlab.dao.HeaderDao;
import com.waterlab.service.HeaderService;

public class HeaderServiceImpl implements HeaderService{
	
	private HeaderDao headerDao;
	
	public HeaderDao getHeaderDao() {
		return headerDao;
	}

	public void setHeaderDao(HeaderDao headerDao) {
		this.headerDao = headerDao;
	}

	@Override
	public void add(Header header) {
		headerDao.add(header);		
	}

	@Override
	public Header getById(int id) {
		Header header = headerDao.getById(id);
		return header;
	}

	@Override
	public void update(Header header) {
		headerDao.update(header);
	}

	@Override
	public void delete(Header header) {
		headerDao.delete(header);
	}

	@Override
	public Header findHeader() {
		return headerDao.findHeader();
	}

}
