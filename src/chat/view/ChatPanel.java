package chat.view;

import java.awt.Color;
import javax.swing.*;
import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private JButton chatButton;
	private JTextField chatField;
	private SpringLayout baseLayout;
	private JLabel chatTextField;
	
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("Chat button");
		chatField = new JTextField("words can be typed here");
		chatTextField = new JLabel("CHATBOOTY");
	
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 *Helper method to load all GUI components into Panel 
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatTextField);
	}
	
	/**
	 * Helper method for arranging the panel.
	 * Dumping ground for WindowBuilder generated code.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -40, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 42, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -22, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 178, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -155, SpringLayout.NORTH, chatField);
	}
	
	private void setupListeners()
	{
		
	}
}
