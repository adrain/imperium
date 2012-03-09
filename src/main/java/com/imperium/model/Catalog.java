/**
 * 
 */
package com.imperium.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="catalog")
@XmlAccessorType(value=XmlAccessType.FIELD)
@XmlType
public class Catalog {
	@XmlElement(name="chain")
	private List<Chain> chainList;

	/**
	 * @return the chainList
	 */
	public List<Chain> getChainList() {
		return chainList;
	}

	/**
	 * @param chainList the chainList to set
	 */
	public void setChainList(List<Chain> chainList) {
		this.chainList = chainList;
	}
	
}
