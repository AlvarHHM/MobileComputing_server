package edu.mb;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class DataServlet extends HttpServlet {
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	Logger log = Logger.getAnonymousLogger();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String entityName = req.getParameter("entity");
		String[] name = req.getParameterValues("name");
		String[] value = req.getParameterValues("value");
		Entity entity = new Entity(entityName);
		for(int i = 0;i<name.length;i++){
			entity.setProperty(name[i],value[i]);
		}
		
		datastore.put(entity);
	}
	
	

}
