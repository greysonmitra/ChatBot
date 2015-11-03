package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Greyson Mitra
 * @version 1.2 10/23/15 Completed the lengthChecker method. Fixed the Constructor and getter for userName. 
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
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("Me gusta/Y U NO");
		this.memesList.add("spodermen");
		this.memesList.add("Rare Pepe"); //wOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		this.memesList.add("What if I told you...");
		this.memesList.add("Aliens");
		memesList.add("Unhelpful High School Teacher"); // can do it this way if ya want
		this.memesList.add("Trollface");
		
	}
	
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
	 * Checks if the supplied String matches the content area for this Chatbot instance.
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
	 * Checks to see that the supplied String value is in the current memesList variable.
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
				nextTopic = "failed content check";
			}
			break;
		case 3:
//			if(currentInput.length() > 40)
//			{
//				nextTopic = "You don't talk much. I stopped listening. Would you like to talk about something else?";
//			}
			break;
		case 4:
			nextTopic = "What do you know about the Bible?!?!";
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
