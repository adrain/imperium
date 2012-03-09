/**
 * 
 */
package com.imperium.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imperium.model.Catalog;
import com.imperium.model.Chain;
import com.imperium.model.CommandNode;

public class ChainConfigurationLoader {
	
	public static final Logger logger = LoggerFactory.getLogger(ChainConfigurationLoader.class);
	
	private static ChainConfigurationLoader instance;
	
	private Map<String, Chain> chainMap;

	public ChainConfigurationLoader(List<String> chainsPath) {
		chainMap = new HashMap<String, Chain>();
		
		try {
			JAXBContext context = JAXBContext.newInstance(Catalog.class, Chain.class, CommandNode.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			Iterator<String> pathIterator = chainsPath.iterator();
			while(pathIterator.hasNext()) {
				String filePath = pathIterator.next();
				
				Catalog chains = (Catalog) unmarshaller.unmarshal(new FileInputStream(filePath));
				
				Iterator<Chain> chainIterator = chains.getChainList().iterator();
				while(chainIterator.hasNext()) {
					Chain currChain = chainIterator.next();
					chainMap.put(currChain.getId(), currChain);
				}
			}
			
			logger.info("Successfully loaded "+ chainMap.size() +" Chain configurations");
		}
		catch (FileNotFoundException e) {
			logger.error("Chain Configuration file not found:"+e.getLocalizedMessage());
		}
		catch (JAXBException e) {
			logger.error("Chain Configuration file is incorrect format:"+e.getLocalizedMessage());
		}
	}
	
	public static ChainConfigurationLoader createInstance(List<String> chainsPath) {
		instance = new ChainConfigurationLoader(chainsPath);
		return getInstance();
	}
	
	public static ChainConfigurationLoader getInstance() {
		return instance;
	}
	
	public static Chain getChain(final String chainId) {
		return instance.chainMap.get(chainId);
	}
	
}
