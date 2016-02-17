package com.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
	
	public LogPanel(){
		setSize(new Dimension(500, 400));
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		tasksGBCInit(); 
		mainGBCInit();
	
		JPanel dummyPanel = new JPanel();
        dummyPanel.setBackground(new Color(0, 0, 0, 0));
        add(dummyPanel, mainGBC);
        
        
	}
	
	public void recordToLog(String userCommand){
		JLabel logItem = new JLabel(userCommand);                                 
		add(logItem, tasksGBC, 0);
		validate();
		repaint();
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
