/**
 * 
 */
package com.imperium;

public class ChainManager {

	public static Context executeChain(final String chainId, final Context inputContext) {
		ChainExecutor chainExecutor = new ChainExecutor(chainId);
		return chainExecutor.executeChain(inputContext);
	}
	
}
