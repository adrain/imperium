/**
 * 
 */
package com.imperium;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imperium.config.ChainConfigurationLoader;
import com.imperium.context.HelloWorldContext;

public class Test {
	
	public static Logger logger = LoggerFactory.getLogger(Test.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> chainsPath = new ArrayList<String>();
		chainsPath.add(Test.class.getClassLoader().getResource("chains.xml").getPath());
		ChainConfigurationLoader loader = ChainConfigurationLoader.createInstance(chainsPath);
		HelloWorldContext retContext = (HelloWorldContext) ChainManager.executeChain("sayHelloWorld", new HelloWorldContext());
		logger.info(retContext.getGreeting());
	}

}
