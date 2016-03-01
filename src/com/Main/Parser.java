package com.Main;

public class Parser {

	Command command;

	public Parser(String cmd) {
		String commandType = cmd.substring(0, cmd.indexOf(" "));
		String parameters = cmd.substring(cmd.indexOf(" ") + 1);
		command.setCommandType(commandType);
		switch (commandType) {
		case "add":
			command.getTask().setTask(getNextParameter(parameters));
			command.getTask().setLocation(getNextParameter(parameters));
			command.getTask().setStart(getNextParameter(parameters));
			command.getTask().setEnd(getNextParameter(parameters));
			command.getTask().setTag(getNextParameter(parameters));
			command.getTask().setNotification(getNextParameter(parameters));
			break;
		case "delete":
			int deleteRow = Integer.parseInt(parameters);
			command.setDeleteRow(deleteRow);
			break;

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
	
	public int getDeleteRow(){
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
