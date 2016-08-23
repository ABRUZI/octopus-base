package org.rhino.octopus.base.model.flow;

public class FlowLog {
	
	/**
	 * Flow执行的ID，每次执行都会有一个新的ID
	 */
	private String runtimeId;

	/**
	 * Flow的ID
	 */
	private String flowId;
	
	/**
	 * Flow名称
	 */
	private String flowName;
	
	/**
	 * Flow状态״̬
	 */
	private String status;

	public String getRuntimeId() {
		return runtimeId;
	}

	public void setRuntimeId(String runtimeId) {
		this.runtimeId = runtimeId;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
