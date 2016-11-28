package org.rhino.octopus.base.constants;

public enum FlowRuntimeStatus {

	
	RUNNING("01", "执行中"), SUCCESS("02", "执行成功"), FAIL("03", "执行出错"), SHUTDOWN("04", "执行被终止");
	
	
	private String code;
	
	private String name;
	
	FlowRuntimeStatus(String code, String name){
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
}
