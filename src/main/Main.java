package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//TEST
		FileOperator FO = new FileOperator("C:\\Users\\colbyAdmin\\Desktop\\TEST\\SOURCE",
				"C:\\Users\\colbyAdmin\\Desktop\\TEST\\OUTPUT");
		
		for(int i = 0; i < FO.sourceFiles.length; i++) {
			
		}
		for(File i: FO.sourceFiles) {
			FO.copyFileToOutput(i);
		}
	}
	
	public static void sortFiles() {
		//Load in list of files
		List<String> benign = new ArrayList<String>();
		List<String> malware = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ColbyAdmin\\Desktop\\Test\\repackaging_pairs.txt"));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] columns = line.split(",");
				benign.add(columns[0]);
				malware.add(columns[1]);
			}
			br.close();	
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR");
		}
		
		//Start sorting loops
		//Benign
		FileOperator FOB = new FileOperator("C:\\Users\\colbyAdmin\\Desktop\\TEST\\SOURCE",
				"C:\\Users\\colbyAdmin\\Desktop\\TEST\\OUTPUT\\uninfected");
		for(File i: FOB.sourceFiles) {
			if(benign.contains(i.getName())) {
				
			}
		}
		
		//Malware
		FileOperator FOM = new FileOperator("C:\\Users\\colbyAdmin\\Desktop\\TEST\\SOURCE",
				"C:\\Users\\colbyAdmin\\Desktop\\TEST\\OUTPUT\\infected");
		for(File i: FOM.sourceFiles) {
			FO.copyFileToOutput(i);
		}
	}

}
