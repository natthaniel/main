package com.Main;

public class Command {
	Task task;
	String commandType;
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
		this.commandType = cmdType;
	}

	public Task getTask() {
		return task;
	}
	
	public void setTask(Task task){
		this.task = task;
	}

	public String getCommandType() {
		return commandType;
	}

}