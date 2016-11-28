package org.rhino.octopus.base.exception;

public class OctopusException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2606217152781001213L;

	public OctopusException(Exception e) {
		super((Throwable)e);
	}
	
	public OctopusException(String message){
		super(message);
	}

}
