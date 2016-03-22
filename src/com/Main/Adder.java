package com.Main;

import java.util.ArrayList;
import java.util.logging.Level;

public class Adder implements Commander{
	private Task newTask = new Task();
	ArrayList<Task> TaskList;
	
	public Adder(String[] parsedUserInput, ArrayList<Task> TaskList) {
		//The element of the string array will be in 
		//0.taskName, 1.location 2.date 3.start 4.end 5.tag 6.notification
		newTask.setTask(parsedUserInput[0]);
		newTask.setLocation(parsedUserInput[1]);
		newTask.setDate(parsedUserInput[2]);
		newTask.setStart(parsedUserInput[3]);
		newTask.setEnd(parsedUserInput[4]);
		newTask.setTag(parsedUserInput[5]);
		newTask.setNotification(parsedUserInput[6]);
		this.TaskList = TaskList;
	}

	@Override
	public String execute() {
		
		try {
			TaskList.add(newTask);
		} catch (Exception e) {
			//System.out.println("task NOT added successfully" + e.getMessage());
			e.printStackTrace();
			//ProcessorLogger.log(Level.WARNING, "task not added successfully", e);
		}	
		return "Task added successfully";
	}

}
