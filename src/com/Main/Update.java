package com.Main;

public class Update extends Dispatcher{
	
	private int indexToUpdate;
	private String sectionToUpdate;
	private String detailToUpdate;
	
	public Update(String[] parsedUserInput){
		//The element of the string array will be in the following format
		//0: indexToUpdate, 1: sectionToUpdate, 2: detailToUpdate
		indexToUpdate = Integer.parseInt(parsedUserInput[0]);
		sectionToUpdate = parsedUserInput[1];
		detailToUpdate = parsedUserInput[2];
	}
	
	@Override
	public String execute() {
		switch(sectionToUpdate.toLowerCase()){
		case "task":
			TaskList.get(indexToUpdate).setTask(detailToUpdate);
			break;
		case "location":
			TaskList.get(indexToUpdate).setLocation(detailToUpdate);
			break;
		case "date":
			TaskList.get(indexToUpdate).setDate(detailToUpdate);
			break;
		case "start":
			TaskList.get(indexToUpdate).setStart(detailToUpdate);
			break;
		case "end":
			TaskList.get(indexToUpdate).setEnd(detailToUpdate);
			break;
		case "tag":
			TaskList.get(indexToUpdate).setTag(detailToUpdate);
			break;
		case "notification":
			TaskList.get(indexToUpdate).setNotification(detailToUpdate);
			break;
		default:
			System.out.println("Keyword for the type of detail is invalid.");
		}
				
		return "Task was updated successfully";
	}

}
