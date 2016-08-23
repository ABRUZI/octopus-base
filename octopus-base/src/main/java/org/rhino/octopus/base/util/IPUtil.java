package org.rhino.octopus.base.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPUtil {
	
	public static String getLocalIPAddress() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostAddress().toString();
	}
}
