package com.Main;

import java.util.ArrayList;

public class Deleter implements Commander{
	private int indexToDelete;
	private ArrayList<Task> TaskList;
	
	public Deleter(String[] parsedUserInput, ArrayList<Task> TaskList){
		//The first element in the array is the index to be deleted
		indexToDelete = Integer.parseInt(parsedUserInput[0]);
		this.TaskList = TaskList;
	}
	@Override
	public String execute() {
		try{
		//assert(indexToDelete >=0);
		TaskList.remove(indexToDelete-1);
		} catch (Exception e){
			e.printStackTrace();
			return e.toString();
		}
		
		return "Task deleted successfully";
	}

}
