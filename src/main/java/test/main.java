package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.stock.mvc.DAO.impl.FlickrDaoImpl;

public class main {

	public static void main(String[] args) {
			
		FlickrDaoImpl flickr = new FlickrDaoImpl();
		//flickr.auth();
	
	
	try {
		InputStream stream = new FileInputStream(new File("C:\\Users\\EC\\Desktop\\re.jpg"));
		String url = flickr.savePhoto(stream, "img test1");
		System.out.println(url);
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}
	
}
}