package edu.mb.api;

import java.util.List;

import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import edu.mb.db.Account;
import edu.mb.db.PMF;

@Api(name = "account")
public class AccountEndPoint {
	PersistenceManager pm = PMF.get().getPersistenceManager();

	@ApiMethod(name = "login")
	public Account login(@Named("username") String username,
			@Named("password") String password) {
		Query q = pm.newQuery(Account.class);
		q.setFilter("username == usernameParam && password==passwordParam");
		q.declareParameters("String usernameParam,String passwordParam");
		List<Account> result = ((List) q.execute(username, password));
		if (result.size() > 0)
			return result.get(0);
		return null;

	}


}



