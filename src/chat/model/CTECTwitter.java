package chat.model;

import java.io.*;
import java.util.*;
import twitter4j.*;

import chat.controller.ChatbotController;

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
	
	public String topResults()
	{
		String tweetResults = " ";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for(int index = 0; index < wordList.size(); index++)
		{
			int wordUseCount = 1;
			
			for(int spot = index + 1; spot < wordList.size(); spot++)
			{
				if(wordList.get(index).equals(wordList.get(index)))
				{
					wordUseCount++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		
		tweetResults = "The top word in the tweet was " + wordList.get(topWordLocation) + " and it was used " + topCount + " times.";
		
		return tweetResults;
	}
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		
		while(page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for(Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split(" ");   //The split method says to make a new array element after each space. this guarantees that each separate word in a tweet acts as an element.
			for(String word : tweetText)
			{
				wordList.add(removePunctuation(word).toLowerCase());
			}
			removeCommonEnglishWords(wordList);
			removeEmptyText();
		}
	}
	
	private void removeEmptyText()								//Basically the method works to loop through our list to check if each element .equals something. It removes it if it does equal.
	{
		for(int spot = 0; spot < wordList.size(); spot++)
		{
			if (wordList.get(spot).equals(""))
			{
				wordList.remove(spot);			
				spot--;							//This line exists because, when removing, a list shifts up one, but the loop keeps going and skips one, so we must decrement so that we can get all the elements
			}
		}
	}
	
	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		try
		{
			Scanner wordFile = new Scanner(new File("commonWords.txt"));
			while(wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile.reset();
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while(wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
		}
		catch(FileNotFoundException e)
		{
			return new String[0];
		}
		return boringWords;
	}
	
	private List removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		
		for(int count = 0; count < wordList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
				
//		removeTwitterUsernamesFromList(wordList);
		
		return wordList;
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ",.'!?\";:{}[]()^<>-";
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1) //takes the char (the character) at the point i of the index of the string. This takes it when there is no punctuation and ...
			{
				scrubbedString += currentString.charAt(i);       //... this line puts it back together into scrubbed string.
			}
		}
		
		return scrubbedString;
	}
	
}
