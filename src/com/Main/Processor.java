package com.Main;

import java.util.ArrayList;

public class Processor {
	TextFileSaver saver = new TextFileSaver();
	public Processor(String command){
		Parser parser = new Parser(command);
		String commandType = parser.getCommand().getCommandType();
		switch (commandType){
			case "add":
				add(parser);
				break;
			case "delete":
				delete(parser);
				break;
			case "update":
				update();
				break;
			default:
		}
		
	}
	
	private void add(Parser parser){
		ArrayList<String> fileDataList = saver.getFileData();
		fileDataList.add(parser.getCommand().getTask().getTaskName());			
		saver.saveFile(fileDataList);
	}
	

	private void delete(Parser parser){
		int indexForDeletion = parser.getCommand().getDeleteRow();
		ArrayList<String> fileDataList = saver.getFileData();
		fileDataList.remove(indexForDeletion);
		saver.saveFile(fileDataList);
	}
	

	private void update(){
		
	}
	
	private void view(){
		
	}
}
