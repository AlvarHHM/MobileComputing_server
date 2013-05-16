package edu.mb.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class CandidateList {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long cListId;
	@Persistent
	private Long gcId;
	@Persistent
	private Long listId;
	@Persistent
	private Long candidateNum;
	@Persistent
	private String candidateName;
	@Persistent
	private Long partyId;
	public Long getcListId() {
		return cListId;
	}
	public void setcListId(Long cListId) {
		this.cListId = cListId;
	}
	public Long getGcId() {
		return gcId;
	}
	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}
	public Long getListId() {
		return listId;
	}
	public void setListId(Long listId) {
		this.listId = listId;
	}
	public Long getCandidateNum() {
		return candidateNum;
	}
	public void setCandidateNum(Long candidateNum) {
		this.candidateNum = candidateNum;
	}
	
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public Long getPartyId() {
		return partyId;
	}
	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

}
