package com.Main;

public class Delete extends Dispatcher{
	private int indexToDelete;
	
	public Delete(String[] parsedUserInput){
		//The first element in the array is the index to be deleted
		indexToDelete = Integer.parseInt(parsedUserInput[0]);
	}
	@Override
	public String execute() {
		try{
		//assert(indexToDelete >=0);
		TaskList.remove(indexToDelete);
		} catch (Exception e){
			e.printStackTrace();
			return e.toString();
		}
		
		return "Task deleted successfully";
	}

}
