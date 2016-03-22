package com.Main;

import java.util.ArrayList;

public class Searcher implements Commander {
	private String keyWord;
	private String matchDetails;
	private ArrayList<Task> TaskList;

	public Searcher(String[] parsedUserInput, ArrayList<Task> TaskList){
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