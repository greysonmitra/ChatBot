package chat.model;

import java.util.ArrayList;

import twitter4j.*;

/**
 * 
 * @author gmit3891
 * @version 0.3 Constructs our ArrayLists now.
 * Writing code for interaction between our Chatbot and Twitter. 
 */
public class CTECTwitter
{
	//Declarations
	
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;

	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		
	}
	
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException exception)
		{
			
		}
	}
}
