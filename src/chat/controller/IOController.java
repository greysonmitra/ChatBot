package chat.controller;

import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import chat.view.*;


public class IOController 
{
	public static String saveFile(String textToSave)
	{
		String fileName = "Saved Chat File - ";
		fileName += Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		fileName += ":" + Calendar.getInstance().get(Calendar.MINUTE);
		fileName += ".txt";
		FileWriter chatWriter;
		
		try
		{
			chatWriter = new FileWriter(fileName);
			chatWriter.write("This is the " + fileName + "\n");
			chatWriter.write(textToSave);
			chatWriter.close();
			JOptionPane.showMessageDialog(null, "File saved as: " + fileName);
		}
		catch(IOException ioError)
		{
			JOptionPane.showMessageDialog(null, ioError.getMessage());
		}
		
		return fileName;
	}
	
	public void save(String textToSave)
	{		
		try 
		{
			String input = JOptionPane.showInputDialog("Enter file name: ");
		
				FileWriter fw = new FileWriter(input,true);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(textToSave);
				pw.close();
		}
		catch(IOException exception)
		{
			System.out.println("Fail");
		}
	}
	
	
	
	public static String readTextFromFile(String fileName)
	{
		String text = "";
		File chatTextFile = new File(fileName);
		Scanner chatScanner;
		try
		{
			chatScanner = new Scanner(chatTextFile);
			while(chatScanner.hasNext())
			{
				text += chatScanner.nextLine();
				
			}
			chatScanner.close();
			JOptionPane.showMessageDialog(null, fileName + " was loaded to the chatArea");
		}
		catch(IOException ioError)
		{
			JOptionPane.showMessageDialog(null, ioError.getMessage());
		}
		
		return text;
	}
}
