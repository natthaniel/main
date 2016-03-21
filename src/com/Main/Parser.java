package com.Main;

public class Parser {

	public Parser(){
		
	}
	
	public Commander parse(String input){
		String command = getCommandFromInput(input);
		input = input.substring(command.length());
		switch(command){
		case "add":
			String[] addParameters = new String[7];
			addParameters[0] = getTaskName(input);
			addParameters[1] = getLocation(input);
			addParameters[2] = getDate(input);
			addParameters[3] = getStart(input);
			addParameters[4] = getEnd(input);
			addParameters[5] = getTag(input);
			addParameters[6] = getNotification(input);
			return new Add(addParameters);
			
		case "delete":
			String deleteParameters[] = new String[1];
			deleteParameters[0] = getDeleteRow(input);
			return new Delete(deleteParameters);
			
		case "update":
			String updateParameters[] = new String[3];
			updateParameters[0] = getUpdateRow(input);
			input = removeFirstWord(input);
			updateParameters[1] = getNextWord(input);
			input = removeFirstWord(input);
			updateParameters[2] = input;
			return new Update(updateParameters);
		}
	}
	
	private String getNextWord(String string){
		String result = string.substring(0, string.indexOf(" "));
		return result;
	}
	
	private String removeFirstWord(String string){
		String newString = string.substring(0, string.indexOf(" "));
		return newString;
	}
	
	private String getCommandFromInput(String string){
		String command = string.substring(0,string.indexOf(" "));
		return command;
	}
	
	private String getUpdateRow(String parameters){
		String updateRow;
		updateRow = parameters.substring(0, parameters.indexOf(" ")); 
		return updateRow;
	}
	
	private String getDeleteRow(String parameters){
		String deleteRow = parameters;
		return deleteRow;
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
		date = parameters.substring(parameters.indexOf("on") + 3, parameters.indexOf("from") - 1);
		return date;
	}
	private String getStart(String parameters){
		String start = "";
		start = parameters.substring(parameters.indexOf("from") + 5, parameters.indexOf("~"));
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


/* Old parser code
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
			processUpdate(parameters);
			break;

		default:
			System.out.println("Invalid command input");
		}
	}

	public Command getCommand() {
		return command;
	}
	
	private void processUpdate(String parameters){
		int updateRow = getUpdateRow(parameters);
		command.setUpdateRow(updateRow);
		parameters = parameters.substring(parameters.indexOf(" ") + 1);
		System.out.println(parameters.substring(0,parameters.indexOf(" ")));
		String updateType = parameters.substring(0,parameters.indexOf(" "));
		command.setUpdateType(updateType);
		parameters = parameters.substring(parameters.indexOf(" "));
		String updateDetail = parameters.substring(parameters.indexOf(" ")+1);
		command.setUpdateDetail(updateDetail);
	}
	private void processDelete(String parameters){
		int deleteRow = getDeleteRow(parameters);
		command.setDeleteRow(deleteRow);
	}
	public void createTaskWithParameters(String parameters){
		Task task = new Task();
		taskName = getTaskName(parameters);
		task.setTask(taskName);
		location = getLocation(parameters);
		task.setLocation(location);
		date = getDate(parameters);
		task.setDate(date);
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
	
	
	
// the following methods are used for testing
	
	public String getTaskName(){
		return taskName;
	}
	public String getLocation(){
		return location;
	}
	public String getDate(){
		return date;
	}
	
	public String getStart(){
		return start;
	}
	public String getEnd(){
		return end;
	}
	public String getTag(){
		return tag;
	}
	public String getNotification(){
		return notification;
	}
	public int getDeleteRow(){
		return command.getDeleteRow();
	}
	
	public int getUpdateRow(){
		return command.getUpdateRow();
	}
	
	public String getUpdateType(){
		return command.getUpdateType();
	}
	
	public String getUpdateDetail(){
		return command.getUpdateDetail();
	}
}
*/
