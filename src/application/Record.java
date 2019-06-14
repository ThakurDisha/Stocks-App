package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Record {
	
	/* How to read csv data and populate tableview learnt from this site:
	 * http://java-buddy.blogspot.com/2016/06/read-csv-file-display-in-javafx.html
	 */
	
	
	//SETTING THE PROPERTY TYPE OF COLUMNS IN CSV FILE
	private SimpleStringProperty date;
	private SimpleDoubleProperty open;
	private SimpleDoubleProperty high;
	private SimpleDoubleProperty low;
	private SimpleDoubleProperty close;
	private SimpleLongProperty volume;
	private SimpleDoubleProperty adjClose;
	private SimpleStringProperty companyName;

	public String getDate() {
		return date.get();
	}

	public double getOpen() {
		return open.get();
	}

	public double getHigh() {
		return high.get();
	}

	public double getLow() {
		return low.get();
	}

	public double getClose() {
		return close.get();
	}

	public long getVolume() {
		return volume.get();
	}

	public double getAdjClose() {
		return adjClose.get();
	}

	public String getCompanyName() {
		return companyName.get();
	}

	
	//CONSTRUCTOR
	Record(String date, Double open, Double high, Double low,
			Double close, Long volume, Double adjClose, String companyName){

		this.date = new SimpleStringProperty(date);
		this.open = new SimpleDoubleProperty(open);
		this.high = new SimpleDoubleProperty(high);
		this.low = new SimpleDoubleProperty(low);
		this.close = new SimpleDoubleProperty(close);
		this.volume = new SimpleLongProperty(volume);
		this.adjClose = new SimpleDoubleProperty(adjClose);
		this.companyName = new SimpleStringProperty(companyName);
	}
}

