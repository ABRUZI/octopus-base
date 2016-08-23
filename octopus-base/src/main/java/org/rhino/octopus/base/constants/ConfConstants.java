package org.rhino.octopus.base.constants;

public class ConfConstants {

	private static final String ENV = "OCTOPUS_HOME";
	
	private static final String CONF_PATH = "/conf";
	
	public static String getRuntimePath(){
		return System.getenv(ENV);
	}
	
	public static final String getConfPath(){
		return getRuntimePath() + CONF_PATH;
	}
	
}
