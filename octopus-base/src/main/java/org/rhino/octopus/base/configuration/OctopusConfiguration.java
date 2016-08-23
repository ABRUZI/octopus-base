package org.rhino.octopus.base.configuration;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.rhino.octopus.base.exception.OctopusException;
import org.springframework.util.StringUtils;


public class OctopusConfiguration {
	
	private static final String ZOO_KEEPER_NAME = "octopus.common.zookeeper";
	
	private static final String SLAVER_LOCAL_LISTENER_PORT_NAME = "octopus.slaver.locallistener.port";
	
	private static final String MASTER_LOCAL_LISTENER_PORT_NAME = "octopus.master.locallistener.port";
	
	private static final String SLAVER_REMOTE_LISTENER_PORT_NAME = "octopus.common.slaver.remotelistener.port";
	
	private static final String MASTER_REMOTE_LISTENER_PORT_NAME = "octopus.common.master.remotelistener.port";
	
	private static final String USR_LIB_PATH_NAME = "octopus.slaver.userlib.path";
	
	private static final String DB_ADDR_NAME = "octopus.common.db.addr";
	
	private static final String DB_PORT_NAME = "octopus.common.db.port";
	
	private static final String DB_USER_NAME = "octopus.common.db.user";
	
	private static final String DB_PASSWD_NAME = "octopus.common.db.password";
	
	private static final String DB_INSTANCE_NAME = "octopus.common.db.name";
	
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
			throw new OctopusException("");
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
		
		ZOO_KEEPER(ZOO_KEEPER_NAME), 
		SLAVER_LOCAL_LISTENER_PORT(SLAVER_LOCAL_LISTENER_PORT_NAME),
		SLAVER_REMOTE_LISTENER_PORT(SLAVER_REMOTE_LISTENER_PORT_NAME),
		USR_LIB_PATH(USR_LIB_PATH_NAME),
		MASTER_LOCAL_LISTENER_PORT(MASTER_LOCAL_LISTENER_PORT_NAME),
		MASTER_REMOTE_LISTENER_PORT(MASTER_REMOTE_LISTENER_PORT_NAME),
		DB_ADDR(DB_ADDR_NAME),DB_PORT(DB_PORT_NAME),DB_PASSWD(DB_PASSWD_NAME),
		DB_USER(DB_USER_NAME),DB_INSTANCE(DB_INSTANCE_NAME);
		
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
