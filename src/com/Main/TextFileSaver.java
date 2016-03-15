package com.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextFileSaver {

	private File file;
	private String fileName;
	private ArrayList<Task> taskData;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public ArrayList<Task> getTaskData(){
		return taskData;
	}
	
	public void setTaskData(ArrayList<Task> taskData){
		this.taskData = taskData;
	}

	
	public TextFileSaver(){
		taskData = new ArrayList<Task>();
		//Attempt to locate file. Create new file if file does not exist
		fileName = "Record.txt";
		try {
			file = new File(fileName);			
			if(!file.exists()) { 
			    // if file not exist, create a new .txt file with same file name
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.flush();
				fileWriter.close();
				System.out.println(fileName + " does not exists. New .txt file has been created");
			}			
			else{
				//if file exists, read it into the arraylist fileData
				readFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
			}
	}

	public void readFile(){
		String temp;
		file = new File(fileName);
		taskData = new ArrayList<Task>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((temp = br.readLine()) != null){
				Task tempTask = new Task();
				addToTaskList(temp, tempTask);
			}	
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fileName + " successfully read");
	}

	/*Split the each line to 6 different segments. Each segment is separated in the .txt file by ~~. Add each
	 * segment to tempTask for create a proper Task and add it to the Task ArrayList (taskData)*/
	private void addToTaskList(String temp, Task tempTask) {
		String[] _temp = new String[7];
		_temp = temp.split("~~", -1);
		tempTask.setTask(_temp[0]);
		tempTask.setLocation(_temp[1]);
		tempTask.setDate(_temp[2]);
		tempTask.setStart(_temp[3]);
		tempTask.setEnd(_temp[4]);
		tempTask.setTag(_temp[5]);
		tempTask.setNotification(_temp[6]);
		taskData.add(tempTask);
		_temp = null;
	}
	
	public void saveFile(ArrayList<Task> taskData){
		this.taskData = taskData;
		FileWriter savefile;
		try {
			String tempSave = "";
			Task tempTaskForSaving = new Task();
			String[] taskToString = new String[7];
			savefile = new FileWriter(fileName);
			for(int i=0; i<taskData.size(); i++){             //Process the task list into a single string
				tempTaskForSaving = taskData.get(i);
				convertTaskToString(tempTaskForSaving, taskToString);
				tempSave = processIntoSingleStringForSaving(tempSave,
						taskToString);
			}
			savefile.write(tempSave);                            //Write the processed string into the file
			savefile.close();
		} catch (IOException e) {
			System.out.println("Save failed");
			e.printStackTrace();
		}
		
	}

	/*Convert the string arrays into a single string with proper formatting before saving*/
	private String processIntoSingleStringForSaving(String tempSave,
			String[] taskToString) {
		tempSave = tempSave + taskToString[0] + "~~" + taskToString[1] + "~~" + taskToString[2] + "~~"+ taskToString[3] + "~~"+ taskToString[4] + "~~"+ taskToString[5]+ "~~" + taskToString[6] + "\n";
		return tempSave;
	}
	
	/*Convert the task into a string array*/
	private void convertTaskToString(Task tempTaskForSaving,
			String[] taskToString) {
		taskToString[0] = tempTaskForSaving.getTaskName();
		taskToString[1] = tempTaskForSaving.getLocation();
		taskToString[2] = tempTaskForSaving.getDate();
		taskToString[3] = tempTaskForSaving.getStart();
		taskToString[4] = tempTaskForSaving.getEnd();
		taskToString[5] = tempTaskForSaving.getTag();
		taskToString[6] = tempTaskForSaving.getNotification();
	}
}
