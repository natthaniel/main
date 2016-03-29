package com.Main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


public class Task {
	private String taskName = "";
	private String date = ""; //"MM dd yy"
	private String location = "";
	private String start = "";//"HHmm"
	private String end = "";//"HHmm"
	private String tag = "";
	private String notification = "";
	private GregorianCalendar startCal = new GregorianCalendar();
	private GregorianCalendar endCal = new GregorianCalendar();
		
	public void setCalendar(){
				
		DateFormat formatter = new SimpleDateFormat("MM dd yy HHmm");
		Date date = new Date();
		try {
			date = formatter.parse(getDate() + getStart()); // String to Date object
		} catch (ParseException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		startCal.setTime(date);
		
		try {
			date = formatter.parse(getDate() + getEnd()); // String to Date object
		} catch (ParseException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		endCal.setTime(date);
	}
	
	public Task(){
	}

	public String getTaskName() {
		return taskName;
	}

	public String getLocation() {
		return location;
	}
	public String getDate(){
		return date;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public String getTag() {
		return tag;
	}

	public String getNotification() {
		return notification;
	}

	public void setTask(String taskName) {
		this.taskName = taskName;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
	
	
}
