package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class reportCsv {

	private static ArrayList<String> companiesNameList = new ArrayList<String>(Arrays.asList("AHT", "ANTO", "BA", "BATS", "CCH", "CCL", "CNA", "CPG", "EXPN", "EZJ", "GKN", "MDC", "PFG", "PPB",
			"PRU", "PSN", "RB", "RDSA", "RR", "SDR", "SHP", "SKY", "SSE", "STJ", "TSCO", "TUI", "VOD", "WPG"));

	public static ArrayList<String> getCompaniesNameList() {
		return companiesNameList;
	}

	public static ObservableList<Record> fileData2 = FXCollections.observableArrayList();

	public static ArrayList<Record> CSVdata2 = new ArrayList<Record>();

	public ArrayList<Record> getCSVdata(String string) {
		return CSVdata2;
	}

	public static ObservableList<Record> getFileData2() {
		return fileData2;
	}

	public static ArrayList<Record> reportcsv(File f) {
		
		//READING THE FILE
		File csvFile = f;
		String line;
		int iteration = 0 ;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				//TO REMOVE THE FIRST ROW OF CSV FILE
				if(iteration == 0) {
					iteration++;  
					continue;
				}

				String[] fields = line.split(",");
				double fields1 = Double.parseDouble(fields[1]);
				double fields2 = Double.parseDouble(fields[2]);
				double fields3 = Double.parseDouble(fields[3]);
				double fields4 = Double.parseDouble(fields[4]);
				long fields5 =  Long.parseLong(fields[5]);
				double fields6 = Double.parseDouble(fields[6]);
				String fields7 = null;

				Record record = new Record(fields[0], fields1, fields2,
						fields3, fields4, fields5, fields6, fields7);

				
				//ADDING THE DATA TO FILEDATA OBSERVABLELIST
				fileData2.add(record);
				CSVdata2.add(record);

			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return CSVdata2;
	}
}

