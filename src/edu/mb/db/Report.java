package edu.mb.db;

import java.util.List;

public class Report {
	private List<String> labelList;
	private List<Integer> valueList;
	private String title;
	public Report(String title, List<String> labelList, List<Integer> valueList) {
		super();
		this.title = title;
		this.labelList = labelList;
		this.valueList = valueList;
	}
	public List<String> getLabelList() {
		return labelList;
	}
	public void setLabelList(List<String> labelList) {
		this.labelList = labelList;
	}
	public List<Integer> getValueList() {
		return valueList;
	}
	public void setValueList(List<Integer> valueList) {
		this.valueList = valueList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
