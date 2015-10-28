package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 *Application controller for the Chatbot project. 
 * @author gmit3891
 *@version 1.11 10/21/15 fixed error
 */
public class ChatbotController
{
	private ChatView myDisplay;
	private Chatbot myChatbot;
	
	public ChatbotController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabText("What is your name?");
		myChatbot = new Chatbot(userName);
	}
	public void start()
	{
		myDisplay.grabText("Hello " + myChatbot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String conversation = myDisplay.grabText("What's on your mind, honey?");
		while(myChatbot.lengthChecker(conversation))
		{
			if(myChatbot.contentChecker(conversation))
			{
				myDisplay.grabText("wow, you're interesting in " + myChatbot.getContent() + "," + " that's cool.");
			}
//			if(!myChatbot.quitChecker(conversation))
//			{
//				conversation = myChatbot.processInput(conversation);
//			}
//			else
//			{
//				shutDown();
//			}
			
			conversation = myDisplay.grabText(conversation);
		}
	}
	
	private void shutDown()
	{
		
	}
}
