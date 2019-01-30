package base;

import com.sun.org.apache.bcel.internal.Const;

/* The purpose of this document is to be pointed and configured to test from 
 * one envrionment to the next by just changing a few parameters in the
 * the BaseConfig.class */
public class BaseConfig {
	 
	private String _environment;
	private String _user;
	private String _domain;
	private String _authentication;	
	private String _browser;
	
	public BaseConfig(String env, String user, String Domain, String Authentication, String Browser) {
		_environment = env;
		_user = user;
		_domain = Domain;
		_authentication = Authentication;	
		_browser = Browser;
	}
	
	/* Create a method which deserializes json into an object with various configurations
	 * for each environment */
	public void ConvertJsonConfiguration() {
		
	}
	
	
	
	
}
