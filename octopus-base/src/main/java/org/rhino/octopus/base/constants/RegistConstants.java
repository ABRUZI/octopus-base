package org.rhino.octopus.base.constants;

import java.net.UnknownHostException;

import org.rhino.octopus.base.exception.OctopusException;
import org.rhino.octopus.base.util.IPUtil;
import org.springframework.util.StringUtils;

public final class RegistConstants {

	private RegistConstants(){}
	
	public static final String ROOT_REGIST_NODE = "/octopus";
	
	public static final String SLAVERS_REGIST_NODE = "/octopus/slavers";
	
	public static final String MASTER_REGIST_NODE = "/octopus/masters";
	
	private static String slaveNode;
	
	private static String masterNode;
	
	public static String getSlaveNode()throws OctopusException{
		
		if(StringUtils.hasText(slaveNode) == false){
			slaveNode = initNode(SLAVERS_REGIST_NODE);
		}
		
		return slaveNode;
	}
	
	
	public static String getMasterNode()throws OctopusException{
		if(StringUtils.hasText(masterNode) == false){
			masterNode = initNode(MASTER_REGIST_NODE);
		}
		return masterNode;
	}
	
	private static String initNode(String prefix) throws OctopusException{
		StringBuilder builder = new StringBuilder();
		builder.append(prefix);
		builder.append("/");
		try {
			builder.append(IPUtil.getLocalIPAddress());
		} catch (UnknownHostException e) {
			throw new OctopusException(e);
		}
		
		return builder.toString();
	}
}
