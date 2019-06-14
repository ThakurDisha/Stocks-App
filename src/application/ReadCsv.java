package application;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReadCsv {
	public static ObservableList<Record> fileData = FXCollections.observableArrayList();

	public ArrayList<Record> CSVdata = new ArrayList<Record>();

	public ArrayList<Record> getCSVdata(String string) {
		return CSVdata;
	}
	public static ObservableList<Record> getFileData() {
		return fileData;
	}
	public ArrayList<Record> readCsv(String fileName) {
		
		//REDING THE FILE
		String csvFile = "Csv\\" + fileName + ".csv";
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
				String fields7 = stockController.companyname.get(stockController.getCompanyListView().getSelectionModel().getSelectedIndex());
				
				Record record = new Record(fields[0], fields1, fields2,
						fields3, fields4, fields5, fields6, fields7);
				
				
				//ADDING DATA TO FILEDATA OBSERVABLE LIST
				fileData.add(record);
				CSVdata.add(record);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return CSVdata;
	}
}
