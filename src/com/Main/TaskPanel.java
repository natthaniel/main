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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;

public class TaskPanel extends JPanel {

	Object titleBarStr[] = { "", "task", "location", "start", "end", "tag", "notification" };
	Object rowData[][] = {};
    private GridBagConstraints mainGBC;
	private GridBagConstraints tasksGBC;

    public TaskPanel() {
        setLayout(new BorderLayout());
    	JTable table = new JTable(rowData, titleBarStr);
    	JScrollPane scrollPane = new JScrollPane(table);
    	table.setShowGrid(false);
    	table.setOpaque(false);
    	table.setBackground(new Color(255, 255, 255, 1));
    	scrollPane.setOpaque(false);
    	scrollPane.getViewport().setOpaque(false);
    	
        add(scrollPane, BorderLayout.CENTER);
        //setBackground(Color.GRAY);
    }
    
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
}

