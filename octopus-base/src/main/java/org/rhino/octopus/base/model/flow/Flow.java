package org.rhino.octopus.base.model.flow;

import java.util.List;

import org.rhino.octopus.base.model.job.JobProperties;
import org.rhino.octopus.base.model.line.Line;


public class Flow {

	private String id;
	
	private String name;
	
	private String cronExpr;
	
	private List<JobProperties> jobList;
	
	private List<Line> lineList;
	
	private String param;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<JobProperties> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobProperties> jobList) {
		this.jobList = jobList;
	}

	public List<Line> getLineList() {
		return lineList;
	}

	public void setLineList(List<Line> lineList) {
		this.lineList = lineList;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getCronExpr() {
		return cronExpr;
	}

	public void setCronExpr(String cronExpr) {
		this.cronExpr = cronExpr;
	}
}
