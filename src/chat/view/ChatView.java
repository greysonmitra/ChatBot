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
//		JOptionPane.showInputDialog(null, displayText);
		
		String returnedText = JOptionPane.showInputDialog(null, displayText) ;
		
		return returnedText;
	}
	
//	public void showResponse(String displayText)
//	{
//		JOptionPane.showMessageDialog(null, displayText);
//	}
}
