package com.Main;

import java.util.ArrayList;

public class Delete implements Commander{
	private int indexToDelete;
	private ArrayList<Task> TaskList;
	
	public Delete(String[] parsedUserInput, ArrayList<Task> TaskList){
		//The first element in the array is the index to be deleted
		indexToDelete = Integer.parseInt(parsedUserInput[0]);
	}
	@Override
	public String execute() {
		try{
		//assert(indexToDelete >=0);
		TaskList.remove(indexToDelete);
		} catch (Exception e){
			e.printStackTrace();
			return e.toString();
		}
		
		return "Task deleted successfully";
	}

}
