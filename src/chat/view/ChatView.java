package chat.view;

import javax.swing.JOptionPane;

public class ChatView
{
	public void showResponse(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText);
	}
	
	public String grabText(String displayText)
	{
		String returnedText = "";
		
		returnedText = JOptionPane.showInputDialog(null, displayText) ;
		
		return returnedText;
	}
	
//	public void showResponse(String displayText)
//	{
//		JOptionPane.showMessageDialog(null, displayText);
//	}
}
