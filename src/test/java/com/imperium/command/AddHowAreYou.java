/**
 * 
 */
package com.imperium.command;

import com.imperium.Command;
import com.imperium.Context;
import com.imperium.context.HelloWorldContext;

public class AddHowAreYou extends Command {

	public Context execute(Context inputContext) {
		HelloWorldContext context = (HelloWorldContext) inputContext;
		context.setGreeting(context.getGreeting() + " How are you?");
		return context;
	}

}
