package org.rhino.octopus.base.constants;

public enum JobRuntimeStatus {
	
	RUNNING("01", "执行中"), SUCCESS("02", "执行成功"), FAIL("03", "执行出错");
	
	private String code;
	
	private String name;
	
	JobRuntimeStatus(String code, String name){
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
