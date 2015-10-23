package chat.view;

import javax.swing.JOptionPane;

public class ChatView
{
	public String grabText(String displayText)
	{
//		JOptionPane.showInputDialog(null, displayText);
		
		String returnedText = JOptionPane.showInputDialog(null, displayText) ;
		
		return returnedText;
	}
}
