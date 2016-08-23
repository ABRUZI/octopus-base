package org.rhino.octopus.base.model.job;

public interface IExecJob {
	
	public void preparation(String param);
	
	public void execution();
	
	public void finalization();
}
