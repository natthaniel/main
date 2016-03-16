package com.Main;
import java.util.logging.*;
import java.util.ArrayList;

public class Processor {
	private static final String DISPLAY_TASK_TITLE_MESSAGE = "Title:%1$s\r\n";
	private static final String DISPLAY_TASK_DATE_MESSAGE = "Date:%1$s\r\n";
	private static final String DISPLAY_TASK_LOCATION_MESSAGE = "Location:%1$s\r\n";
	private static final String DISPLAY_TASK_START_MESSAGE = "Start:%1$s\r\n";
	private static final String DISPLAY_TASK_END_MESSAGE = "End:%1$s\r\n";
	private static final String DISPLAY_TASK_TAG_MESSAGE = "Tag:%1$s\r\n";
	private static final String DISPLAY_TASK_NOTIFICATION_MESSAGE = "Notification:%1$s\r\n";
	     
	private TextFileSaver storage = new TextFileSaver();
	private TaskforUpdateFunction UpdatedTask;
	private static Logger ProcessorLogger = Logger.getLogger("Log of Processor");
	
	public Processor(){
		UpdatedTask = new TaskforUpdateFunction();
	}
	
	public String processCommand(String command){
		Parser parser = new Parser(command);
		String commandType = parser.getCommand().getCommandType();
		assert(commandType != null);
		switch (commandType){
			case "add":
				addTask(parser);
				return "add";
			case "delete":
				deleteTask(parser);
				return "delete";
			case "update":
				updateTask(parser);
				return "update";
			default:
				return "";
		}
	}
	
	private TaskforUpdateFunction updateTask(Parser parser) {
		int IndexForUpdate = parser.getCommand().getUpdateRow() - 1;
		String TypeToUpdate = parser.getCommand().getUpdateType();
		String DetailToUpdate = parser.getCommand().getUpdateDetail();
		ArrayList<Task> TaskList = storage.getTaskData();
		//IndexForUpdate = -1;
		assert(IndexForUpdate >= 0);
		assert(TypeToUpdate != null);
		ProcessorLogger.log(Level.INFO, "gonna start to execute the update request");
		try {
			UpdatedTask.setOldTask(TaskList.get(IndexForUpdate));
			TaskList = executeUpdateRequest(IndexForUpdate, TypeToUpdate, DetailToUpdate, TaskList);
			
			UpdatedTask.setNewTask(TaskList.get(IndexForUpdate));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid Task number detected, re-enter.");
			//e.printStackTrace();
			ProcessorLogger.log(Level.WARNING, "Update error: invalid Task reference number", e);
		}
		storage.saveFile(TaskList);
		ProcessorLogger.log(Level.INFO, "update done and saved");

		//displayOneTask(IndexForUpdate, TaskList);
		
		return UpdatedTask;
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
		Task taskTobeAdded = parser.getCommand().getTask();
		assert(taskTobeAdded != null);
		
		try {
			TaskList.add(taskTobeAdded);
		} catch (Exception e) {
			System.out.println("task not added successfuly" + e.getMessage());
			e.printStackTrace();
			ProcessorLogger.log(Level.WARNING, "task not added successfuly", e);
		}		
		storage.saveFile(TaskList);
	}
	

	private void deleteTask(Parser parser){
		int indexForDeletion = parser.getCommand().getDeleteRow();
		assert(indexForDeletion >= 0);	
		ArrayList<Task> TaskList = storage.getTaskData();
		try {
			TaskList.remove(indexForDeletion);
			ProcessorLogger.log(Level.INFO, "deletion done successfully.");
		} catch (IndexOutOfBoundsException e) {
			ProcessorLogger.log(Level.WARNING, "Task not deleted successfully due to invalid index", e);
			e.printStackTrace();
		}
		storage.saveFile(TaskList);
		ProcessorLogger.log(Level.INFO, "deletion saved.");
	}
	

	private ArrayList<Task> executeUpdateRequest(int IndexForUpdate, String TypeToUpdate, String DetailToUpdate,
			ArrayList<Task> TaskList) {
		switch (TypeToUpdate.toLowerCase()){
		case "task":
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
	
	public TaskforUpdateFunction getUpdatedTask(){
		return UpdatedTask;
	}
	
	public void readFile(){
		storage.readFile();
	}
}
