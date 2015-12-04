package chat.view;

import javax.swing.*;
import chat.controller.ChatbotController;

public class ChatFrame extends JFrame
{

	private ChatbotController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel); //Must be the first line of setupFrame (Actually installs the panel in frame)! So it initializes first.
		this.setSize(500,400); 			//Just find a reasonable size for the type of App.
		this.setTitle("Chatbot Gorilla");
		this.setResizable(false);       //Not required
		this.setVisible(true);		    //Must be last line of setupFrame! So that is sets up the frame then displays it duh.
	} 
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}
	
}
