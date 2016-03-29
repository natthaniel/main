package com.Main;

import java.util.ArrayList;
/*
 * This class will take in a string of Keyword.
 * and it will search from the TaskList for desired Tasks.
 * Then it will get an arrayList of Task objects fulfilling the requirement.
 * Before return, it will call the Display Class with the arrayList as the parameter.
 * The Display Object will return a string to the processor for display.
 */
public class SearcherByKeyword implements Commander {
	private String keyWord;
	private String matchDetails;
	private ArrayList<Task> TaskList;

	public SearcherByKeyword(String[] parsedUserInput, ArrayList<Task> TaskList){
		//The 1st element in the string array is the keyword for search
		keyWord = parsedUserInput[0];
		this.TaskList = TaskList;
	}

	@Override
	public String execute() {
		if (TaskList.size() == 0) {
			return "TodoList is empty";
		} else {
			//keyWord = ;
			keyWord = keyWord.trim();

			for (int i = 0; i < TaskList.size(); i++) {
				if ((TaskList).contains(keyWord.toUpperCase())) {
					return "The matching details are as follows: " + matchDetails;
				}
			}

		}
		return matchDetails;
	}
}