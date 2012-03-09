/**
 * 
 */
package com.imperium;

import java.util.Iterator;

import com.imperium.config.ChainConfigurationLoader;
import com.imperium.model.Chain;
import com.imperium.model.CommandNode;

public class ChainExecutor {
	
	private Chain chain;
	
	public ChainExecutor(final String chainId) {
		this.chain = ChainConfigurationLoader.getChain(chainId);
	}

	@SuppressWarnings("unchecked")
	public Context executeChain(Context inputContext) {
		if(null == chain) throw new IllegalArgumentException("Chain configuration is not defined");
		
		//Get the command nodes
		Iterator<CommandNode> nodeIter = chain.getNodes().iterator();
		while(nodeIter.hasNext()) {
			CommandNode currNode = nodeIter.next();
			String commandClassName = currNode.getCommandClassName();
			
			if(null == commandClassName) {
				throw new IllegalArgumentException("Command class name cannot be null");
			}
			
			try {
				Class<Command> commandClass = (Class<Command>) Class.forName(commandClassName);
				Command command = commandClass.newInstance();
				command.setConfig(currNode.getConfig());
				command.execute(inputContext);
				
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("Unable to instatiate command class:"+commandClassName);
			} catch (InstantiationException e) {
				throw new IllegalArgumentException("Unable to instatiate command class:"+commandClassName);
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException("Unable to instatiate command class:"+commandClassName);
			}
		}
		
		
		return inputContext;
	}
	
}
