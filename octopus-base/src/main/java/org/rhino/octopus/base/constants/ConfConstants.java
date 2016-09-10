package org.rhino.octopus.base.constants;

public class ConfConstants {
	
	private ConfConstants(){}

	private static final String ENV = "OCTOPUS_HOME";
	
	private static final String CONF_PATH = "/conf";
	
	public static String getRuntimePath(){
		return System.getenv(ENV);
	}
	
	public static final String getConfPath(){
		return getRuntimePath() + CONF_PATH;
	}
	
	
	
	
	
	public static final String ZOO_KEEPER_NAME = "octopus.common.zookeeper";
	
	public static final String SLAVER_LOCAL_LISTENER_PORT_NAME = "octopus.slaver.locallistener.port";
	
	public static final String MASTER_LOCAL_LISTENER_PORT_NAME = "octopus.master.locallistener.port";
	
	public static final String SLAVER_REMOTE_LISTENER_PORT_NAME = "octopus.common.slaver.remotelistener.port";
	
	public static final String MASTER_REMOTE_LISTENER_PORT_NAME = "octopus.common.master.remotelistener.port";
	
	public static final String USR_LIB_PATH_NAME = "octopus.slaver.userlib.path";
	
	public static final String DB_ADDR_NAME = "octopus.common.db.addr";
	
	public static final String DB_PORT_NAME = "octopus.common.db.port";
	
	public static final String DB_USER_NAME = "octopus.common.db.user";
	
	public static final String DB_PASSWD_NAME = "octopus.common.db.password";
	
	public static final String DB_INSTANCE_NAME = "octopus.common.db.name";
	
	public static final String DB_DRIVER_CLASS_NAME = "octopus.common.db.driverClassName";
	
	public static final String DB_MAX_ACTIVE = "octopus.common.db.maxActive";
	
	public static final String DB_MAX_IDLE = "octopus.common.db.maxIdle";
	
	public static final String DB_MIN_IDLE = "octopus.common.db.minIdle";
	
	public static final String DB_MAX_WAIT = "octopus.common.db.maxWait";
	
	public static final String DB_REMOVE_ABANDONED = "octopus.common.db.removeAbandoned";
	
	public static final String DB_REMOVE_ABANDONED_TIMEOUT = "octopus.common.db.removeAbandonedTimeout";
	
	public static final String DB_TEST_ON_BORROW = "octopus.common.db.testOnBorrow";
	
	public static final String DB_TEST_ON_RETURN = "octopus.common.db.testOnReturn";
	
	public static final String DB_TEST_WHILE_IDLE = "octopus.common.db.testWhileIdle";
	
	public static final String DB_VALIDAION_QUERY = "octopus.common.db.validationQuery";
}
