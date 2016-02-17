[33mcommit c1b859a1c1e1dd3977a0c8d060945424ff95c2b1[m
Author: ykn121 <ykn121@gmail.com>
Date:   Wed Feb 17 12:11:00 2016 +0800

    first commit

[1mdiff --git a/src/com/Main/HomeFrame.java b/src/com/Main/HomeFrame.java[m
[1mnew file mode 100644[m
[1mindex 0000000..281a63f[m
[1m--- /dev/null[m
[1m+++ b/src/com/Main/HomeFrame.java[m
[36m@@ -0,0 +1,110 @@[m
[32m+[m[32mpackage com.Main;[m
[32m+[m
[32m+[m[32mimport java.awt.BorderLayout;[m
[32m+[m[32mimport java.awt.Color;[m
[32m+[m[32mimport java.awt.Dimension;[m
[32m+[m[32mimport java.awt.FlowLayout;[m
[32m+[m[32mimport java.awt.Graphics;[m
[32m+[m[32mimport java.awt.GridBagConstraints;[m
[32m+[m[32mimport java.awt.GridBagLayout;[m
[32m+[m[32mimport java.awt.GridLayout;[m
[32m+[m[32mimport java.awt.event.ActionEvent;[m
[32m+[m[32mimport java.awt.event.ActionListener;[m
[32m+[m
[32m+[m[32mimport javax.swing.JButton;[m
[32m+[m[32mimport javax.swing.JCheckBox;[m
[32m+[m[32mimport javax.swing.JFrame;[m
[32m+[m[32mimport javax.swing.JList;[m
[32m+[m[32mimport javax.swing.JPanel;[m
[32m+[m[32mimport javax.swing.JScrollPane;[m
[32m+[m[32mimport javax.swing.JTextField;[m
[32m+[m[32mimport javax.swing.border.Border;[m
[32m+[m[32mimport javax.swing.border.CompoundBorder;[m
[32m+[m[32mimport javax.swing.border.EmptyBorder;[m
[32m+[m[32mimport javax.swing.border.LineBorder;[m
[32m+[m
[32m+[m[32mpublic class HomeFrame extends JFrame{[m
[32m+[m[41m	[m
[32m+[m	[32m// Instance attributes used in this example[m
[32m+[m	[32mprivate	JPanel mainPanel;[m
[32m+[m	[32mprivate	LogPanel logPanel;[m
[32m+[m	[32mprivate TaskPanel taskList;[m
[32m+[m
[32m+[m	[32m// Constructor of main frame[m
[32m+[m	[32mpublic HomeFrame()[m
[32m+[m	[32m{[m[41m		[m
[32m+[m		[32msetTitle( "TODO List Application" );[m
[32m+[m		[32msetSize( 1000, 500 );[m
[32m+[m		[32msetBackground( Color.WHITE );[m
[32m+[m
[32m+[m		[32mmainPanel = new JPanel();[m
[32m+[m		[32mmainPanel.setLayout(new GridLayout(1, 2));[m
[32m+[m		[32mgetContentPane().add(mainPanel);[m
[32m+[m
[32m+[m		[32mJScrollPane scrollPanel = new JScrollPane();[m
[32m+[m		[32mlogPanel = new LogPanel();[m
[32m+[m		[32mscrollPanel.setViewportView(logPanel);[m
[32m+[m		[32m//mainPanel.add( scrollPanel, BorderLayout.WEST );[m
[32m+[m		[32mmainPanel.add(scrollPanel);[m
[32m+[m[41m		[m
[32m+[m
[32m+[m[32m        JPanel panel = userInputBar();[m
[32m+[m[32m        add(panel, BorderLayout.SOUTH);[m
[32m+[m[41m                [m
[32m+[m[41m			[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m
[32m+[m	[32mpublic void taskListInitialize(){[m[41m		[m
[32m+[m		[32mtaskList = new TaskPanel();[m
[32m+[m		[32mmainPanel.add( taskList );[m[41m		[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m[41m	[m
[32m+[m	[32mpublic static void main(String[] args){[m
[32m+[m		[32mHomeFrame home = new HomeFrame();[m
[32m+[m[41m		[m
[32m+[m		[32mhome.taskListInitialize();[m
[32m+[m		[32mhome.setVisible(true);[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m[41m	[m
[32m+[m	[32mprivate JPanel userInputBar(){[m
[32m+[m[41m    [m	[32mJPanel panel = new JPanel();[m
[32m+[m[32m        JTextField userInputBox = new JTextField(30);[m
[32m+[m[32m        panel.add(userInputBox);[m
[32m+[m[32m        JButton enterButton = new JButton("Enter");[m
[32m+[m[32m        panel.add(enterButton);[m
[32m+[m[41m        [m
[32m+[m[32m        enterButton.addActionListener(new ActionListener() {[m[41m        	[m
[32m+[m			[32m@Override[m
[32m+[m			[32mpublic void actionPerformed(ActionEvent e) {[m
[32m+[m				[32mString userCommand = userInputBox.getText();[m
[32m+[m				[32mString command = commandParser(userCommand);[m[41m  [m
[32m+[m[41m				[m
[32m+[m				[32mswitch (command.toLowerCase()){[m
[32m+[m					[32mcase "add":[m
[32m+[m						[32mTask task = new Task(userCommand);[m
[32m+[m						[32mtaskList.addTask(task);[m
[32m+[m						[32mlogPanel.recordToLog(userCommand);[m
[32m+[m			[41m    [m		[32muserInputBox.setText("");[m
[32m+[m						[32mbreak;[m
[32m+[m					[32mdefault:[m
[32m+[m[41m						[m
[32m+[m				[32m}[m
[32m+[m			[32m}[m[41m			[m
[32m+[m[41m    [m	[32m});[m[41m  [m
[32m+[m[41m        [m
[32m+[m[32m        return panel;[m
[32m+[m[41m        [m
[32m+[m[32m    }[m
[32m+[m[41m    [m
[32m+[m[32m    private String commandParser(String userCommand){[m[41m    	[m
[32m+[m[41m    [m	[32mString command = userCommand.substring(0, userCommand.indexOf(" "));[m[41m    	[m
[32m+[m[41m    [m	[32mreturn command;[m
[32m+[m[32m    }[m
[32m+[m[41m    [m
[32m+[m[41m    [m
[32m+[m[41m	[m
[32m+[m[41m	[m
[32m+[m[32m}[m
[1mdiff --git a/src/com/Main/InputBox.java b/src/com/Main/InputBox.java[m
[1mnew file mode 100644[m
[1mindex 0000000..a1c8634[m
[1m--- /dev/null[m
[1m+++ b/src/com/Main/InputBox.java[m
[36m@@ -0,0 +1,102 @@[m
[32m+[m[32mpackage com.Main;[m
[32m+[m
[32m+[m[32mimport java.awt.BorderLayout;[m
[32m+[m[32mimport java.awt.Color;[m
[32m+[m[32mimport java.awt.Dialog;[m
[32m+[m[32mimport java.awt.Dimension;[m
[32m+[m[32mimport java.awt.GridBagConstraints;[m
[32m+[m[32mimport java.awt.GridBagLayout;[m
[32m+[m
[32m+[m[32mimport javax.swing.JButton;[m
[32m+[m[32mimport javax.swing.JCheckBox;[m
[32m+[m[32mimport javax.swing.JDialog;[m
[32m+[m[32mimport javax.swing.JFrame;[m
[32m+[m[32mimport javax.swing.JLabel;[m
[32m+[m[32mimport javax.swing.JPanel;[m
[32m+[m[32mimport javax.swing.JTextField;[m
[32m+[m[32mimport javax.swing.border.MatteBorder;[m
[32m+[m
[32m+[m[32mpublic class InputBox extends JDialog{[m
[32m+[m
[32m+[m	[32mJDialog jDialog;[m
[32m+[m	[32mJPanel jPanel;[m
[32m+[m[41m	[m
[32m+[m[41m	[m
[32m+[m	[32mpublic InputBox(JFrame homeFrame){[m
[32m+[m		[32msuper(homeFrame, Dialog.ModalityType.DOCUMENT_MODAL);[m
[32m+[m		[32mjDialog = this;[m
[32m+[m		[32mthis.setTitle("Add");[m
[32m+[m		[32m//jDialog.setSize(300, 200);[m
[32m+[m		[32mjDialog.setResizable(false);[m
[32m+[m		[32mjPanel = new JPanel(new GridBagLayout());[m
[32m+[m		[32mjDialog.add(jPanel);[m
[32m+[m		[32m/*addLabel("Type something");[m
[32m+[m		[32maddCheckBox();[m
[32m+[m		[32maddInputBox();[m
[32m+[m		[32maddInputBox();[m
[32m+[m		[32mpack();[m
[32m+[m		[32mjDialog.setVisible(true);*/[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32m// Call this when you need a CheckBox[m
[32m+[m	[32mpublic void addCheckBox(){[m
[32m+[m		[32mJCheckBox jcheck = new JCheckBox("Anchovies");[m
[32m+[m		[32mJPanel panel = new JPanel();[m
[32m+[m[32m        panel.add(jcheck);[m
[32m+[m[32m        panel.setBorder(new MatteBorder(0, 0, 0, 0, Color.GRAY));[m
[32m+[m[32m        GridBagConstraints gbc = new GridBagConstraints();[m
[32m+[m[32m        gbc.gridwidth = GridBagConstraints.REMAINDER;[m
[32m+[m[32m        //gbc.weightx = 1;[m
[32m+[m[32m        //gbc.weighty = 1;[m
[32m+[m[32m        gbc.fill = GridBagConstraints.HORIZONTAL;[m
[32m+[m[32m        jPanel.add(panel, gbc);[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32m// Call this when you need a InputBox[m
[32m+[m	[32mpublic JTextField addTextBox(){[m
[32m+[m		[32mJPanel panel = new JPanel();[m
[32m+[m		[32mJTextField textField = new JTextField(20);[m
[32m+[m[32m        panel.add(textField);[m
[32m+[m[32m        panel.setBorder(new MatteBorder(0, 0, 0, 0, Color.GRAY));[m
[32m+[m[32m        GridBagConstraints gbc = new GridBagConstraints();[m
[32m+[m[32m        gbc.gridwidth = GridBagConstraints.REMAINDER;[m
[32m+[m[32m        //gbc.weightx = 1;[m
[32m+[m[32m        //gbc.weighty = 1;[m
[32m+[m[32m        gbc.fill = GridBagConstraints.HORIZONTAL;[m
[32m+[m[32m        jPanel.add(panel, gbc);[m
[32m+[m[41m        [m
[32m+[m[32m        return textField;[m
[32m+[m[41m        [m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32m// Call this when you need a label[m
[32m+[m	[32mpublic void addLabel(String name){[m
[32m+[m		[32mJLabel label = new JLabel(name);[m
[32m+[m		[32mJPanel panel = new JPanel();[m
[32m+[m[32m        panel.add(label);[m
[32m+[m[32m        panel.setBorder(new MatteBorder(0, 0, 0, 0, Color.GRAY));[m
[32m+[m[32m        GridBagConstraints gbc = new GridBagConstraints();[m
[32m+[m[32m        gbc.gridwidth = GridBagConstraints.REMAINDER;[m
[32m+[m[32m        //gbc.weightx = 1;[m
[32m+[m[32m        //gbc.weighty = 1;[m
[32m+[m[32m        gbc.fill = GridBagConstraints.HORIZONTAL;[m
[32m+[m[32m        jPanel.add(panel, gbc);[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32m// Call this when you need a label[m
[32m+[m	[32mpublic JButton addButton(String name){[m
[32m+[m		[32mJButton button = new JButton(name);[m
[32m+[m		[32mJPanel panel = new JPanel();[m
[32m+[m	[32m    panel.add(button);[m
[32m+[m	[32m    panel.setBorder(new MatteBorder(0, 0, 0, 0, Color.GRAY));[m
[32m+[m	[32m    GridBagConstraints gbc = new GridBagConstraints();[m
[32m+[m	[32m    gbc.gridwidth = GridBagConstraints.REMAINDER;[m
[32m+[m	[32m    //gbc.weightx = 1;[m
[32m+[m	[32m    //gbc.weighty = 1;[m
[32m+[m	[32m    gbc.fill = GridBagConstraints.HORIZONTAL;[m
[32m+[m	[32m    jPanel.add(panel, gbc);[m
[32m+[m[41m	    [m
[32m+[m	[32m    return button;[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m[32m}[m
[1mdiff --git a/src/com/Main/LogPanel.java b/src/com/Main/LogPanel.java[m
[1mnew file mode 100644[m
[1mindex 0000000..3a0dfa9[m
[1m--- /dev/null[m
[1m+++ b/src/com/Main/LogPanel.java[m
[36m@@ -0,0 +1,59 @@[m
[32m+[m[32mpackage com.Main;[m
[32m+[m
[32m+[m[32mimport java.awt.Color;[m
[32m+[m[32mimport java.awt.Dimension;[m
[32m+[m[32mimport java.awt.FlowLayout;[m
[32m+[m[32mimport java.awt.Graphics;[m
[32m+[m[32mimport java.awt.GridBagConstraints;[m
[32m+[m[32mimport java.awt.GridBagLayout;[m
[32m+[m
[32m+[m[32mimport javax.swing.JCheckBox;[m
[32m+[m[32mimport javax.swing.JLabel;[m
[32m+[m[32mimport javax.swing.JPanel;[m
[32m+[m[32mimport javax.swing.border.Border;[m
[32m+[m[32mimport javax.swing.border.CompoundBorder;[m
[32m+[m[32mimport javax.swing.border.EmptyBorder;[m
[32m+[m[32mimport javax.swing.border.LineBorder;[m
[32m+[m
[32m+[m[32mpublic class LogPanel extends JPanel{[m
[32m+[m
[32m+[m	[32mprivate GridBagConstraints tasksGBC;[m
[32m+[m[32m    private GridBagConstraints mainGBC;[m
[32m+[m[41m	[m
[32m+[m	[32mpublic LogPanel(){[m
[32m+[m		[32msetSize(new Dimension(500, 400));[m
[32m+[m		[32msetBackground(Color.WHITE);[m
[32m+[m		[32msetLayout(new GridBagLayout());[m
[32m+[m		[32mtasksGBCInit();[m[41m [m
[32m+[m		[32mmainGBCInit();[m
[32m+[m[41m	[m
[32m+[m		[32mJPanel dummyPanel = new JPanel();[m
[32m+[m[32m        dummyPanel.setBackground(new Color(0, 0, 0, 0));[m
[32m+[m[32m        add(dummyPanel, mainGBC);[m
[32m+[m[41m        [m
[32m+[m[41m        [m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32mpublic void recordToLog(String userCommand){[m
[32m+[m		[32mJLabel logItem = new JLabel(userCommand);[m[41m                                 [m
[32m+[m		[32madd(logItem, tasksGBC, 0);[m
[32m+[m		[32mvalidate();[m
[32m+[m		[32mrepaint();[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32mprivate void mainGBCInit(){[m
[32m+[m		[32mmainGBC = new GridBagConstraints();[m
[32m+[m[32m        mainGBC.anchor = GridBagConstraints.NORTH;[m
[32m+[m[32m        mainGBC.gridwidth = GridBagConstraints.REMAINDER;[m
[32m+[m[32m        mainGBC.weightx = 1;[m
[32m+[m[32m        mainGBC.weighty = 1;[m[41m [m
[32m+[m[32m    }[m
[32m+[m
[32m+[m	[32mprivate void tasksGBCInit(){[m
[32m+[m		[32mtasksGBC = new GridBagConstraints();[m[41m		[m
[32m+[m		[32mtasksGBC.gridwidth = GridBagConstraints.REMAINDER;[m
[32m+[m		[32mtasksGBC.weightx = 1;[m
[32m+[m		[32mtasksGBC.fill = GridBagConstraints.HORIZONTAL;[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m[32m}[m
[1mdiff --git a/src/com/Main/Task.java b/src/com/Main/Task.java[m
[1mnew file mode 100644[m
[1mindex 0000000..81da9db[m
[1m--- /dev/null[m
[1m+++ b/src/com/Main/Task.java[m
[36m@@ -0,0 +1,65 @@[m
[32m+[m[32mpackage com.Main;[m
[32m+[m
[32m+[m[32mpublic class Task {[m
[32m+[m	[32mprivate String task;[m
[32m+[m	[32mprivate String location;[m
[32m+[m	[32mprivate String start;[m
[32m+[m	[32mprivate String end;[m
[32m+[m	[32mprivate String tag;[m
[32m+[m	[32mprivate String notification;[m
[32m+[m[41m	[m
[32m+[m	[32mpublic Task(String userCommand){[m
[32m+[m		[32m//TODO parse command into parameters[m
[32m+[m		[32mtask = userCommand.substring(0, userCommand.indexOf(" "));[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic String getTask() {[m
[32m+[m		[32mreturn task;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic String getLocation() {[m
[32m+[m		[32mreturn location;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic String getStart() {[m
[32m+[m		[32mreturn start;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic String getEnd() {[m
[32m+[m		[32mreturn end;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic String getTag() {[m
[32m+[m		[32mreturn tag;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic String getNotification() {[m
[32m+[m		[32mreturn notification;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic void setTask(String task) {[m
[32m+[m		[32mthis.task = task;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic void setLocation(String location) {[m
[32m+[m		[32mthis.location = location;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic void setStart(String start) {[m
[32m+[m		[32mthis.start = start;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic void setEnd(String end) {[m
[32m+[m		[32mthis.end = end;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic void setTag(String tag) {[m
[32m+[m		[32mthis.tag = tag;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic void setNotification(String notification) {[m
[32m+[m		[32mthis.notification = notification;[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m[41m	[m
[32m+[m[32m}[m
[1mdiff --git a/src/com/Main/TaskPanel.java b/src/com/Main/TaskPanel.java[m
[1mnew file mode 100644[m
[1mindex 0000000..8fd4a6d[m
[1m--- /dev/null[m
[1m+++ b/src/com/Main/TaskPanel.java[m
[36m@@ -0,0 +1,143 @@[m
[32m+[m[32mpackage com.Main;[m
[32m+[m
[32m+[m[32mimport java.awt.BorderLayout;[m
[32m+[m[32mimport java.awt.Color;[m
[32m+[m[32mimport java.awt.Component;[m
[32m+[m[32mimport java.awt.Dimension;[m
[32m+[m[32mimport java.awt.FlowLayout;[m
[32m+[m[32mimport java.awt.Graphics;[m
[32m+[m[32mimport java.awt.GridBagConstraints;[m
[32m+[m[32mimport java.awt.GridBagLayout;[m
[32m+[m[32mimport java.awt.GridLayout;[m
[32m+[m[32mimport java.awt.Image;[m
[32m+[m[32mimport java.awt.event.ActionEvent;[m
[32m+[m[32mimport java.awt.event.ActionListener;[m
[32m+[m[32mimport java.awt.event.ItemEvent;[m
[32m+[m[32mimport java.awt.event.ItemListener;[m
[32m+[m[32mimport java.awt.image.BufferedImage;[m
[32m+[m[32mimport java.io.File;[m
[32m+[m[32mimport java.io.IOException;[m
[32m+[m[32mimport java.util.ArrayList;[m
[32m+[m
[32m+[m[32mimport javax.imageio.ImageIO;[m
[32m+[m[32mimport javax.swing.BoxLayout;[m
[32m+[m[32mimport javax.swing.ImageIcon;[m
[32m+[m[32mimport javax.swing.JButton;[m
[32m+[m[32mimport javax.swing.JCheckBox;[m
[32m+[m[32mimport javax.swing.JFrame;[m
[32m+[m[32mimport javax.swing.JLabel;[m
[32m+[m[32mimport javax.swing.JPanel;[m
[32m+[m[32mimport javax.swing.JScrollPane;[m
[32m+[m[32mimport javax.swing.JTextField;[m
[32m+[m[32mimport javax.swing.SwingConstants;[m
[32m+[m[32mimport javax.swing.border.Border;[m
[32m+[m[32mimport javax.swing.border.CompoundBorder;[m
[32m+[m[32mimport javax.swing.border.EmptyBorder;[m
[32m+[m[32mimport javax.swing.border.LineBorder;[m
[32m+[m[32mimport javax.swing.border.MatteBorder;[m
[32m+[m
[32m+[m[32mimport java.awt.*;[m
[32m+[m
[32m+[m[32mpublic class TaskPanel extends JPanel {[m
[32m+[m
[32m+[m[41m	[m
[32m+[m[32m    private JPanel taskList;[m
[32m+[m[32m    private GridBagConstraints mainGBC;[m
[32m+[m	[32mprivate GridBagConstraints tasksGBC;[m
[32m+[m
[32m+[m[32m    public TaskPanel() {[m
[32m+[m[32m        setLayout(new BorderLayout());[m
[32m+[m		[32msetSize(new Dimension(500, 400));[m
[32m+[m		[32mmainGBCInit();[m
[32m+[m		[32mtasksGBCInit();[m[41m [m
[32m+[m[41m        [m
[32m+[m[32m        taskList = new JPanel(new GridBagLayout()) {[m
[32m+[m[41m        [m	[32m@Override[m
[32m+[m[32m            protected void paintComponent(Graphics g) {[m
[32m+[m[41m            [m	[32msuper.paintComponent(g);[m
[32m+[m[41m        [m		[32mtry {[m
[32m+[m[41m        [m	[32m        g.drawImage(ImageIO.read(this.getClass().getResource("background.png")), 0, 0, null);[m
[32m+[m[41m        [m		[32m} catch (IOException e) {[m
[32m+[m[41m        [m			[32m// TODO Auto-generated catch block[m
[32m+[m[41m        [m			[32me.printStackTrace();[m
[32m+[m[41m        [m		[32m}[m
[32m+[m[32m            }[m
[32m+[m[32m        };[m
[32m+[m[41m        [m
[32m+[m[32m        taskList.setSize(100, 200);[m
[32m+[m[41m        [m
[32m+[m[32m        JPanel dummyPanel = new JPanel();[m
[32m+[m[32m        dummyPanel.setBackground(new Color(0, 0, 0, 0));[m
[32m+[m[32m        taskList.add(dummyPanel, mainGBC);[m
[32m+[m[32m        add(new JScrollPane(taskList));[m
[32m+[m[41m        [m
[32m+[m[32m    }[m
[32m+[m[41m    [m
[32m+[m[32m    @Override[m
[32m+[m[32m    public void add(Component comp, Object constraints, int index){[m
[32m+[m[41m    [m	[32mtaskList.add(comp, constraints, index);[m
[32m+[m[32m    }[m
[32m+[m[41m    [m
[32m+[m[32m    private void mainGBCInit(){[m
[32m+[m		[32mmainGBC = new GridBagConstraints();[m
[32m+[m[32m        mainGBC.anchor = GridBagConstraints.NORTH;[m
[32m+[m[32m        mainGBC.gridwidth = GridBagConstraints.REMAINDER;[m
[32m+[m[32m        mainGBC.weightx = 1;[m
[32m+[m[32m        mainGBC.weighty = 1;[m[41m [m
[32m+[m[32m    }[m
[32m+[m[41m    [m
[32m+[m
[32m+[m	[32mprivate void tasksGBCInit(){[m
[32m+[m		[32mtasksGBC = new GridBagConstraints();[m[41m		[m
[32m+[m		[32mtasksGBC.gridwidth = GridBagConstraints.REMAINDER;[m
[32m+[m		[32mtasksGBC.weightx = 1;[m
[32m+[m		[32mtasksGBC.fill = GridBagConstraints.HORIZONTAL;[m
[32m+[m	[32m}[m
[32m+[m[41m    [m
[32m+[m[32m    /**[m
[32m+[m[32m     * addTask on the list[m
[32m+[m[32m     *[m
[32m+[m[32m     * @param task    The task object.[m
[32m+[m[32m     * @param userInputBox   The user input box.[m
[32m+[m[32m     */[m
[32m+[m[32m    public void addTask(Task task){[m
[32m+[m[41m    	[m
[32m+[m[41m    [m	[32mif (!task.equals("")) {[m
[32m+[m	[41m    [m	[32mJPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT)){[m
[32m+[m	[41m    [m		[32mprotected void paintComponent(Graphics g)[m
[32m+[m	[41m    [m	[32m    {[m
[32m+[m	[41m    [m	[32m        g.setColor( getBackground() );[m
[32m+[m	[41m    [m	[32m        g.fillRect(0, 0, getWidth(), getHeight());[m
[32m+[m	[41m    [m	[32m        super.paintComponent(g);[m
[32m+[m	[41m    [m	[32m    }[m
[32m+[m	[41m    [m	[32m};[m
[32m+[m	[41m    [m	[32mpanel.setOpaque(false);[m
[32m+[m	[41m    [m	[32mpanel.setBackground( new Color(255, 0, 0, 20) );[m
[32m+[m[41m    [m		[32mJCheckBox checkBox = taskCheckBoxSetting(task.getTask());[m[41m                                 [m
[32m+[m[41m    [m		[32mpanel.add(checkBox);[m
[32m+[m[41m    		[m
[32m+[m[41m    [m		[32mBorder border = new LineBorder(Color.GRAY, 1, true);[m
[32m+[m[41m    [m		[32mBorder margin = new EmptyBorder(10,10,10,10);[m
[32m+[m[41m    [m		[32mpanel.setBorder(new CompoundBorder(margin, border));[m
[32m+[m[41m    		[m
[32m+[m[41m    [m		[32mtaskList.add(panel, tasksGBC, 0);[m[41m   [m
[32m+[m[41m    [m		[32mvalidate();[m
[32m+[m[41m    [m		[32mrepaint();[m
[32m+[m[41m        [m
[32m+[m[41m    [m	[32m}[m[41m   [m
[32m+[m[32m    }[m
[32m+[m[41m    [m
[32m+[m[32m    private JCheckBox taskCheckBoxSetting(String textForCheckBox){[m
[32m+[m[41m    [m	[32mJCheckBox checkBox = new JCheckBox(textForCheckBox);[m
[32m+[m		[32mcheckBox.setOpaque(false);[m
[32m+[m		[32mcheckBox.setBackground( new Color(255, 255, 255, 20) );[m
[32m+[m		[32mcheckBox.setForeground(Color.WHITE);[m
[32m+[m[41m		[m
[32m+[m		[32mreturn checkBox;[m
[32m+[m[32m    }[m
[32m+[m[41m    [m
[32m+[m
[32m+[m
[32m+[m[41m       [m
[32m+[m[41m  [m
[32m+[m[32m}[m
[1mdiff --git a/src/com/Main/TextFileSaver.java b/src/com/Main/TextFileSaver.java[m
[1mnew file mode 100644[m
[1mindex 0000000..6dacfd7[m
[1m--- /dev/null[m
[1m+++ b/src/com/Main/TextFileSaver.java[m
[36m@@ -0,0 +1,37 @@[m
[32m+[m[32mpackage com.Main;[m
[32m+[m
[32m+[m[32mimport java.io.File;[m
[32m+[m[32mimport java.io.FileWriter;[m
[32m+[m[32mimport java.io.IOException;[m
[32m+[m[32mimport java.nio.file.Files;[m
[32m+[m[32mimport java.nio.file.Paths;[m
[32m+[m[32mimport java.util.List;[m
[32m+[m
[32m+[m[32mpublic class TextFileSaver {[m
[32m+[m
[32m+[m	[32mFile file;[m
[32m+[m	[32mString fileName;[m
[32m+[m[41m	[m
[32m+[m	[32mpublic TextFileSaver(String category){[m
[32m+[m		[32mfileName = category+".txt";[m
[32m+[m		[32mtry {[m
[32m+[m			[32mfile = new File(category+".txt");[m[41m			[m
[32m+[m			[32mif(!file.exists()) {[m[41m [m
[32m+[m			[32m    // if file not exist, create the file[m
[32m+[m				[32mFileWriter fileWriter = new FileWriter(file);[m
[32m+[m				[32mfileWriter.flush();[m
[32m+[m				[32mfileWriter.close();[m
[32m+[m			[32m}[m
[32m+[m		[32m} catch (IOException e) {[m
[32m+[m			[32me.printStackTrace();[m
[32m+[m		[32m}[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32mpublic void removeOneRow(int index) throws IOException{[m
[32m+[m		[32mList<String> fileContent = Files.readAllLines(Paths.get(fileName));[m
[32m+[m		[32mfileContent.remove(index);[m
[32m+[m		[32mfor (String line : fileContent) {[m
[32m+[m[41m		    [m
[32m+[m		[32m}[m
[32m+[m	[32m}[m
[32m+[m[32m}[m
[1mdiff --git a/src/com/Main/background.png b/src/com/Main/background.png[m
[1mnew file mode 100644[m
[1mindex 0000000..850d4d1[m
Binary files /dev/null and b/src/com/Main/background.png differ
