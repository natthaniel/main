package com.Main;

import java.util.ArrayList;

public class Processor {
	TextFileSaver saver = new TextFileSaver();
	
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
		saver.readFile();
		ArrayList<String> fileDataList = saver.getFileData();
		String newTaskName = parser.getCommand().getTask().getTaskName();
		fileDataList.add(newTaskName);			
		saver.saveFile(fileDataList);
	}
	

	private void delete(Parser parser){
		int indexForDeletion = parser.getCommand().getDeleteRow();
		ArrayList<String> fileDataList = saver.getFileData();
		fileDataList.remove(indexForDeletion);
		saver.saveFile(fileDataList);
	}
	

	public TextFileSaver getSaver(){
		return saver;
	}
	
	private void view(){
		
	}
}
