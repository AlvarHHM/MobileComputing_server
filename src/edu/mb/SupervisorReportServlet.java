package edu.mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.*;

import edu.mb.db.CandidateList;
import edu.mb.db.Elector;
import edu.mb.db.PMF;
import edu.mb.db.Party;
import edu.mb.db.PollData;
import edu.mb.db.Report;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.log.Log;

public class SupervisorReportServlet extends HttpServlet {
	PersistenceManager pm = PMF.get().getPersistenceManager();
	private Logger log = Logger.getAnonymousLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		int reportType = Integer.parseInt(req.getParameter("type"));
		switch (reportType) {
		case 0:
			partyReport(resp);
			break;
		case 1:
			ageReport(resp);
			break;
		}

	}

	private void ageReport(HttpServletResponse resp) throws IOException {
		List<Elector> electorList = (List<Elector>) pm.newQuery(Elector.class)
				.execute();
		ArrayList<String> labelList = new ArrayList<String>();
		ArrayList<Integer> valueList = new ArrayList<Integer>();
		String title = "Report of polls from different age group";
		valueList.add(0);
		valueList.add(0);
		valueList.add(0);
		valueList.add(0);
		labelList.add("18 - 30");
		labelList.add("31 - 45");
		labelList.add("46 - 65");
		labelList.add("above 65");
		int nonage = 0;
		for (Elector e : electorList) {
			if(e.getAge() <18)
				nonage++;
			if (e.getAge() >= 18 && e.getAge() <= 30)
				valueList.set(0, valueList.get(0) + 1);
			else if (e.getAge() >= 31 && e.getAge() <= 45)
				valueList.set(1, valueList.get(1) + 1);
			else if (e.getAge() >= 46 && e.getAge() <= 65)
				valueList.set(2, valueList.get(2) + 1);
			else if (e.getAge() >= 66)
				valueList.set(3, valueList.get(3) + 1);
		}
		log.warning(""+valueList);
		for(int i =0;i <valueList.size();i++)
			valueList.set(i, valueList.get(i)*100/(electorList.size()-nonage));
		Gson gson = new Gson();
		String jsonResp = gson.toJson(new Report(title, labelList, valueList));
		resp.getWriter().print(jsonResp);

	}

	private void partyReport(HttpServletResponse resp) throws IOException {
		List<Party> partyList = (List<Party>) pm.newQuery(Party.class)
				.execute();
		ArrayList<String> labelList = new ArrayList<String>();
		ArrayList<Integer> valueList = new ArrayList<Integer>();
		int totalCount = ((List) (pm.newQuery(PollData.class).execute()))
				.size();
		for (Party party : partyList) {
			long gcId;
			long listId;
			int count = 0;
			labelList.add(party.getPartyName());
			Query query = pm.newQuery(CandidateList.class,
					"partyId == partyIdParam");
			query.declareParameters("long partyIdParam");
			List<CandidateList> candidateLists = (List<CandidateList>) query
					.execute(party.getPartyId());
			for (CandidateList list : candidateLists) {
				gcId = list.getGcId();
				listId = list.getcListId();
				Query innerQuery = pm.newQuery(PollData.class);
				innerQuery
						.setFilter("gcId == gcIdParam && listId == listIdParam");
				innerQuery
						.declareParameters("long gcIdParam, long listIdParam");
				List<PollData> pollList = (List<PollData>) innerQuery.execute(
						gcId, listId);
				count += pollList.size();
			}
			valueList.add(count * 100 / totalCount);
		}
		log.warning("" + valueList + labelList + "" + totalCount);
		Gson gson = new Gson();
		String jsonResp = gson.toJson(new Report(
				"Report of polls of different parties", labelList, valueList));
		resp.getWriter().print(jsonResp);

	}

}
