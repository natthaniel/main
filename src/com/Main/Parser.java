package com.Main;

public class Parser {
	
	Command command;
	
	public Parser(String command){
		
	}
	
	public Command getCommand(){
		return command;
	}
	
}

class Command{
	Task task;
	String commandType = "";
	int deleteRow;
	
	public Command(){
		
	}
	
	public Task getTask(){
		return task;
	}
	
	public String getCommandType(){
		return commandType;
	}
}

//1. split into command + string
//2. further split the string into task object
