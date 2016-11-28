package org.rhino.octopus.base.model.job;

import java.io.File;
import java.util.List;

/**
 * 任务属性类
 * @author 王铁
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
	 * 是否是判断节点
	 */
	private boolean judge;
	
	/**
	 * 脚本文件的名称
	 */
	private String fileName;
	
	/**
	 * 脚本文件
	 */
	private File file;
	
	/**
	 * 脚本执行时的参数列表
	 */
	private List<String> paramList;

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

	public boolean isJudge() {
		return judge;
	}

	public void setJudge(boolean judge) {
		this.judge = judge;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<String> getParamList() {
		return paramList;
	}

	public void setParamList(List<String> paramList) {
		this.paramList = paramList;
	}

	@Override
	public String toString() {
		return "JobProperties [id=" + id + ", name=" + name + "]";
	}
	
}
