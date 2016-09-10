package org.rhino.octopus.base.datasource;

import org.apache.commons.dbcp.BasicDataSource;
import org.rhino.octopus.base.configuration.OctopusConfiguration;
import org.rhino.octopus.base.configuration.OctopusConfiguration.ConfigurationItem;
import org.rhino.octopus.base.configuration.Property;
import org.rhino.octopus.base.constants.ConfConstants;
import org.rhino.octopus.base.exception.OctopusException;

public class OctopusDataSource extends BasicDataSource {
	
	private OctopusConfiguration conf;

	public OctopusDataSource() throws OctopusException{
			try{
			this.conf = new OctopusConfiguration(new String[]{ConfConstants.getConfPath() + "/octopus-common.xml"});
			this.setUrl(this.getConfigUrl());
			this.setDriverClassName(this.conf.getProperty(ConfigurationItem.DB_DRIVER_CLASS).getValue());
			this.setUsername(this.conf.getProperty(ConfigurationItem.DB_USER_NAME).getValue());
			this.setPassword(this.conf.getProperty(ConfigurationItem.DB_PASSWD).getValue());
		}catch(Exception e){
			throw new OctopusException(e);
		}
		try{
			Property maxActiveProp = this.conf.getProperty(ConfigurationItem.DB_MAX_ACTIVE);
			this.setMaxActive(Integer.parseInt(maxActiveProp.getValue()));
		}catch(Exception e){
			this.setMaxActive(20);
		}
		
		try{
			Property maxIdleProp = this.conf.getProperty(ConfigurationItem.DB_MAX_IDLE);
			this.setMaxIdle(Integer.parseInt(maxIdleProp.getValue()));
		}catch(Exception e){
			this.setMaxIdle(10);
		}
		
		try{
			Property minIdleProp = this.conf.getProperty(ConfigurationItem.DB_MIN_IDLE);
			this.setMinIdle(Integer.parseInt(minIdleProp.getValue()));
		}catch(Exception e){
			this.setMinIdle(10);
		}
		
		
		try{
			Property maxWaitProp = this.conf.getProperty(ConfigurationItem.DB_MAX_WAIT);
			this.setMaxWait(Integer.parseInt(maxWaitProp.getValue()));
		}catch(Exception e){
			this.setMaxWait(10);
		}
		
		try{
			Property removeAbandonedProp = this.conf.getProperty(ConfigurationItem.DB_REMOVE_ABANDONED);
			this.setRemoveAbandoned(Boolean.parseBoolean(removeAbandonedProp.getValue()));
		}catch(Exception e){
			this.setRemoveAbandoned(true);
		}
		
		try{
			Property removeAbandonedTimeoutProp = this.conf.getProperty(ConfigurationItem.DB_REMOVE_ABANDONED_TIMEOUT);
			this.setRemoveAbandonedTimeout(Integer.parseInt(removeAbandonedTimeoutProp.getValue()));
		}catch(Exception e){
			this.setRemoveAbandonedTimeout(60);
		}
		
		try{
			Property testOnBorrowProp = this.conf.getProperty(ConfigurationItem.DB_TEST_ON_BORROW);
			this.setTestOnBorrow(Boolean.parseBoolean(testOnBorrowProp.getValue()));
		}catch(Exception e){
			this.setTestOnBorrow(true);
		}
		
		try{
			Property testOnReturnProp = this.conf.getProperty(ConfigurationItem.DB_TEST_ON_RETURN);
			this.setTestOnReturn(Boolean.parseBoolean(testOnReturnProp.getValue()));
		}catch(Exception e){
			this.setTestOnReturn(true);
		}
		
		try{
			Property testWhileIdleProp = this.conf.getProperty(ConfigurationItem.DB_TEST_WHILE_IDLE);
			this.setTestWhileIdle(Boolean.parseBoolean(testWhileIdleProp.getValue()));
		}catch(Exception e){
			this.setTestWhileIdle(true);
		}
		
		try{
			Property validationQueryProp = this.conf.getProperty(ConfigurationItem.DB_VALIDATION_QUERY);
			this.setValidationQuery(validationQueryProp.getValue());
		}catch(Exception e){
			this.setValidationQuery(" SELECT 1 FROM DUAL");
		}
	}
	
	
	private String getConfigUrl(){
		StringBuilder builder = new StringBuilder();
		builder.append("jdbc:mysql://");
		builder.append(this.conf.getProperty(ConfigurationItem.DB_ADDR).getValue());
		builder.append(":");
		builder.append(this.conf.getProperty(ConfigurationItem.DB_PORT));
		builder.append("/");
		builder.append(this.conf.getProperty(ConfigurationItem.DB_INSTANCE));
		return builder.toString();
	}
}
