package com.Main;

import java.util.ArrayList;

public class Processor {
	TextFileSaver storage = new TextFileSaver();
	
	public Processor(){
		
	}
	
	public String processCommand(String command){
		Parser parser = new Parser(command);
		String commandType = parser.getCommand().getCommandType();
		switch (commandType){
			case "add":
				add(parser);
				return "add";
			case "delete":
				delete(parser);
				return "delete";
			default:
				return "";
		}
	}
	
	private void add(Parser parser){
		storage.readFile();
		ArrayList<Task> TaskList = storage.getTaskData();
		TaskList.add(parser.getCommand().getTask());
		
		storage.saveFile(TaskList);
	}
	

	private void delete(Parser parser){
		int indexForDeletion = parser.getCommand().getDeleteRow();
		ArrayList<Task> TaskList = storage.getTaskData();
		TaskList.remove(indexForDeletion);
		storage.saveFile(TaskList);
	}
	

	public TextFileSaver getStorage(){
		return storage;
	}
}
