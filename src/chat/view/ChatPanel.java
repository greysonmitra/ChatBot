package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		chatButton = new JButton("Chat button");
		chatField = new JTextField("words can be typed here");
		chatLabel = new JLabel("CHATBOOTY");
	
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
		baseLayout.putConstraint(SpringLayout.WEST, chatLabel, 178, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatLabel, -155, SpringLayout.NORTH, chatField);
	}
	
	private void setupListeners()
	{
		{
			chatButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					chatField.setText("Wow, you managed a click event! Wow!!!!!!!!");
				}
			});
		}
	}
	
	public JTextField getTextField()
	{
		return chatField;
	}
}
