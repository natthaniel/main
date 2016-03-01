package com.Main;

public class Task {
	private String taskName = "";
	private String location = "";
	private String start = "";
	private String end = "";
	private String tag = "";
	private String notification = "";
	
	public Task(){
	}

	public String getTaskName() {
		return taskName;
	}

	public String getLocation() {
		return location;
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
