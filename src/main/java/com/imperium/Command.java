/**
 * 
 */
package com.imperium;

import java.util.Map;

public abstract class Command {

	private Map<String, String> config;
	
	public Context execute(Context inputContext) {
		return inputContext;
	}

	/**
	 * @return the config
	 */
	public Map<String, String> getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(Map<String, String> config) {
		this.config = config;
	}
	
}
