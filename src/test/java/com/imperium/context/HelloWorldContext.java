/**
 * 
 */
package com.imperium.context;

import com.imperium.Context;

public class HelloWorldContext implements Context {

	private String greeting;
	
	public String getGreeting() {
		return this.greeting;
	}
	
	public void setGreeting(final String newGreeting) {
		this.greeting = newGreeting;
	}
	
}
