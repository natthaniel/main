package com.Test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.Main.Task;
import com.Main.TextFileSaver;

public class TextFileSaverTest {
	
	//Test processIntoSingleStringForSaving
	@Test
	public void processIntoSingleStringForSavingTest() {
		TextFileSaver storage = new TextFileSaver();
		String result = new String();
		String[] toBeProcessed = new String[7];
		
		toBeProcessed[0]="Task Name";
		toBeProcessed[1]="Location";
		toBeProcessed[2]="Date";
		toBeProcessed[3]="Start";
		toBeProcessed[4]="End";
		toBeProcessed[5]="Tag";
		toBeProcessed[6]="Notification";
		
		result = storage.processIntoSingleStringForSaving(result, toBeProcessed);
		assertEquals(result, "Task Name~~Location~~Date~~Start~~End~~Tag~~Notification\n");
	}

	//Test convertTaskToString
	@Test
	public void convertTaskToStringTest() {
		TextFileSaver storage = new TextFileSaver();
		Task toBeProcessed = new Task();
		String[] temp = new String[7];
		
		toBeProcessed.setTask("Task Name");
		toBeProcessed.setLocation("Location");
		toBeProcessed.setDate("Date");
		toBeProcessed.setStart("Start");
		toBeProcessed.setEnd("End");
		toBeProcessed.setTag("Tag");
		toBeProcessed.setNotification("Notification");
		
		storage.convertTaskToString(toBeProcessed, temp);
		assertEquals(temp[0], "Task Name");
		assertEquals(temp[1], "Location");
		assertEquals(temp[2], "Date");
		assertEquals(temp[3], "Start");
		assertEquals(temp[4], "End");
		assertEquals(temp[5], "Tag");
		assertEquals(temp[6], "Notification");
		
	}

	
	//Test addToTaskList
	@Test
	public void addToTaskListTest() {
		TextFileSaver storage = new TextFileSaver();
		Task toBeFilled = new Task();
		String _toBeAdded = "Task Name~~Location~~Date~~Start~~End~~Tag~~Notification\n";
		int sizeOfTaskList = storage.getTaskData().size();
		
		storage.addToTaskList(_toBeAdded, toBeFilled, 0);
		sizeOfTaskList++;
		
		assertEquals(storage.getTaskData().size(), sizeOfTaskList);
	}

}
