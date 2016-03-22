package com.Main;

import java.util.ArrayList;

public class Update implements Commander{
	
	private int indexToUpdate;
	private String sectionToUpdate;
	private String detailToUpdate;
	private ArrayList<Task> TaskList;
	
	public Update(String[] parsedUserInput, ArrayList<Task> TaskList){
		//The element of the string array will be in the following format
		//0: indexToUpdate, 1: sectionToUpdate, 2: detailToUpdate
		indexToUpdate = Integer.parseInt(parsedUserInput[0]);
		sectionToUpdate = parsedUserInput[1];
		detailToUpdate = parsedUserInput[2];
		this.TaskList = TaskList;
	}
	
	@Override
	public String execute() {
		Task taskToUpdate;
		switch(sectionToUpdate.toLowerCase()){
		case "task":
			taskToUpdate =TaskList.get(indexToUpdate);
			taskToUpdate.setTask(detailToUpdate);
			TaskList.set(indexToUpdate, taskToUpdate);
			break;
		case "location":
			taskToUpdate =TaskList.get(indexToUpdate);
			taskToUpdate.setLocation(detailToUpdate);
			TaskList.set(indexToUpdate, taskToUpdate);
			break;
		case "date":
			taskToUpdate =TaskList.get(indexToUpdate);
			taskToUpdate.setDate(detailToUpdate);
			TaskList.set(indexToUpdate, taskToUpdate);
			break;
		case "start":
			taskToUpdate =TaskList.get(indexToUpdate);
			taskToUpdate.setStart(detailToUpdate);
			TaskList.set(indexToUpdate, taskToUpdate);
			break;
		case "end":
			taskToUpdate =TaskList.get(indexToUpdate);
			taskToUpdate.setEnd(detailToUpdate);
			TaskList.set(indexToUpdate, taskToUpdate);
			break;
		case "tag":
			taskToUpdate =TaskList.get(indexToUpdate);
			taskToUpdate.setTag(detailToUpdate);
			TaskList.set(indexToUpdate, taskToUpdate);
			break;
		case "notification":
			taskToUpdate =TaskList.get(indexToUpdate);
			taskToUpdate.setNotification(detailToUpdate);
			TaskList.set(indexToUpdate, taskToUpdate);
			break;
		default:
			return "Keyword for the type of detail is invalid.";
		}
				
		return "Task was updated successfully";
	}

}
