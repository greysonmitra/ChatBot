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
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		
		while(page <= 10)
		{
			statusPage.setPage(page);
			statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for(Status currentStatus : statuses)
		{
			String[] tweetText = currentStatus.getText().split(" ");   //The split method says to make a new array element after each space. this guarantees that each separate word in a tweet acts as an element.
			for(String word : tweetText)
			{
				tweetText.add(removePunctuation(word).toLowerCase());
			}
			removeCommonEnglishWords(tweetTexts);
			removeEmptyText();
		}
	}
	
	private void removeEmptyText()
	{
		
	}
	
	private List removeCommonEnglishWords(List<String> wordList)
	{
		return null;
	}
	
	private String removePunctuation(String currentString)
	{
		return null;
	}
	
}
