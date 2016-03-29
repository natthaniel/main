package com.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class HomeFrame extends JFrame{
	
	// Instance attributes used in this example
	//private	JPanel mainPanel;

	private	LogPanel logPanel;
	private TaskPanel taskList;
	private JTextField userInputBox;
	private JSplitPane mainPanel;
	private Processor processor;
	private JButton enterButton;
	
	private static final String MESSAGE_INVALID_COMMAND = "Invalid command.";
	private static final String MESSAGE_COMMAND = "Command: ";
	private static final String HTML_HEAD = "<HTML>";
	private static final String HTML_TAIL = "</HTML>";

	// Constructor of main frame
	public HomeFrame()
	{		
		processor = new Processor();
		setTitle( "TODO List Application" );
		setSize( 1200, 500 );
		setBackground( Color.WHITE );
 
		mainPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainPanel.setDividerSize(2);
		getContentPane().add(mainPanel);
		logPanel = new LogPanel();
		

		//scrollPaneForLog = new JScrollPane(logPanel);
		//scrollPanel.setViewportView(logPanel);
		mainPanel.setLeftComponent(logPanel);
		
        JPanel panel = userInputBar();
        add(panel, BorderLayout.SOUTH);
                
			
	}
	

	public void taskListInitialize(){		
		taskList = new TaskPanel();
		taskList.upDateTaskList(processor);
		mainPanel.setRightComponent(taskList );		
	}
	
	
	public static void main(String[] args){
		HomeFrame home = new HomeFrame();
		
		home.taskListInitialize();
		home.setVisible(true);
	}
	
	// The Input bar initialization 
	private JPanel userInputBar(){
    	JPanel panel = new JPanel();
        userInputBox = new JTextField(30);
        panel.add(userInputBox);
        enterButton = new JButton("Enter");
        panel.add(enterButton);
        
        getRootPane().setDefaultButton(enterButton);
        
        enterButton.addActionListener(new ActionListener() {        	
			@Override
			public void actionPerformed(ActionEvent e) {
				String userCommand = userInputBox.getText();
				if (!userCommand.equals("")) {
					List<String> strToDisplay = processor.executeCommand(userCommand);
					//String commandType = processor.processCommand(userCommand); 
					taskList.upDateTaskList(processor);
					
					logPanel.clearLog();
					logPanel.recordToLog(HTML_HEAD+setStringInRed(MESSAGE_COMMAND) + userCommand+HTML_TAIL);
					for (int i=0; i<strToDisplay.size(); i++) {
						
						logPanel.recordToLog(HTML_HEAD+strToDisplay.get(i)+HTML_TAIL);
					}
					/*if (commandType == "update" || commandType == "delete" ||commandType == "add") {

						if (commandType == "update"){
							TaskforUpdateFunction UpdatedTask = processor.getUpdatedTask();
							logPanel.displayUpdatedTask(UpdatedTask);				
							
						}
					} else {
						logPanel.recordToLog(MESSAGE_INVALID_COMMAND);
					}*/
					userInputBox.setText("");
				}
			}			
    	});  
        
        return panel;
        
    }   	
	
	public String setStringInGreen(String outputStr){
		outputStr = "<font color=\"green\">" + outputStr + "</font>";
		return outputStr;
	}
	
	public String setStringInRed(String outputStr){
		outputStr = "<font color=\"red\">" + outputStr + "</font>";
		return outputStr;
	}
	
	public String setStringInBlue(String outputStr){
		outputStr = "<font color=\"blue\">" + outputStr + "</font>";
		return outputStr;
	}
	
	public String setStringWithRGB(String outputStr, String r, String g, String b){
		outputStr = "<font color=\"rgb("+r+", "+g+", "+b+")\">" + outputStr + "</font>";
		return outputStr;
	}
	
	
}
