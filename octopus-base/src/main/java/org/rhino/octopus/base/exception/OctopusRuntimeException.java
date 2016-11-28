package org.rhino.octopus.base.exception;

public class OctopusRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -588137704102308599L;
	
	
	public OctopusRuntimeException(Exception e){
		super(e);
	}
	
	public OctopusRuntimeException(String message){
		super(message);
	}

}
