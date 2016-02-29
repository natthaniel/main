package com.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextFileSaver {

	File file;
	String fileName;
	ArrayList<String> fileData;
	
	public TextFileSaver(String category){
		fileName = category+".txt";
		try {
			file = new File(category+".txt");			
			if(!file.exists()) { 
			    // if file not exist, create the file
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.flush();
				fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeOneRow(int index) throws IOException{
		List<String> fileContent = Files.readAllLines(Paths.get(fileName));
		fileContent.remove(index);
		for (String line : fileContent) {
		    
		}
	}
}
