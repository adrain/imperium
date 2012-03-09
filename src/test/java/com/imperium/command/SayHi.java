/**
 * 
 */
package com.imperium.command;

import com.imperium.Command;
import com.imperium.Context;
import com.imperium.context.HelloWorldContext;

public class SayHi extends Command {

	public Context execute(Context inputContext) {
		HelloWorldContext context = (HelloWorldContext)inputContext;
		context.setGreeting("Hello " + getConfig().get("name") + "!");
		return context;
	}

}
