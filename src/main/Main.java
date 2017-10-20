package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		sortFiles();
	}
	
	public static void sortFiles() {
		//Load in list of files
		List<String> benign = new ArrayList<String>();
		List<String> malware = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Colby\\Desktop\\Test\\repackaging_pairs.txt"));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] columns = line.split(",");
				benign.add(columns[0] + ".apk");
				malware.add(columns[1]  + ".apk");
			}
			br.close();	
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR");
		}
		//Start sorting loops
		//Benign
		FileOperator FOB = new FileOperator("C:\\Users\\colby\\Desktop\\TEST\\SOURCE",
				"C:\\Users\\colby\\Desktop\\TEST\\OUTPUT\\uninfected");
		for(File i: FOB.sourceFiles) {
			System.out.println(i.getName());
			if(benign.contains(i.getName())) {
				FOB.copyFileToOutput(i);
			}
		}
		
		//Malware
		FileOperator FOM = new FileOperator("C:\\Users\\colby\\Desktop\\TEST\\SOURCE",
				"C:\\Users\\colby\\Desktop\\TEST\\OUTPUT\\infected");
		for(File i: FOM.sourceFiles) {
			if(malware.contains(i.getName())) {
				FOM.copyFileToOutput(i);
			}
		}
	}

}
