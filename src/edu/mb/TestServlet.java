package edu.mb;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import edu.mb.db.Account;

public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity entity;
		
//		entity = new Entity("Account");
//		entity.setProperty("accountType", 0);
//		entity.setProperty("username", "mahoihei");
//		entity.setProperty("password", "mahoihei");
//		datastore.put(entity);
//		
//		entity = new Entity("Account");
//		entity.setProperty("accountType", 1);
//		entity.setProperty("username", "hoiheima");
//		entity.setProperty("password", "hoiheima");
//		datastore.put(entity);
		
		entity = new Entity("CandidateList");
		entity.setProperty("gcId", 11001L);
		entity.setProperty("listId", 6L);
		entity.setProperty("candidateNum", 1L);
		entity.setProperty("candidateName", "kkElizabeth Quat (EQ)");
		entity.setProperty("partyId", 3002L);
		datastore.put(entity);
		
		entity = new Entity("CandidateList");
		entity.setProperty("gcId", 11001L);
		entity.setProperty("listId", 6L);
		entity.setProperty("candidateNum", 2L);
		entity.setProperty("candidateName", "Chong Yuen Tung, Kenny");
		entity.setProperty("partyId", 3002L);
		datastore.put(entity);
		
		entity = new Entity("CandidateList");
		entity.setProperty("gcId", 11001L);
		entity.setProperty("listId", 6L);
		entity.setProperty("candidateNum", 3L);
		entity.setProperty("candidateName", "Li Sai Wing, Stanley");
		entity.setProperty("partyId", 3002L);
		datastore.put(entity);
		
		entity = new Entity("CandidateList");
		entity.setProperty("gcId", 11001L);
		entity.setProperty("listId", 3L);
		entity.setProperty("candidateNum", 1L);
		entity.setProperty("candidateName", "kkLau Wai-hing, Emily");
		entity.setProperty("partyId", 5001L);
		datastore.put(entity);
		
		entity = new Entity("CandidateList");
		entity.setProperty("gcId", 11001L);
		entity.setProperty("listId", 3L);
		entity.setProperty("candidateNum", 2L);
		entity.setProperty("candidateName", "Or Yiu-lam, Ricky ");
		entity.setProperty("partyId", 5001L);
		datastore.put(entity);
		
		entity = new Entity("CandidateList");
		entity.setProperty("gcId", 11001L);
		entity.setProperty("listId", 3L);
		entity.setProperty("candidateNum", 3L);
		entity.setProperty("candidateName", "Lam Siu-chung, Frankie");
		entity.setProperty("partyId", 5001L);
		datastore.put(entity);
		
		
	}
	

}
