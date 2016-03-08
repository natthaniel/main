package com.Main;

public class Parser {

	private Command command;
	private String taskName = "";
	private String location = "";
	private String date = "";
	private String start = "";
	private String end = "";
	private String tag = "";
	private String notification = "";

	public Parser(String cmd) {
		command = new Command();
		String commandType = cmd.substring(0, cmd.indexOf(" "));
		String parameters = cmd.substring(cmd.indexOf(" ") + 1);
		command.setCommandType(commandType);
		switch (commandType) {
		
		// add task @location on date from 1230~1300 #tag -notification
		case "add":
			createTaskWithParameters(parameters);
			break;
		
		// delete taskNumber
		case "delete":
			processDelete(parameters);
			break;
		
		// update taskNumber detailType newValue	
		case "update":
			
			break;

		default:
		}
	}

	public Command getCommand() {
		return command;
	}
	private void processDelete(String parameters){
		int deleteRow = Integer.parseInt(parameters)-1;
		command.setDeleteRow(deleteRow);
	}
	private void createTaskWithParameters(String parameters){
		Task task = new Task();
		taskName = getTaskName(parameters);
		task.setTask(taskName);
		date = getDate(parameters);
		task.setDate(date);
		location = getLocation(parameters);
		task.setLocation(location);
		start = getStart(parameters);
		task.setStart(start);
		end = getEnd(parameters);
		task.setEnd(end);
		tag = getTag(parameters);
		task.setTag(tag);
		notification = getNotification(parameters);
		task.setNotification(notification);
		command.setTask(task);
	}
	

	private String getTaskName(String parameters){
		String taskName = "";
		taskName = parameters.substring(0, parameters.indexOf("@") - 1);
		return taskName;
	}	
	private String getLocation(String parameters){
		String location = "";
		location = parameters.substring(parameters.indexOf("@") + 1, parameters.indexOf("on") - 1);
		return location;
	}
	private String getDate(String parameters){
		String date = "";
		date = parameters.substring(parameters.indexOf("on") + 1, parameters.indexOf("from") - 1);
		return date;
	}
	private String getStart(String parameters){
		String start = "";
		start = parameters.substring(parameters.indexOf("from") + 1, parameters.indexOf("~") - 1);
		return start;
	}
	private String getEnd(String parameters){
		String end = "";
		end = parameters.substring(parameters.indexOf("~") + 1, parameters.indexOf("#") - 1);
		return end;
	}
	private String getTag(String parameters){
		String tag = "";
		tag = parameters.substring(parameters.indexOf("#") + 1, parameters.indexOf("-") - 1);
		return tag;
	}
	private String getNotification(String parameters){
		String notification = "";
		notification = parameters.substring(parameters.indexOf("-") + 1);
		return notification;
	}
	
	
	
	

}

