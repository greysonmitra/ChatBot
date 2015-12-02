package chat.view;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private JButton chatButton;
	private JTextField chatField;
	private SpringLayout baseLayout;
	private JLabel chatLabel;
	private JTextArea chatArea;
	
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10,20);
		chatButton = new JButton("Chat submit");
		chatField = new JTextField(20);
		chatLabel = new JLabel("CHAT TIME");
		
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
		this.setBackground(Color.RED);
		this.add(chatArea);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatLabel);
		chatField.setToolTipText("Type here to chat");
		chatArea.setEnabled(false);
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
		baseLayout.putConstraint(SpringLayout.NORTH, chatLabel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatLabel, 171, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -17, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 44, SpringLayout.WEST, this);
	
	}
	
	private void setupListeners()
	{
			chatButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					//Need to do this method
					//Grabe user answer
					//display answer
					//send text to Bot
					//chatbot process and dsiplay response
					
					String userText = chatField.getText(); //Grabe user answer
					chatArea.append("\nUser: " + userText); //display answer
					chatField.setText(""); 
					String response = baseController.userToChatbot(userText); //send text to Bot //chatbot process and display response
					chatArea.append("\nChatbot: " + response); //display the response
				}	
			});
			
		this.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent Enter)
			{
				
			}

			public void keyPressed(KeyEvent Enter)
			{
				String userText = chatField.getText();
				chatArea.append("\nUser: " + userText); 
				chatField.setText(""); 
				String response = baseController.userToChatbot(userText); 
				chatArea.append("\nChatbot: " + response); 
				
			}

			
			public void keyReleased(KeyEvent enter)
			{
				
				
			}
		});
	}
	
	public JTextField getTextField()
	{
		return chatField;
	}
}
