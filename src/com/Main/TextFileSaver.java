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
	private ArrayList<String> fileData;
	
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

	public ArrayList<String> getFileData() {
		return fileData;
	}

	public void setFileData(ArrayList<String> fileData) {
		this.fileData = fileData;
	}

	
	public TextFileSaver(){
		fileData = new ArrayList<String>();
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
		fileData = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((temp = br.readLine()) != null){
				fileData.add(temp);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fileName + " successfully read");
	}
	
	public void saveFile(ArrayList<String> fileData){
		this.fileData = fileData;
		FileWriter savefile;
		try {
			String tempSave = "";
			savefile = new FileWriter(fileName);
			for(int i=0; i<fileData.size(); i++){             //Process the array list into a single string
				tempSave = tempSave + fileData.get(i) + "\n";
			}
			savefile.write(tempSave);                            //Write the processed string into the file
			savefile.close();
		} catch (IOException e) {
			System.out.println("Save failed");
			e.printStackTrace();
		}
		
	}
}
