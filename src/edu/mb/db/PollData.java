package edu.mb.db;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class PollData {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long pdId;
	@Persistent
	private Long userId ;
	@Persistent
	private Date timestamp;
	@Persistent
	private Long gcId;
	@Persistent
	private Long listId;
	@Persistent
	private Long electorId;
	public Long getPdId() {
		return pdId;
	}
	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
	public Long getElectorId() {
		return electorId;
	}
	public void setElectorId(Long electorId) {
		this.electorId = electorId;
	}
	
}
