package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part. NOT ANY MORE
 * of the project.
 * @author Greyson Mitra
 * @version 1.5 11/5/15 Completed multiple methods for checking various topics/
 */

public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicsList;
	private String userName;
	private String content;
	
	public Chatbot()
	{
		memesList = new ArrayList<String>();
		politicalTopicsList = new ArrayList<String>();
		userName = new String();
		content = new String();
	}
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicsList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Music";
		
		buildMemesList();
		buildPoliticalTopicsList();
	}

/**
 * Initializes the Meme ArrayList with our meme objects.
 */
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("Me gusta/Y U NO");
		this.memesList.add("spodermen");
		this.memesList.add("Rare Pepe"); //wOOOOOOOOOOOOOOOOOOOOO
		this.memesList.add("What if I told you...");
		this.memesList.add("Aliens");
		memesList.add("Unhelpful High School Teacher"); // can do it this way if ya want
		this.memesList.add("Trollface");
		
	}
	
/**
 * Initializes our Political topic ArrayList with our political topic objects	
 */
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicsList.add("election");
		this.politicalTopicsList.add("Sanders");
		this.politicalTopicsList.add("Trump");
		this.politicalTopicsList.add("Fiorina");
		this.politicalTopicsList.add("Carson");
		this.politicalTopicsList.add("Clinton");
		this.politicalTopicsList.add("Christie");
		this.politicalTopicsList.add("Bush");
		this.politicalTopicsList.add("Liberal");
		this.politicalTopicsList.add("Conservative");
		this.politicalTopicsList.add("Republican");
		this.politicalTopicsList.add("Democrat");
		this.politicalTopicsList.add("vote");
		this.politicalTopicsList.add("primary");
		this.politicalTopicsList.add("President");
		
		
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null)
		{
			if(currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}
		
		// or you could do this: 
//		  if(current != null && currentInputlength() > 0)
//		  {
//		  	  hasLength = true
//		  }
		
		return hasLength;
		
	}
	
	/**
	 * Checks if the supplied String matches the content area music or anything related.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		
			if(currentInput.toLowerCase().contains(content.toLowerCase()))
			{
				hasContent = true;
			}
				
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitics = false;
		
		for(String politics: politicalTopicsList)
		{
			if(currentInput.toLowerCase().contains(politics.toLowerCase()))
			{
				hasPolitics = true;
			}
		}
		return hasPolitics;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable. Specifically if it the name of one of our memes.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String meme:memesList)
		{
			if (currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMeme = true;
			}
		}
		
//		if(currentInput.contains(memesList))
//		{
//			hasMeme = true;
//		}
		
		return hasMeme;
	}
	
	/**
	 * Generates a random number, checks it with a switch/case block of code and then gives output based on that and the type of input supplied.
	 * @param currentInput Takes in the current input given by the user
	 * @return
	 */
	public String processConversation(String currentInput)
	{
		String nextTopic = "Well what else do ya want to chat about mayn?";
		int randomTopic = (int) (Math.random() * 5); //Generates a random number between 0 and 4.
		
		switch (randomTopic)
		{
		case 0:
			if(memeChecker(currentInput))
			{
				nextTopic = "Quite the interesting meme sir. What else would you like to chat about?";
			}
			break;
		case 1:
			if(politicalTopicChecker(currentInput))
			{
				nextTopic = "Quite the widely debated political topic you have there. Would you like to continue talking about politics?";
			}
			break;
		case 2:
			if(contentChecker(currentInput))
			{
				nextTopic = "Cool. What other musical things do you want to talk about?";
			}
			else
			{
				nextTopic = "failed content check for content";
			}
			break;
		case 3:
//			if(currentInput.length() > 40)
//			{
//				nextTopic = "You don't talk much. I stopped listening. Would you like to talk about something else?";
//			}
			break;
		case 4:
			nextTopic = "What do you know about the Russia?!?!";
			break;
		default:
			break;
		}
		
		return nextTopic;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
}
