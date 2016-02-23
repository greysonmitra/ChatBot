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
	private JLabel promptLabel;
	private JScrollPane textPane;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;

	/**
	 * Initializes helper methods, panel elements, and a controller class to create a good GUI.
	 * @param baseController
	 */
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10,20);
		chatButton = new JButton("Chat submit");
		chatField = new JTextField(20);
		chatLabel = new JLabel("CHAT TIME");
		promptLabel = new JLabel("prompt");
		tweetButton = new JButton("Tweet this");
		saveButton = new JButton("save this");
		loadButton = new JButton("load something");
		textPane = new JScrollPane();            //Scroll pane helps initialize our chatarea/textarea and so you don't need to do the whole this.add and positioning stuff for chatarea/textarea.
		
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatPane()
	{
		textPane = new JScrollPane(chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, textPane);
		
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	/**
	 *Helper method to load all GUI components into Panel 
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.RED);
		this.add(textPane);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatLabel);
		this.add(promptLabel);
		this.add(tweetButton);
		this.add(saveButton);
		this.add(loadButton);
		chatField.setToolTipText("Type here to chat");
		chatArea.setEnabled(false);
	}
	
	/**
	 * Helper method for arranging the panel.
	 * Dumping ground for WindowBuilder generated code.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatLabel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -17, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 44, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -20, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 1, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 25, SpringLayout.EAST, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 16, SpringLayout.EAST, tweetButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -41, SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, promptLabel, 16, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, promptLabel, -201, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatLabel, 0, SpringLayout.EAST, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 29, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
	}
	
	/**
	 * Helper method to take in input in the form of actions from the user and initiate events based on that.
	 */
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
			
		chatField.addKeyListener(new KeyListener()      //Needs to be chatField CUZ THATS WHERE YOU TYPE NOT THE PANEL IN GENERAL AOR THE BUTTON
		{
			public void keyTyped(KeyEvent Enter)
			{
				
			}

			public void keyPressed(KeyEvent Enter)
			{
				
				if(Enter.VK_ENTER == Enter.getKeyCode())
				{
					String userText = chatField.getText();
					chatArea.append("\nUser: " + userText); 									
					chatField.setText(""); 
					String response = baseController.userToChatbot(userText); 
					chatArea.append("\nChatbot: " + response);
				}
				
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
