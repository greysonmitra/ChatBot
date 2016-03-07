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
	
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		
	}
	
}
