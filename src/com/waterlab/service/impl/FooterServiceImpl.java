package com.waterlab.service.impl;

import com.waterlab.bean.Footer;
import com.waterlab.dao.FooterDao;
import com.waterlab.service.FooterService;

public class FooterServiceImpl implements FooterService {
	
	private FooterDao footerDao;
	
	public FooterDao getFooterDao() {
		return footerDao;
	}

	public void setFooterDao(FooterDao footerDao) {
		this.footerDao = footerDao;
	}

	@Override
	public void add(Footer footer) {
		footerDao.add(footer);
	}

	@Override
	public Footer find(int id) {
		Footer footer = footerDao.getById(id);
		return footer;
	}

	@Override
	public void update(Footer footer) {
		footerDao.update(footer);
	}

	@Override
	public void delete(Footer footer) {
		footerDao.delete(footer);
	}

}
