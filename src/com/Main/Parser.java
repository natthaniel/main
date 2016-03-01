package com.Main;

public class Parser {

	Command command;

	public Parser(String cmd) {
		String commandType = cmd.substring(0, cmd.indexOf(" "));
		String parameters = cmd.substring(cmd.indexOf(" ") + 1);
		command.setCommandType(commandType);
		switch (commandType) {
	
		default:
		}
	}

	public Command getCommand() {
		return command;
	}
	
	private String getNextParameter(String cmd){
		cmd.substring(cmd.indexOf("<") + 1, cmd.indexOf(">"));
		cmd = cmd.substring(cmd.indexOf(">") + 1);
		return cmd;
	}

}

class Command {
	Task task;
	String commandType = "";
	int deleteRow;

	public Command() {

	}
	
	public void setDeleteRow(int indexToDelete){
		deleteRow = indexToDelete;
	}
	
	public int getDeleteRow(int indexToDelete){
		return deleteRow;
	}
	
	public void setCommandType(String cmdType) {
		commandType = cmdType;
	}

	public Task getTask() {
		return task;
	}

	public String getCommandType() {
		return commandType;
	}

}

// 1. split into command + string
// 2. further split the string into task object
