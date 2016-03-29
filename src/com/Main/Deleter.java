package com.Main;

import java.util.ArrayList;

public class Deleter implements Commander{
	private int indexToDelete;
	private ArrayList<Task> TaskList;
	private String taskDeleted;
	
	public Deleter(String[] parsedUserInput, ArrayList<Task> TaskList){
		//The first element in the array is the index to be deleted
		indexToDelete = Integer.parseInt(parsedUserInput[0]);
		this.TaskList = TaskList;
	}
	@Override
	public String execute() {
		try{
		//assert(indexToDelete >=0);
		taskDeleted = TaskList.get(indexToDelete-1).getTaskName() + " on " + TaskList.get(indexToDelete-1).getDate();
		TaskList.remove(indexToDelete-1);
		return "Task deleted successfully";
		} catch (Exception e){
			e.printStackTrace();
			return e.toString();
		}
		
		//return "Task " + indexToDelete + ": " + taskDeleted + " deleted successfully";
	}

}
