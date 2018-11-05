package com.stock.mvc.DAO;

import java.io.InputStream;

public interface IFlickrDao {

	public String savePhoto(InputStream stream,String filename) throws Exception;
}
