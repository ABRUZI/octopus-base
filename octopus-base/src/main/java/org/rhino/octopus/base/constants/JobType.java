package org.rhino.octopus.base.constants;

public enum JobType {

	
	JAVA("01", "Java"), SHELL("02", "Shell");
	
	private String code;
	
	private String name;
	
	private JobType(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public String getName(){
		return this.name;
	}
	
}
