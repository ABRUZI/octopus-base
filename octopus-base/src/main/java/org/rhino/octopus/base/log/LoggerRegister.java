package org.rhino.octopus.base.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.rhino.octopus.base.exception.OctopusException;

/**
 * 日志注册器
 * 各个应用按照规则，注册自己需要的日志记录方式
 * 目前只提供了DailyRollingFileAppender的日志打印方式
 * 使用方主要是用这个把日志按照意图分开到不同的文件中去
 * @author 王铁
 */
public class LoggerRegister {
	
	private static final String DATE_FORMAT_STR = "yyyy-MM-dd";
	
	private static final String CONTENT_FORMAT_STR = "%-d{yyyy-MM-dd HH:mm:ss} [ %t:%r ] - [ %p ] %m%n";

	
	public static final int LEVEL_ERROR = 0;
	
	public static final int LEVEL_DEBUG  = 1;
	
	public static final int LEVEL_INFO = 2;
	
	
	private LoggerRegister(){}
	

	public static void register(String name, int level, String path)throws OctopusException{
		try {
			Layout layout = new PatternLayout(CONTENT_FORMAT_STR);
			DailyRollingFileAppender appender = new DailyRollingFileAppender(layout,path, DATE_FORMAT_STR);
			appender.setName(name);
			appender.setAppend(true);
			Level logLevel = null;
			
			switch(level){
				case LEVEL_ERROR:
					logLevel = Level.ERROR;
					break;
				case LEVEL_DEBUG:
					logLevel = Level.DEBUG;
					break;
				case LEVEL_INFO:
					logLevel = Level.INFO;
					break;
				default:
					logLevel = Level.ERROR;
					break;
			}
			appender.setThreshold(logLevel);
			BasicConfigurator.configure(appender);
		} catch (Exception e) {
			throw new OctopusException(e);
		}
	}
}
