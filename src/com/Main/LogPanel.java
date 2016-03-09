package com.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LogPanel extends JPanel{

	private GridBagConstraints tasksGBC;
    private GridBagConstraints mainGBC;
    private int counter = 0;
    private String MESSAGE_WELCOME = "Welcome to TODO List!!";
	
	public LogPanel(){
		setPreferredSize(new Dimension(600, 300));
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		tasksGBCInit(); 
		mainGBCInit();
	
		JPanel dummyPanel = new JPanel();
        dummyPanel.setBackground(new Color(0, 0, 0, 0));
        add(dummyPanel, mainGBC);
		 
		JLabel logItem = new JLabel("Welcome to TODO List!!");  
		logItem.setBorder(new EmptyBorder(1, 10, 1, 10));                               
		add(logItem, tasksGBC, 0);
		counter++;
        
	}
	
	public void recordToLog(String userCommand){
		JLabel logItem = new JLabel(userCommand); 
		logItem.setBorder(new EmptyBorder(1, 10, 1, 10));
		add(logItem, tasksGBC, counter++);
		validate();
		repaint();
	}
	
	public void displayUpdatedTask(TaskforUpdateFunction updatedTask){
		Task oldTask = updatedTask.getOldTask();
		Task newTask = updatedTask.getNewTask();

	    String taskUpdateLabel =  "Task:               "+ oldTask.getTaskName() +"     =>     " + newTask.getTaskName();
	    String locatUpdateLabel = "Location:        "+ oldTask.getLocation() +"     =>     " + newTask.getLocation();
	    String startUpdateLabel = "Start:              "+ oldTask.getStart() +"     =>     " + newTask.getStart();
	    String endUpdateLabel =   "End:                 "+ oldTask.getEnd() +"     =>     " + newTask.getEnd();
	    String tagUpdateLabel =   "Tag:                 "+ oldTask.getTag() +"     =>     " + newTask.getTag();
	    String notiUpdateLabel =  "Notification:   "+ oldTask.getNotification() +"     =>     " + newTask.getNotification();
		
	    recordToLog(taskUpdateLabel);
	    recordToLog(locatUpdateLabel);
	    recordToLog(startUpdateLabel);
	    recordToLog(endUpdateLabel);
	    recordToLog(tagUpdateLabel);
	    recordToLog(notiUpdateLabel);
	   
	}
	
	private void mainGBCInit(){
		mainGBC = new GridBagConstraints();
        mainGBC.anchor = GridBagConstraints.NORTH;
        mainGBC.gridwidth = GridBagConstraints.REMAINDER;
        mainGBC.weightx = 1;
        mainGBC.weighty = 1; 
    }

	private void tasksGBCInit(){
		tasksGBC = new GridBagConstraints();		
		tasksGBC.gridwidth = GridBagConstraints.REMAINDER;
		tasksGBC.weightx = 1;
		tasksGBC.fill = GridBagConstraints.HORIZONTAL;
	}
	
}
