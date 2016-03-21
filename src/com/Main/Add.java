package com.Main;

import java.util.logging.Level;

public class Add extends Dispatcher{
	private Task newTask;
	
	public Add(String[] parsedUserInput) {
		//The element of the string array will be in 
		//0.taskName, 1.date 2.location 3.start 4.end 5.tag 6.notification
		newTask.setTask(parsedUserInput[0]);
		newTask.setDate(parsedUserInput[1]);
		newTask.setLocation(parsedUserInput[2]);
		newTask.setStart(parsedUserInput[3]);
		newTask.setEnd(parsedUserInput[4]);
		newTask.setTag(parsedUserInput[5]);
		newTask.setNotification(parsedUserInput[6]);
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
