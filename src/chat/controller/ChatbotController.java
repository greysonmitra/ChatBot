package chat.controller;

import chat.view.*;
import chat.model.Chatbot;
import chat.model.CTECTwitter;


/**
 *Application controller for the Chatbot project. 
 * @author gmit3891
 *@version 1.5 11/5/15 Edited output to go to switch case to make conversation
 */
public class ChatbotController
{
	private CTECTwitter chatTwitter;
	private ChatView myDisplay;
	private Chatbot myChatbot;
	private ChatFrame baseFrame;
	
	
	/**
	 * Initializes different classes for running the code
	 */
	public ChatbotController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabText("What is your name?");
		myChatbot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
		chatTwitter = new CTECTwitter(this);
	}
	
	/**
	 * Starts code and presents output for the user
	 */
	public void start()
	{
		myDisplay.showResponse("Hello " + myChatbot.getUserName());
		chat();
//		setupFrame();
	}
	
	/**
	 * Starts while loop to check length and then ask for further input.
	 */
	private void chat()
	{
		String conversation = myDisplay.grabText("What's on ya mind, yo?");
		while(myChatbot.lengthChecker(conversation))
		{
			conversation = myChatbot.processConversation(conversation);
			conversation = myDisplay.grabText(conversation);
		}
		
	//	while(myChatbot.lengthChecker(conversation))
	//	{
	//		conversation = myDisplay.grabText(myChatbot.processConversation(conversation));
			
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
		
	
	public String userToChatbot(String userText)
	{
		String response = "";
		if(myChatbot.quitChecker(userText))
		{
			shutDown();
		}
		response = myChatbot.processConversation(userText);
			
		return response;
	}
	
	
	private void shutDown()
	{
		myDisplay.displayText("Goodbye " + myChatbot.getUserName() + ", it has been a pleasure to talk with you");
		System.exit(0);
	}
	
	public void sendTweet(String wordList)
	{
		chatTwitter.sendTweet(wordList);
		
	}
	
	public void handleErrors(String errorMessage)
	{
		myDisplay.displayText(errorMessage);
	}
	
	public Chatbot getChatbot()
	{
		return myChatbot;
	}
	
	public ChatView getChatView()
	{
		return myDisplay;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
}
