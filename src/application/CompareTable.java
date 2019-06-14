package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CompareTable {

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

	public static ObservableList<Record> reportcsv(File f) {

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
				String fileName = csvFile.getName();
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
				
				//SETTING #fields7" DATA BASED ON CONTENTS OF FILENAME
				
				if (fileName.contains("AHT")) {
					String fields7 = ("Ashtead Group plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("ANTO")){
					String fields7 = ("Antofagasta plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);			

					fileData2.add(record);
					break;
				}
				else if (fileName == "BA"){
					String fields7 = "BAE Systems plc";
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);			

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("BATS")){
					String fields7 = ("British American Tobacco plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);			

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("CCH")){
					String fields7 = ("Coca-Cola HBC AG");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("CCL")){
					String fields7 = ("Carnival plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("CNA")){
					String fields7 = ("Centrica plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("CPG")){
					String fields7 = ("Compass Group plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("EXPN")){
					String fields7 = ("Experian plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("EZJ")){
					String fields7 = ("EasyJet plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);				

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("GKN")){
					String fields7 = ("GKN plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);				

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("MDC")){
					String fields7 = ("Mediclinic International plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("PFG")){
					String fields7 = ("Provident Financial plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("PPB")){
					String fields7 = ("Paddy Power Betfair plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);					

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("PRU")){
					String fields7 = ("Prudential plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);


					fileData2.add(record);
					break;
				}
				else if (fileName.contains("PSN")){
					String fields7 = ("Persimmon plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);				

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("RB")){
					String fields7 = ("Reckitt Benckiser Group plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("RDSA")){
					String fields7 = ("Royal Dutch Shell plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("RR")){
					String fields7 = ("Rolls-Royce Holdings plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("SDR")){
					String fields7 = ("Schroders plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("SHP")){
					String fields7 = ("Shire plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("SKY")){
					String fields7 = ("Sky plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);			

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("SSE")){
					String fields7 = ("SSE plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);		

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("STJ")){
					String fields7 = ("St. James's Place plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("TSCO")){
					String fields7 = ("Tesco plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);			

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("TUI")){
					String fields7 = ("TUI AG");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("VOD")){
					String fields7 = ("Vodafone Group plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else if (fileName.contains("WPG")){
					String fields7 = ("Worldpay Group plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
				else {
					String fields7 = ("BAE Systems plc");
					Record record = new Record(fields[0], fields1, fields2,
							fields3, fields4, fields5, fields6, fields7);

					fileData2.add(record);
					break;
				}
			}
		}
		catch (IOException e) {

			e.printStackTrace();

		}
		return fileData2;
	}
}
