package chat.controller;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import chat.view.*;


public class IOController 
{
	public void pwChatAreaText()
	{		
		try 
		{
			String input = JOptionPane.showInputDialog("Enter file name: ");
		
				FileWriter fw = new FileWriter(input,true);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(getChatAreaText());
				pw.close();
		}
		catch(IOException exception)
		{
			System.out.println("Fail");
		}
	}
}
