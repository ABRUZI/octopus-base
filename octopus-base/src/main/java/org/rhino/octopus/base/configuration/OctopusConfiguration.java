package org.rhino.octopus.base.configuration;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.rhino.octopus.base.constants.ConfConstants;
import org.rhino.octopus.base.exception.OctopusException;
import org.springframework.util.StringUtils;


public class OctopusConfiguration {
	
	private static final String PROPERTY_NAME_KEY = "name";
	
	private static final String PROPERTY_VALUE_KEY = "value";
	
	private Map<ConfigurationItem, Property> propMap = null;
	
	public OctopusConfiguration(String[] configPath) throws OctopusException{
		this.propMap = new HashMap<ConfigurationItem, Property>();
		for(int i = 0, len = configPath.length; i < len; i++){
			this.loadConfigFile(configPath[i]);
		}
	}
	
	private void loadConfigFile(String filePath)throws OctopusException{
		try{
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File(filePath));
			Element root = doc.getRootElement();
			List<Element> elmList = root.elements();
			for(int i = 0, len = elmList.size(); i < len; i++){
				Element elm = elmList.get(i);
				this.initProperty(elm);
			}
		}catch(Exception e){
			throw new OctopusException(e);
		}
	}
	
	private void initProperty(Element elm)throws OctopusException{
		
		Element nameElm = elm.element(PROPERTY_NAME_KEY);
		Element valueElm = elm.element(PROPERTY_VALUE_KEY);
		if(nameElm == null){
			throw new OctopusException("");
		}
		
		if(valueElm == null){
			throw new OctopusException("");
		}
		
		String name = nameElm.getStringValue();
		String value = valueElm.getStringValue();
		
		
		if(StringUtils.hasText(name) == false){
			throw new OctopusException(" ");
		}
		
		if(StringUtils.hasText(value) == false){
			throw new OctopusException("");
		}
		
		Property property = new Property();
		property.setName(name);
		property.setValue(value);
		ConfigurationItem item = ConfigurationItem.getItem(name);
		if(item == null){
			throw new OctopusException(" " + name);
		}
		this.propMap.put(item, property);
	}
	
	public Property getProperty(ConfigurationItem item){
		return this.propMap.get(item);
	}
	
	public enum ConfigurationItem{
		
		ZOO_KEEPER(ConfConstants.ZOO_KEEPER_NAME), 
		SLAVER_LOCAL_LISTENER_PORT(ConfConstants.SLAVER_LOCAL_LISTENER_PORT_NAME),
		SLAVER_REMOTE_LISTENER_PORT(ConfConstants.SLAVER_REMOTE_LISTENER_PORT_NAME),
		USR_LIB_PATH(ConfConstants.USR_LIB_PATH_NAME),
		MASTER_LOCAL_LISTENER_PORT(ConfConstants.MASTER_LOCAL_LISTENER_PORT_NAME),
		MASTER_REMOTE_LISTENER_PORT(ConfConstants.MASTER_REMOTE_LISTENER_PORT_NAME),
		DB_ADDR(ConfConstants.DB_ADDR_NAME),DB_PORT(ConfConstants.DB_PORT_NAME),DB_PASSWD(ConfConstants.DB_PASSWD_NAME),
		DB_INSTANCE(ConfConstants.DB_INSTANCE_NAME),
		DB_DRIVER_CLASS(ConfConstants.DB_DRIVER_CLASS_NAME),
		DB_MAX_ACTIVE(ConfConstants.DB_MAX_ACTIVE),
		DB_USER_NAME(ConfConstants.DB_USER_NAME),
		DB_MAX_IDLE(ConfConstants.DB_MAX_IDLE),
		DB_MIN_IDLE(ConfConstants.DB_MIN_IDLE),
		DB_MAX_WAIT(ConfConstants.DB_MAX_WAIT),
		DB_REMOVE_ABANDONED(ConfConstants.DB_REMOVE_ABANDONED),
		DB_REMOVE_ABANDONED_TIMEOUT(ConfConstants.DB_REMOVE_ABANDONED_TIMEOUT),
		DB_TEST_ON_BORROW(ConfConstants.DB_TEST_ON_BORROW),
		DB_TEST_ON_RETURN(ConfConstants.DB_TEST_ON_RETURN),
		DB_TEST_WHILE_IDLE(ConfConstants.DB_TEST_WHILE_IDLE),
		DB_VALIDATION_QUERY(ConfConstants.DB_VALIDAION_QUERY);
		private String name;
		
		private ConfigurationItem(String name){
			this.name = name;
		}
		
		public String getName(){
			return name;
		}
		
		public static ConfigurationItem getItem(String name){
			ConfigurationItem res = null;
			ConfigurationItem[] items = ConfigurationItem.values();
			for(int i = 0, len = items.length; i < len; i++){
				ConfigurationItem item = items[i];
				if(name.equals(item.getName())){
					res = item;
					break;
				}
			}
			return res;
		}
	}
}
