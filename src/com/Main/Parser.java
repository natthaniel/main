package com.Main;

public class Parser {

	private Command command;

	public Parser(String cmd) {
		command = new Command();
		String commandType = cmd.substring(0, cmd.indexOf(" "));
		String parameters = cmd.substring(cmd.indexOf(" ") + 1);
		command.setCommandType(commandType);
		switch (commandType) {
		case "add":
			Task task = new Task();
			task.setTask(getNextParameter(parameters));
			parameters = parameters.substring(parameters.indexOf(">") + 1);
			task.setLocation(getNextParameter(parameters));
			parameters = parameters.substring(parameters.indexOf(">") + 1);
			task.setStart(getNextParameter(parameters));
			parameters = parameters.substring(parameters.indexOf(">") + 1);
			task.setEnd(getNextParameter(parameters));
			parameters = parameters.substring(parameters.indexOf(">") + 1);
			task.setTag(getNextParameter(parameters));
			parameters = parameters.substring(parameters.indexOf(">") + 1);
			task.setNotification(getNextParameter(parameters));
			command.setTask(task);
			break;
		case "delete":
			parameters = getNextParameter(parameters);
			int deleteRow = Integer.parseInt(parameters)-1;
			command.setDeleteRow(deleteRow);
			break;

		default:
		}
	}

	public Command getCommand() {
		return command;
	}
	
	
	private String getNextParameter(String cmd){
		String parameter = "";
		if ((cmd.indexOf("<") + 1) != cmd.indexOf(">")) {

			parameter = cmd.substring(cmd.indexOf("<") + 1, cmd.indexOf(">"));
			
		}
		return parameter;
	}

}



// 1. split into command + string
// 2. further split the string into task object
