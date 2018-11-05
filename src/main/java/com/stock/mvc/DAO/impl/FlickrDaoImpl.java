package com.stock.mvc.DAO.impl;

import java.io.InputStream;

import javax.swing.JOptionPane;

import org.scribe.model.Token;
import org.scribe.model.Verifier;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.uploader.UploadMetaData;

import com.stock.mvc.DAO.IFlickrDao;

public class FlickrDaoImpl implements IFlickrDao{

	private Flickr flickr;
	
	private UploadMetaData uplaodMetaData = new UploadMetaData();
	
	private String apiKey = "570e55ed9fb2fc4be9fb34ce333c34b3";
	
	private String sharedSecret ="7715528e197ce6df";
	
	public void connect() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		Auth auth = new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("72157697374458060-14c69018cf53297f");
		auth.setTokenSecret("70aff9ff2ca568ae");
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
	}

	@Override
	public String savePhoto(InputStream stream, String title) throws Exception{
		connect();
		uplaodMetaData.setTitle(title);
		String photoId = flickr.getUploader().upload(stream, uplaodMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}
	
	public void auth() {
		
		flickr = new Flickr(apiKey, sharedSecret,new  REST());
		
		AuthInterface authInterface = flickr.getAuthInterface();
		
		Token token = authInterface.getRequestToken();
		System.out.println("token :" + token);
		String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
		System.out.println("suis ce url pour ce autoriser sur flickr");
		System.out.println(url); 
		System.out.println("clle le url qui vous etes donner");
		System.out.println(">>");
		
		String tokenKey = JOptionPane.showInputDialog(null);
		
		Token requestToken = authInterface.getAccessToken(token,new Verifier(tokenKey));
		
		Auth auth = null;
		
		try {
			auth = authInterface.checkToken(requestToken);
		}
		catch (FlickrException e) {
			e.printStackTrace();
			
		}
		
		System.out.println("Token: " + requestToken.getToken());
		System.out.println("Secret:" + requestToken.getSecret());
		System.out.println("nsid" + auth.getUser().getId());
		System.out.println("Realname :" + auth.getUser().getRealName());
		System.out.println("Username :" + auth.getUser().getUsername());
		System.out.println("Permission :" + auth.getPermission().getType());
		
	}
	
	
}
