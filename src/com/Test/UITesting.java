package com.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;  

import com.GUI.HomeFrame;
import com.Main.Adder;

public class UITesting {
	
	@Test
	public void executeTest() {
		HomeFrame homeFrame = new HomeFrame();
		String array[] = {"Task added successfully"};
		List<String> expectedList = Arrays.asList(array);
		homeFrame.taskListInitialize();
		assertEquals(expectedList, homeFrame.commandEntered("add task @ RC4 on 11 02 2016 from 1100 ~ 1200")); 
		//Testing under the condition that when TaskList is empty.	
	}
}
