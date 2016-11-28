package org.rhino.octopus.base.model.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.rhino.octopus.base.model.job.JobProperties;

public class OctopusLog {
	
	private static final String DATE_FORMAT_STR = "yyyy-MM-dd hh:mm:ss S";
	
	private static final String BREAK_LINE = "\\n"; 

	private StringBuilder builder = new StringBuilder();

	private JobProperties jobProps;

	public OctopusLog(JobProperties jobProps){
		this.jobProps = jobProps;
	}
	
	public String getLog(){
		return this.builder.toString();
	}
	
	public synchronized void clear(){
		this.builder.delete(0,  this.builder.length());
	}
	
	public synchronized void log(String content){
		builder.append(this.createPrefix());
		builder.append(content);
		builder.append(BREAK_LINE);
	}
	
	private String createPrefix(){
		StringBuilder prefix = new StringBuilder();
		prefix.append("[");
		prefix.append("jobId=");
		prefix.append(this.jobProps.getId());
		prefix.append("jobName=");
		prefix.append(this.jobProps.getName());
		prefix.append(new SimpleDateFormat(DATE_FORMAT_STR).format(new Date()));
		prefix.append("]:");
		
		return prefix.toString();
		
	}
	
	
}
