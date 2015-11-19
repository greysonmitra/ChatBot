package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * A display that uses popups to take user input for the Chatbot project.
 * @author gmit3891
 *1.3 11/5/15 Added Icons to popup windows!
 */
public class ChatView
{

	private String popupMessage;
	private ImageIcon chatbotIcon;

	/**
	 * Adds an icon image and startup message for the popup window
	 */
	public ChatView()
	{
		popupMessage = "Hello, this is your friend Gorillabot";
		chatbotIcon = new ImageIcon(getClass().getResource("Images/FRIKINWORK.jpg"));
	}
	
	/**
	 * Displays text on any JOptionPane popup. displaytext initialized everywhere	
	 * @param displayText
	 */
	public void showResponse(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText);
	}
	
	/**
	 * Sets display text as null and can be changed.
	 * @param displayText
	 * @return
	 */
	public String grabText(String displayText)
	{
		String returnedText = "";
		
		returnedText = JOptionPane.showInputDialog(null, displayText, popupMessage, JOptionPane.PLAIN_MESSAGE, chatbotIcon, null, "Answer here").toString(); ;
		
		return returnedText;
	}
	
	/**
	 * Displays information as a popup. Takes user input.
	 * @param displayText
	 */
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, popupMessage, JOptionPane.INFORMATION_MESSAGE, chatbotIcon);
	}
//	public void showResponse(String displayText)
//	{
//		JOptionPane.showMessageDialog(null, displayText);
//	}
}
