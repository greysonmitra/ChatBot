package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 *Application controller for the Chatbot project. 
 * @author gmit3891
 *@version 1.5 11/5/15 Edited output to go to switch case to make conversation
 */
public class ChatbotController
{
	private ChatView myDisplay;
	private Chatbot myChatbot;
	
	/**
	 * Initializes different classes for running the code
	 */
	public ChatbotController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabText("What is your name?");
		myChatbot = new Chatbot(userName);
	}
	
	/**
	 * Starts code and presents output for the user
	 */
	public void start()
	{
		myDisplay.showResponse("Hello " + myChatbot.getUserName());
		chat();
	}
	
	/**
	 * Starts while loop to check length and then ask for further input.
	 */
	private void chat()
	{
		String conversation = myDisplay.grabText("What's on ya mind, yo?");
		while(myChatbot.lengthChecker(conversation))
		{
			conversation = myDisplay.grabText(myChatbot.processConversation(conversation));
			
//			if(myChatbot.contentChecker(conversation))
//			{
//				myDisplay.showResponse("wow, you're interested in " + myChatbot.getContent());
//			}
//			else if(myChatbot.memeChecker(conversation))
//			{
//				myDisplay.showResponse("NOICE meme bro :)");
//			}
///			else if(myChatbot.politicalTopicChecker(conversation))
///			{
///				myDisplay.showResponse("Talking politics...");
///			}
			
			
			
//			else(!myChatbot.quitChecker(conversation))
//			{
//				conversation = myChatbot.processInput(conversation);
//			}
//			else
//			{
//				shutDown();
//			}
	
			
//			conversation = myDisplay.grabText(conversation);
		}
	}
	
	private void shutDown()
	{
//		myDisplay.displayText("Goodbye," + myChatbot.getUserName());
	}
}
