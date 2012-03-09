/**
 * 
 */
package com.imperium.model;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value=XmlAccessType.FIELD)
@XmlType
public class CommandNode {

	private String id;
	private String commandClassName;
	private Map<String, String> config;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the commandClassName
	 */
	public String getCommandClassName() {
		return commandClassName;
	}
	/**
	 * @param commandClassName the commandClassName to set
	 */
	public void setCommandClassName(String commandClassName) {
		this.commandClassName = commandClassName;
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
