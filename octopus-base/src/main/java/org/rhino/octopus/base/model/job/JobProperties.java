package org.rhino.octopus.base.model.job;

/**
 * 任务属性类
 * @author 王铁
 *
 */
public class JobProperties {
	
	/**
	 * 任务ID
	 */
	private String id;
	
	/**
	 * 任务所属的流程ID
	 */
	private String flowId;
	
	/**
	 * 任务名称
	 */
	private String name;
	
	/**
	 * 任务执行失败是否要结束整个Flow
	 */
	private boolean fatal = false;
	
	/**
	 * 任务启动类
	 */
	private String clsName;
	
	/**
	 * 是否是判断节点
	 */
	private boolean judge;
	
	/**
	 * 任务类型代码
	 * 01 Java
	 * 02 Shell
	 */
	private String jobTypeCode;

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

	public boolean isFatal() {
		return fatal;
	}

	public void setFatal(boolean fatal) {
		this.fatal = fatal;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public boolean isJudge() {
		return judge;
	}

	public void setJudge(boolean judge) {
		this.judge = judge;
	}

	public String getJobTypeCode() {
		return jobTypeCode;
	}

	public void setJobTypeCode(String jobTypeCode) {
		this.jobTypeCode = jobTypeCode;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	
}
