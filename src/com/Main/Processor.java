package com.Main;

public class Processor {
	
	public Processor(String command){
		Parser parser = new Parser(command);
		String commandType = parser.getCommand().getCommandType();
		switch (commandType){
			case "add":
				// call saver
				break;
			case "delete":
				break;
			case "update":
				break;
			default:
		}
		
	}
	
	private void add(){
		
	}
	

	private void delete(){
		
	}
	

	private void update(){
		
	}
}
