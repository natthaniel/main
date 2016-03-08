package com.Main;

import java.util.ArrayList;

public class Processor {
	private static final String DISPLAY_TASK_TITLE_MESSAGE = "Title:%1$s\r\n";
	private static final String DISPLAY_TASK_DATE_MESSAGE = "Date:%1$s\r\n";
	private static final String DISPLAY_TASK_LOCATION_MESSAGE = "Location:%1$s\r\n";
	private static final String DISPLAY_TASK_START_MESSAGE = "Start:%1$s\r\n";
	private static final String DISPLAY_TASK_END_MESSAGE = "End:%1$s\r\n";
	private static final String DISPLAY_TASK_TAG_MESSAGE = "Tag:%1$s\r\n";
	private static final String DISPLAY_TASK_NOTIFICATION_MESSAGE = "Notification:%1$s\r\n";
	     
	TextFileSaver storage = new TextFileSaver();
	
	public Processor(){
		
	}
	
	public String processCommand(String command){
		Parser parser = new Parser(command);
		String commandType = parser.getCommand().getCommandType();
		switch (commandType){
			case "add":
				addTask(parser);
				return "add";
			case "delete":
				deleteTask(parser);
				return "delete";
			case "update":
				updateTask(parser);
			default:
				return "";
		}
	}
	
	private void updateTask(Parser parser) {
		int IndexForUpdate = parser.getCommand().getUpdateRow() - 1;
		String TypeToUpdate = parser.getCommand().getUpdateType();
		String DetailToUpdate = parser.getCommand().getUpdateDetail();
		ArrayList<Task> TaskList = storage.getTaskData();
		TaskList = executeUpdateRequest(IndexForUpdate, TypeToUpdate, DetailToUpdate, TaskList);
		storage.saveFile(TaskList);
		//displayOneTask(IndexForUpdate, TaskList);
	}

	private String displayOneTask(int indexForUpdate, ArrayList<Task> taskList) {
		StringBuilder TaskToShow = new StringBuilder();
		TaskToShow.append(String.format(DISPLAY_TASK_TITLE_MESSAGE, taskList.get(indexForUpdate).getTaskName()));
		TaskToShow.append(String.format(DISPLAY_TASK_DATE_MESSAGE, taskList.get(indexForUpdate).getDate()));
		TaskToShow.append(String.format(DISPLAY_TASK_LOCATION_MESSAGE, taskList.get(indexForUpdate).getLocation()));
		TaskToShow.append(String.format(DISPLAY_TASK_START_MESSAGE, taskList.get(indexForUpdate).getStart()));
		TaskToShow.append(String.format(DISPLAY_TASK_END_MESSAGE, taskList.get(indexForUpdate).getEnd()));
		TaskToShow.append(String.format(DISPLAY_TASK_TAG_MESSAGE, taskList.get(indexForUpdate).getTag()));
		TaskToShow.append(String.format(DISPLAY_TASK_NOTIFICATION_MESSAGE, taskList.get(indexForUpdate).getNotification()));
						
		return TaskToShow.toString();
		
	}

	private void addTask(Parser parser){
		storage.readFile();
		ArrayList<Task> TaskList = storage.getTaskData();
		TaskList.add(parser.getCommand().getTask());
		
		storage.saveFile(TaskList);
	}
	

	private void deleteTask(Parser parser){
		int indexForDeletion = parser.getCommand().getDeleteRow();
		ArrayList<Task> TaskList = storage.getTaskData();
		TaskList.remove(indexForDeletion);
		storage.saveFile(TaskList);
	}
	

	private ArrayList<Task> executeUpdateRequest(int IndexForUpdate, String TypeToUpdate, String DetailToUpdate,
			ArrayList<Task> TaskList) {
		switch (TypeToUpdate){
		case "title":
			TaskList.get(IndexForUpdate).setTask(DetailToUpdate);
			break;
		case "location":
			TaskList.get(IndexForUpdate).setLocation(DetailToUpdate);
			break;
		case "date":
			TaskList.get(IndexForUpdate).setDate(DetailToUpdate);
			break;
		case "start":
			TaskList.get(IndexForUpdate).setStart(DetailToUpdate);
			break;
		case "end":
			TaskList.get(IndexForUpdate).setEnd(DetailToUpdate);
			break;
		case "tag":
			TaskList.get(IndexForUpdate).setTag(DetailToUpdate);
			break;
		case "notification":
			TaskList.get(IndexForUpdate).setNotification(DetailToUpdate);
			break;
		default:
			System.out.println("Keyword for the type of detail is invalid.");
		}
		return TaskList;
	}
	
	public TextFileSaver getStorage(){
		return storage;
	}
}
