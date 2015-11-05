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
	
	public ChatView()
	{
		popupMessage = "Hello, this is your friend Gorillabot";
		chatbotIcon = new ImageIcon(getClass().getResource("Images/FRIKINWORK.jpg"));
	}
	
	
	public void showResponse(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText);
	}
	
	public String grabText(String displayText)
	{
		String returnedText = "";
		
		returnedText = JOptionPane.showInputDialog(null, displayText, popupMessage, JOptionPane.PLAIN_MESSAGE, chatbotIcon, null, "Answer here").toString(); ;
		
		return returnedText;
	}
	
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, popupMessage, JOptionPane.INFORMATION_MESSAGE, chatbotIcon);
	}
//	public void showResponse(String displayText)
//	{
//		JOptionPane.showMessageDialog(null, displayText);
//	}
}
