package chat.model;

import java.util.ArrayList;
import chat.controller.*;
import twitter4j.*;

/**
 * 
 * @author gmit3891
 * @version 0.4 Feb 25, 2016 Can interact with the controller to send tweets and prevent errors. Listeners for sending tweets too.
 * Writing code for interaction between our Chatbot and Twitter. 
 */
public class CTECTwitter
{
	//Declarations
	
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ChatbotController baseController;

	
	public CTECTwitter(ChatbotController baseController)
	{
		this.baseController = baseController;
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		chatbotTwitter = TwitterFactory.getSingleton();
		
	}
	
	
	/**
	 * Send the given message as a tweet.
	 * @param tweet The String that is given.
	 */
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("Yo it is Greyson Mitra just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
	
	
	
}
