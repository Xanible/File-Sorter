package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

public class FileOperator {
	
	//Variables
	File sourceDir;
	File outputDir;
	File[] sourceFiles;
	File[] outputFiles;
	
	//Constructor
	public FileOperator(String sourceBaseDir, String outputBaseDir){
		sourceDir = new File(sourceBaseDir);
		outputDir = new File(outputBaseDir);
		sourceFiles = sourceDir.listFiles();
		outputFiles = outputDir.listFiles();
	}
	
	//Method
	public void moveFileToOutput(File f) {
		try {
			File output = new File(outputDir.toPath() + File.separator + f.getName());
			Files.move(f.toPath(), output.toPath());
		} catch (IOException e) {
			System.out.println("File " + f.getName() + " could not be moved");
			e.printStackTrace();
		}
	}
	
	public void copyFileToOutput(File f) {
		try {
			File output = new File(outputDir.toPath() + File.separator + f.getName());
			Files.copy(f.toPath(), output.toPath());
		} catch (FileAlreadyExistsException e) {
			System.out.println("File " + f.getName() + " already exists!");
		} catch (IOException e) {
			System.out.println("File " + f.getName() + " could not be copied");
			e.printStackTrace();
		}
	}
}
