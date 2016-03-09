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

	// Constructor of main frame
	public HomeFrame()
	{		
		processor = new Processor();
		setTitle( "TODO List Application" );
		setSize( 1200, 500 );
		setBackground( Color.WHITE );
 
		mainPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainPanel.setDividerSize(3);
		getContentPane().add(mainPanel);
		JScrollPane scrollPanel = new JScrollPane();
		logPanel = new LogPanel();
		scrollPanel.setViewportView(logPanel);
		mainPanel.setLeftComponent(scrollPanel);
		
		
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
	
	
	private JPanel userInputBar(){
    	JPanel panel = new JPanel();
        userInputBox = new JTextField(30);
        panel.add(userInputBox);
        JButton enterButton = new JButton("Enter");
        panel.add(enterButton);
        
        enterButton.addActionListener(new ActionListener() {        	
			@Override
			public void actionPerformed(ActionEvent e) {
				String userCommand = userInputBox.getText();
				String commandType = processor.processCommand(userCommand); 
				taskList.upDateTaskList(processor);
				
				logPanel.recordToLog(userCommand);
				if (commandType == "update"){
					TaskforUpdateFunction UpdatedTask = processor.getUpdatedTask();
					logPanel.displayUpdatedTask(UpdatedTask);				
					
				}
			}			
    	});  
        
        return panel;
        
    }   	
	
	
	public void taskUpdatedWindow(TaskforUpdateFunction UpdatedTask){
		JFrame taskUpdatedWindow = new JFrame("Task Updated");
		
	}
}
