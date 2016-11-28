package org.rhino.octopus.base.model.line;

public class Line {
	
	private String id;
	
	private String flowId;
	
	private String sourceJobId;
	
	private String targetJobId;
	
	private int condition;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceJobId() {
		return sourceJobId;
	}

	public void setSourceJobId(String sourceJobId) {
		this.sourceJobId = sourceJobId;
	}

	public String getTargetJobId() {
		return targetJobId;
	}

	public void setTargetJobId(String targetJobId) {
		this.targetJobId = targetJobId;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
}
