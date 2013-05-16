package edu.mb.api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

import edu.mb.db.CandidateList;
import edu.mb.db.Elector;
import edu.mb.db.GcDistrict;
import edu.mb.db.PMF;
import edu.mb.db.Party;
import edu.mb.db.PollData;

@Api(name = "data")
public class ExitPollEndPoint {
	PersistenceManager pm = PMF.get().getPersistenceManager();

	@ApiMethod(name = "retrieveAllParty")
	public List<Party> retrieveAllParty() {
		return (List<Party>) pm.newQuery(Party.class).execute();

	}

	@ApiMethod(name = "retrieveAllDistrict")
	public List<GcDistrict> retrieveAllDistrict() {
		return (List<GcDistrict>) pm.newQuery(GcDistrict.class).execute();

	}

	@ApiMethod(name = "retrieveCandidateList")
	public List<CandidateList> retrieveCandidateList(@Named("gcId") Long gcId) {
		Query query = pm.newQuery(CandidateList.class);
		query.setFilter("gcId==gcIdParam");
		query.declareParameters("Long gcIdParam");
		List<CandidateList> list = (List<CandidateList>) query.execute(gcId);
		if (list == null)
			return new ArrayList<CandidateList>();
		else
			return (List<CandidateList>) query.execute(gcId);
	}

	@ApiMethod(name = "uploadPollData")
	public void uploadPollData(PollData data, @Named("electorId") Long electorId) {
		data.setElectorId(electorId);
		pm.makePersistent(data);
	}

	@ApiMethod(name = "uploadElector")
	public Elector uploadElector(Elector elector) {
		pm.makePersistent(elector);
		return elector;
	}

	// @ApiMethod(name = "uploadElectorAndPollData",httpMethod = "POST")
	// public void uploadElectorAndPollData(Elector elector,PollData poll){
	// pm.makePersistent(elector);
	// poll.setElectorId(elector.getElectorId());
	// pm.makePersistent(poll);
	// }

	// @ApiMethod(name = "uploadPollDataList",httpMethod = "POST")
	// public void uploadPollDataList(List<Elector> elector, List<PollData>
	// data){
	// pm.makePersistent(elector);
	// for(int i = 0;i< elector.size();i++){
	// data.get(i).setElectorId(elector.get(i).getElectorId());
	// }
	// pm.makePersistent(data);
	// }

	// @ApiMethod(name = "test")
	// public void testSomething(PollData data){
	//
	//
	// }
	//
	// @ApiMethod(name = "testagain")
	// public void testSomethingAgain(Elector elector){
	//
	//
	// }
}
