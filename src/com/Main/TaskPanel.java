package com.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;

public class TaskPanel extends JPanel {

	
    private JPanel taskList;
    private GridBagConstraints mainGBC;
	private GridBagConstraints tasksGBC;

    public TaskPanel() {
        setLayout(new BorderLayout());
		setSize(new Dimension(500, 400));
		mainGBC = mainGBCInit();
		tasksGBC = tasksGBCInit(); 
        
        taskList = new JPanel(new GridBagLayout()) {
        	@Override
            protected void paintComponent(Graphics g) {
            	super.paintComponent(g);
        		try {
        	        g.drawImage(ImageIO.read(this.getClass().getResource("background.png")), 0, 0, null);
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            }
        };
        
        taskList.setSize(100, 200);
        
        JPanel dummyPanel = new JPanel();
        dummyPanel.setBackground(new Color(0, 0, 0, 0));
        taskList.add(dummyPanel, mainGBC);
        add(new JScrollPane(taskList));
        
    }
    
    @Override
    public void add(Component comp, Object constraints, int index){
    	taskList.add(comp, constraints, index);
    }
    
    private GridBagConstraints mainGBCInit(){
    	GridBagConstraints mainGBC = new GridBagConstraints();
        mainGBC.anchor = GridBagConstraints.NORTH;
        mainGBC.gridwidth = GridBagConstraints.REMAINDER;
        mainGBC.weightx = 1;
        mainGBC.weighty = 1; 
        return mainGBC;
    }
    

	private GridBagConstraints tasksGBCInit(){
		GridBagConstraints tasksGBC = new GridBagConstraints();		
		tasksGBC.gridwidth = GridBagConstraints.REMAINDER;
		tasksGBC.weightx = 1;
		tasksGBC.fill = GridBagConstraints.HORIZONTAL;
		return tasksGBC;
	}
    
    /**
     * addTask on the list
     *
     * @param task    The task object.
     * @param userInputBox   The user input box.
     */
    public void addTask(Task task){
    	
    	if (!task.equals("")) {
	    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT)){
	    		protected void paintComponent(Graphics g)
	    	    {
	    	        g.setColor( getBackground() );
	    	        g.fillRect(0, 0, getWidth(), getHeight());
	    	        super.paintComponent(g);
	    	    }
	    	};
	    	panel.setOpaque(false);
	    	panel.setBackground( new Color(255, 0, 0, 20) );
    		JCheckBox checkBox = taskCheckBoxSetting(task.getTask());                                 
    		panel.add(checkBox);
    		
    		Border border = new LineBorder(Color.GRAY, 1, true);
    		Border margin = new EmptyBorder(10,10,10,10);
    		panel.setBorder(new CompoundBorder(margin, border));
    		
    		taskList.add(panel, tasksGBC, 0);   
    		validate();
    		repaint();
        
    	}   
    }
    
    private JCheckBox taskCheckBoxSetting(String textForCheckBox){
    	JCheckBox checkBox = new JCheckBox(textForCheckBox);
		checkBox.setOpaque(false);
		checkBox.setBackground( new Color(255, 255, 255, 20) );
		checkBox.setForeground(Color.WHITE);
		
		return checkBox;
    }
    


       
  
}
