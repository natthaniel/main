package com.Main;

import java.util.ArrayList;

/*
 * This class can take in either a single Task object or an arrayList of them.
 * Then an object of ConverterToString will convert the Task object(s) into a formatted string.
 * Such string will be returned to the caller.
 */
public class ConverterToString {
	private Task taskIns;
	private ArrayList<Task> taskList;
	//Constructor
	public ConverterToString() {
		taskIns = null;
		taskList = null;
	}
	public ConverterToString(Task TaskToConvert){
		if(TaskToConvert == null){
			System.out.println("Empty task");
		}
		taskIns = TaskToConvert;
		taskList = null;
	}
	public ConverterToString(ArrayList<Task> SomeTasksToConvert){
		if(SomeTasksToConvert == null){
			System.out.println("Empty tasks");
		}
		taskIns = null;
		taskList = SomeTasksToConvert;
	}
	public String convert(){
		if (taskIns != null){
			return convertSingleTask();
		}
		else {
			return convertSomeTasks();
		}
	}
	private String convertSingleTask(){
		StringBuilder TaskToShow = new StringBuilder();
		TaskToShow.append(String.format(DISPLAY_TASK_TITLE_MESSAGE, taskIns.getTaskName()));
		TaskToShow.append(String.format(DISPLAY_TASK_DATE_MESSAGE, taskIns.getDate()));
		TaskToShow.append(String.format(DISPLAY_TASK_LOCATION_MESSAGE, taskIns.getLocation()));
		TaskToShow.append(String.format(DISPLAY_TASK_START_MESSAGE, taskIns.getStart()));
		TaskToShow.append(String.format(DISPLAY_TASK_END_MESSAGE, taskIns.getEnd()));
		TaskToShow.append(String.format(DISPLAY_TASK_TAG_MESSAGE, taskIns.getTag()));
		TaskToShow.append(String.format(DISPLAY_TASK_NOTIFICATION_MESSAGE, taskIns.getNotification()));
		
		return TaskToShow.toString();
	}
	private String convertSomeTasks(){
		StringBuilder TasksToShow = new StringBuilder();
		for(int i = 0; i < taskList.size(); i++){
			taskIns = taskList.get(i);
			String singleTask = convertSingleTask();
			TasksToShow.append(singleTask);
		}
		return TasksToShow.toString();		
	}
	
	
	private static final String DISPLAY_TASK_TITLE_MESSAGE = "Title:%1$s\r\n";
	private static final String DISPLAY_TASK_DATE_MESSAGE = "Date:%1$s\r\n";
	private static final String DISPLAY_TASK_LOCATION_MESSAGE = "Location:%1$s\r\n";
	private static final String DISPLAY_TASK_START_MESSAGE = "Start:%1$s\r\n";
	private static final String DISPLAY_TASK_END_MESSAGE = "End:%1$s\r\n";
	private static final String DISPLAY_TASK_TAG_MESSAGE = "Tag:%1$s\r\n";
	private static final String DISPLAY_TASK_NOTIFICATION_MESSAGE = "Notification:%1$s\r\n";
}
