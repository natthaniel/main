package com.Main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*
 * This class takes in the original TaskList and a desired time slot as input parameter for its constructor
 * the desired time slot should be in the form of a string array.
 * The 1st element of the string array contain the start time 
 * The 2st element of the string array contain the end time 
 * E.g.: [1000][1400] (looking for a free time slot from 10am to 2pm)
 * The return value is a string, indicating the date of earliest day that can take in the desired time slot.
 * for V0.3, this function will only return the earliest day, NOT considering later available day.
 */
public class SearcherForFreeTimeSlot implements Commander {
		private String currentDate;
		private int currentTime;
		private int startTime;
		private int endTime;
		private ArrayList<Task> TaskList;
		DateFormat formatCurrentDate = new SimpleDateFormat("MM dd yyyy");
		DateFormat formatCurrentTime = new SimpleDateFormat("HHmm");
		Date current;
		
	public SearcherForFreeTimeSlot(String[] parsedUserInput, ArrayList<Task> TaskList) { 
		startTime = Integer.parseInt(parsedUserInput[0]);
		endTime = Integer.parseInt(parsedUserInput[1]);
		
		this.TaskList = TaskList;
	}

	@Override
	public String execute() {
		current = new Date();
		String dateToCompare;
		int startTimeToCompare;
		int endTimeToCompare;
		boolean foundTimeSlot = false;
		boolean foundConflict = false;
		
		while(!foundTimeSlot){
			foundConflict = false;
			currentDate = formatCurrentDate.format(current); //nearest free day 
			currentTime = Integer.parseInt(formatCurrentTime.format(new Date())); //real life time in integer format
			
		for(int i=0; i<TaskList.size(); i++){
			dateToCompare = TaskList.get(i).getDate();
			startTimeToCompare = Integer.parseInt(TaskList.get(i).getStart());
			endTimeToCompare = Integer.parseInt(TaskList.get(i).getEnd());
			
			if(dateToCompare.equals(currentDate)){
				if(startTime>startTimeToCompare && startTime<endTimeToCompare || endTime>startTimeToCompare && endTime<endTimeToCompare){
					foundConflict = true;
					break;
				}
				else if(currentTime > startTimeToCompare){ //To handle first case where there is no task for today but it may already be too late to schedule the task in
					foundConflict = true;
					break;
				}
			}
		}
	
		if(foundConflict){
			//Increase date, set time as zero
			SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy");
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(currentDate));
				c.add(Calendar.DATE, 1);
				currentDate = sdf.format(c.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			currentTime = 0;
		}
		
		else{
			foundTimeSlot = true;
		}
		}
		
		return startTime + " to " + endTime + " is available on " + currentDate;
	}

	@Override
	public String undo() {
		String feedback = "Your last action is searching, which cannot be undone.";
		return feedback;
	}

}
