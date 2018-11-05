package com.stock.mvc.services.Impl;

import java.io.InputStream;

import com.stock.mvc.DAO.IFlickrDao;

public class FlickrServiceImpl implements IFlickrDao{

	private IFlickrDao dao;
	
	
	public void setDao(IFlickrDao dao) {
		this.dao = dao;
	}

	@Override
	public String savePhoto(InputStream stream, String filename) throws Exception {
		return dao.savePhoto(stream, filename);
	}
	
	

}
