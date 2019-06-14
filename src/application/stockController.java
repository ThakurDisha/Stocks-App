package application;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.FileChooser;


//CONTROLLER CLASS
public class stockController {

	private static TableView<Record> tableView = new TableView<>();
	private static TableView<Record> compareTableView = new TableView<>();
	public static TableView<Record> getCompareTableView() {
		return compareTableView;
	}

	private static ListView<String> companyListView = new ListView<String>();
	private static ArrayList<String> companiesS = new ArrayList<String>();
	private static ArrayList<String> companiesN = new ArrayList<String>();
	private static ArrayList<Record> companyData = new ArrayList<Record>();
	private static ArrayList<Record> companyData2 = new ArrayList<Record>();

	static String text;
	static String text1;
	static Writer writer = null;

	static Label companyName = new Label();
	static Label companySymbol = new Label();
	static Label closeSymbol = new Label();
	static Label prevCloseSymbol = new Label();
	static Label changeSymbol = new Label();
	static Label arrowSymbol = new Label(); 

	static StackPane sp = new StackPane();
	AnchorPane ap = new AnchorPane();

	static Button butn = new Button();
	static Button butn2 = new Button();
	static File file = new File("");
	static File file2 = new File("");
	static Label reportText = new Label();
	static Label reportText2 = new Label();


	public static CategoryAxis xAxis_main = new CategoryAxis();
	public static NumberAxis yAxis_main = new NumberAxis();
	public static CategoryAxis xAxis = new CategoryAxis();
	public static NumberAxis yAxis = new NumberAxis();
	public static CategoryAxis xAxis1 = new CategoryAxis();
	public static NumberAxis yAxis1 = new NumberAxis();
	public static CategoryAxis xAxis2 = new CategoryAxis();
	public static NumberAxis yAxis2 = new NumberAxis();
	public static CategoryAxis xAxis3 = new CategoryAxis();
	public static NumberAxis yAxis3 = new NumberAxis();
	public static CategoryAxis xAxis4 = new CategoryAxis();
	public static NumberAxis yAxis4 = new NumberAxis();
	public static CategoryAxis xAxis5 = new CategoryAxis();
	public static NumberAxis yAxis5 = new NumberAxis();
	public static CategoryAxis xAxis6 = new CategoryAxis();
	public static NumberAxis yAxis6 = new NumberAxis();

	private static AreaChart<String, Number> StockChart = new AreaChart<String,Number>(xAxis_main,yAxis_main);
	private static AreaChart<String, Number> LowChart = new AreaChart<String,Number>(xAxis,yAxis);
	private static AreaChart<String, Number> HighChart = new AreaChart<String,Number>(xAxis1,yAxis1);
	private static AreaChart<String, Number> OpenChart = new AreaChart<String,Number>(xAxis2,yAxis2);
	private static AreaChart<String, Number> CloseChart = new AreaChart<String,Number>(xAxis3,yAxis3);
	private static AreaChart<String, Number> VolumeChart = new AreaChart<String,Number>(xAxis4,yAxis4);
	private static AreaChart<String, Number> adjCloseChart = new AreaChart<String,Number>(xAxis5,yAxis5);


	public static CategoryAxis xAxis7 = new CategoryAxis();
	public static NumberAxis yAxis7 = new NumberAxis();
	public static CategoryAxis xAxis8 = new CategoryAxis();
	public static NumberAxis yAxis8 = new NumberAxis();
	public static CategoryAxis xAxis9 = new CategoryAxis();
	public static NumberAxis yAxis9 = new NumberAxis();
	public static CategoryAxis xAxis10 = new CategoryAxis();
	public static NumberAxis yAxis10 = new NumberAxis();
	public static CategoryAxis xAxis11 = new CategoryAxis();
	public static NumberAxis yAxis11 = new NumberAxis();
	public static CategoryAxis xAxis12 = new CategoryAxis();
	public static NumberAxis yAxis12 = new NumberAxis();


	private static AreaChart<String, Number> LowChart2 = new AreaChart<String,Number>(xAxis7,yAxis7);
	private static AreaChart<String, Number> HighChart2 = new AreaChart<String,Number>(xAxis8,yAxis8);
	private static AreaChart<String, Number> OpenChart2 = new AreaChart<String,Number>(xAxis9,yAxis9);
	private static AreaChart<String, Number> CloseChart2 = new AreaChart<String,Number>(xAxis10,yAxis10);
	private static AreaChart<String, Number> VolumeChart2 = new AreaChart<String,Number>(xAxis11,yAxis11);
	private static AreaChart<String, Number> adjCloseChart2 = new AreaChart<String,Number>(xAxis12,yAxis12);


	public static CategoryAxis xAxis13 = new CategoryAxis();
	public static NumberAxis yAxis13 = new NumberAxis();
	public static CategoryAxis xAxis14 = new CategoryAxis();
	public static NumberAxis yAxis14 = new NumberAxis();
	public static CategoryAxis xAxis15 = new CategoryAxis();
	public static NumberAxis yAxis15 = new NumberAxis();
	public static CategoryAxis xAxis16 = new CategoryAxis();
	public static NumberAxis yAxis16 = new NumberAxis();
	public static CategoryAxis xAxis17 = new CategoryAxis();
	public static NumberAxis yAxis17 = new NumberAxis();
	public static CategoryAxis xAxis18 = new CategoryAxis();
	public static NumberAxis yAxis18 = new NumberAxis();


	private static AreaChart<String, Number> LowChart3 = new AreaChart<String,Number>(xAxis13,yAxis13);
	private static AreaChart<String, Number> HighChart3 = new AreaChart<String,Number>(xAxis14,yAxis14);
	private static AreaChart<String, Number> OpenChart3 = new AreaChart<String,Number>(xAxis15,yAxis15);
	private static AreaChart<String, Number> CloseChart3 = new AreaChart<String,Number>(xAxis16,yAxis16);
	private static AreaChart<String, Number> VolumeChart3 = new AreaChart<String,Number>(xAxis17,yAxis17);
	private static AreaChart<String, Number> adjCloseChart3 = new AreaChart<String,Number>(xAxis18,yAxis18);


	static ReadCsv readcsv = new ReadCsv();
	static ReadCsv readcsv2 = new ReadCsv();
	static reportCsv reportData = new reportCsv();
	static CompareTable compare = new CompareTable();


	public static  ObservableList<String> company = FXCollections.observableArrayList("AHT",
			"ANTO","BA","BATS",
			"CCH","CCL","CNA","CPG",
			"EXPN","EZJ",
			"GKN",
			"MDC",
			"PFG","PPB","PRU","PSN",
			"RB","RDSA","RR",
			"SDR","SHP","SKY","SSE","STJ",
			"TSCO","TUI",
			"VOD",
			"WPG");

	public static  ObservableList<String> companyname = FXCollections.observableArrayList("Ashtead Group plc", "Antofagasta plc",
			"BAE Systems plc", "British American Tobacco plc",
			"Coca-Cola HBC AG", "Carnival plc", "Centrica plc",  
			"Compass Group plc", "Experian plc", "EasyJet plc", "GKN plc", 
			"Mediclinic International plc", "Provident Financial plc","Paddy Power Betfair plc",
			"Prudential plc", "Persimmon plc", "Reckitt Benckiser Group plc", "Royal Dutch Shell plc",
			"Rolls-Royce Holdings plc", "Schroders plc", "Shire plc", "Sky plc",
			"SSE plc", "St. James's Place plc", "Tesco plc", "TUI AG", "Vodafone Group plc",
			"Worldpay Group plc");

	static ObservableList<String> views = 
			FXCollections.observableArrayList(
					"Tabular Data",
					"Graphical Data",
					"Report",
					"Compare Stocks"
					);

	final static ComboBox<String> comboBox = new ComboBox<String>(views);

	public static ComboBox<String> getCombobox() {
		return comboBox;
	}

	final static TabPane main_tabpane = new TabPane();
	final static TabPane tabpane1 = new TabPane();
	final static TabPane tabpane2 = new TabPane();
	final static TabPane tabpane3 = new TabPane();
	final static TabPane tabpane4 = new TabPane();
	final static TabPane tabpane5 = new TabPane();
	final static TabPane tabpane6 = new TabPane();
	final static TabPane Infotabpane = new TabPane(); 
	final static TabPane Reporttabpane = new TabPane();
	final static TabPane comparetabpane = new TabPane();



	public static TableView<Record> getTableView() {
		return tableView;
	}

	public static ListView<String> getCompanyListView() {
		return companyListView;
	}

	public static void setTableView(TableView<Record> tableView) {
		stockController.tableView = tableView;
	}





	//CREATE TABLE METHOD
	
	@SuppressWarnings("unchecked")
	public static void createTable(){
		
		//SETTING TABLE WIDTH
		getTableView().setPrefWidth(510);
		getTableView().setPlaceholder(new Label("Press Over Company Name in the list to view Data"));
		
		TableColumn columnF1 = new TableColumn("Date");
		columnF1.setCellValueFactory(
				new PropertyValueFactory<>("date"));
		columnF1.setPrefWidth(getTableView().getPrefWidth() / 7);

		TableColumn columnF2 = new TableColumn("Open");
		columnF2.setCellValueFactory(
				new PropertyValueFactory<>("open"));
		columnF2.setPrefWidth(getTableView().getPrefWidth() / 7);

		TableColumn columnF3 = new TableColumn("High");
		columnF3.setCellValueFactory(
				new PropertyValueFactory<>("high"));
		columnF3.setPrefWidth(getTableView().getPrefWidth() / 7);

		TableColumn columnF4 = new TableColumn("Low");
		columnF4.setCellValueFactory(
				new PropertyValueFactory<>("low"));
		columnF4.setPrefWidth(getTableView().getPrefWidth() / 7);

		TableColumn columnF5 = new TableColumn("Close");
		columnF5.setCellValueFactory(
				new PropertyValueFactory<>("close"));
		columnF5.setPrefWidth(getTableView().getPrefWidth() / 7);

		TableColumn columnF6 = new TableColumn("Volum");
		columnF6.setCellValueFactory(
				new PropertyValueFactory<>("volume"));
		columnF6.setPrefWidth(getTableView().getPrefWidth() / 7);

		TableColumn columnF7 = new TableColumn("Adj Close");
		columnF7.setCellValueFactory(
				new PropertyValueFactory<>("adjClose"));
		columnF7.setPrefWidth(getTableView().getPrefWidth() / 7);
		
		//POPULATING TABLEVIEW WITH DATA IN THE COLUMNS
		getTableView().getColumns().addAll(
				columnF1, columnF2, columnF3, columnF4, columnF5, columnF6, columnF7);

	}


	// CREATE CREATE TABLE TAB PANE
	public static void generalInfoTabPane() {

		AnchorPane pane = new AnchorPane();
		AnchorPane pane2 = new AnchorPane();
		
		//SETTING THE DIMENSIONS OF ELEMENTS IN ANCHORPANE//
		
		AnchorPane.setTopAnchor(companyName, 50.0);
		AnchorPane.setLeftAnchor(companyName, 530.0);
		AnchorPane.setRightAnchor(companyName, 100.0);
		AnchorPane.setBottomAnchor(companyName, 100.0);

		AnchorPane.setTopAnchor(companySymbol, 90.0);
		AnchorPane.setLeftAnchor(companySymbol, 530.0);
		AnchorPane.setRightAnchor(companySymbol, 100.0);
		AnchorPane.setBottomAnchor(companySymbol, 70.0);

		AnchorPane.setTopAnchor(closeSymbol, 130.0);
		AnchorPane.setLeftAnchor(closeSymbol, 530.0);
		AnchorPane.setRightAnchor(closeSymbol, 100.0);
		AnchorPane.setBottomAnchor(closeSymbol, 50.0);

		AnchorPane.setTopAnchor(prevCloseSymbol, 170.0);
		AnchorPane.setLeftAnchor(prevCloseSymbol, 530.0);
		AnchorPane.setRightAnchor(prevCloseSymbol, 100.0);
		AnchorPane.setBottomAnchor(prevCloseSymbol, 30.0);

		AnchorPane.setTopAnchor(changeSymbol, 210.0);
		AnchorPane.setLeftAnchor(changeSymbol, 530.0);
		AnchorPane.setRightAnchor(changeSymbol, 100.0);
		AnchorPane.setBottomAnchor(changeSymbol, 10.0);
		
		//ADDING ALL ELEMENTS TO ANCHORPANE FOR DISPLAY
		pane.getChildren().addAll(companyName, companySymbol,closeSymbol, prevCloseSymbol, changeSymbol);
		Tab tabInfo1 = new Tab("Stocks Table");
		pane2.getChildren().addAll(getTableView(), pane);
		//ADDING ANCHORPANE TO TABPANE
		tabInfo1.setContent(pane2);
		Infotabpane.getTabs().addAll(tabInfo1);
		//TAB CLOSING PROPERTY IS MADE UNAVAILABLE
		Infotabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

	}


	//CREATE COMPARE STOCKS TABLE

	@SuppressWarnings("unchecked")
	public static void createCompareTable(){
		
		//SETTING TABLE WIDTH
		getCompareTableView().setPrefWidth(840);
		
		TableColumn columnF1 = new TableColumn("Company Name");
		columnF1.setCellValueFactory(
				new PropertyValueFactory<>("companyName"));
		columnF1.setPrefWidth(getCompareTableView().getPrefWidth() / 7);

		TableColumn columnF2 = new TableColumn("Open");
		columnF2.setCellValueFactory(
				new PropertyValueFactory<>("open"));
		columnF2.setPrefWidth(getCompareTableView().getPrefWidth() / 7);

		TableColumn columnF3 = new TableColumn("High");
		columnF3.setCellValueFactory(
				new PropertyValueFactory<>("high"));
		columnF3.setPrefWidth(getCompareTableView().getPrefWidth() / 7);

		TableColumn columnF4 = new TableColumn("Low");
		columnF4.setCellValueFactory(
				new PropertyValueFactory<>("low"));
		columnF4.setPrefWidth(getCompareTableView().getPrefWidth() / 7);

		TableColumn columnF5 = new TableColumn("Close");
		columnF5.setCellValueFactory(
				new PropertyValueFactory<>("close"));
		columnF5.setPrefWidth(getCompareTableView().getPrefWidth() / 7);

		TableColumn columnF6 = new TableColumn("Volume");
		columnF6.setCellValueFactory(
				new PropertyValueFactory<>("volume"));
		columnF6.setPrefWidth(getCompareTableView().getPrefWidth() / 7);

		TableColumn columnF7 = new TableColumn("Adj Close");
		columnF7.setCellValueFactory(
				new PropertyValueFactory<>("adjClose"));
		columnF7.setPrefWidth(getCompareTableView().getPrefWidth() / 7);

		//ADDING ALL COLUMNS DATA TO TABLE
		getCompareTableView().getColumns().addAll(
				columnF1, columnF2, columnF3, columnF4, columnF5, columnF6, columnF7);

	}



	//CREATE COMPARE STOCKS TAB PANE

	public static void CreatecompareTabPane() {

		AnchorPane pane3 = new AnchorPane();
		Tab tabcompare = new Tab("All Company Stocks Table");
        //ADDING COMPARE TABLE TO ANCHORPANE
		pane3.getChildren().addAll(getCompareTableView());
		//ADDING ANCHORPANE TO TBAPANE
		tabcompare.setContent(pane3);
		comparetabpane.getTabs().addAll(tabcompare);
		//TAB CLOSING PROPERTY IS MADE UNAVAILABLE
		comparetabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
	}




	// CREATE GRAPH METHOD
	public static void createGraph() {
		
		//SETTING THE GRAPH TO START FROM ACTUAL RANGE AND NOT FROM ZERO ON Y AXIS
		yAxis.setForceZeroInRange(false);
		yAxis1.setForceZeroInRange(false);
		yAxis2.setForceZeroInRange(false);
		yAxis3.setForceZeroInRange(false);
		yAxis4.setForceZeroInRange(false);
		yAxis5.setForceZeroInRange(false);
		yAxis6.setForceZeroInRange(false);
		
		//SETTING CHART TITLE
		LowChart.setTitle("Low Price");
		OpenChart.setTitle("Open Price");
		CloseChart.setTitle("Close Price");
		HighChart.setTitle("High Price");
		VolumeChart.setTitle("Volume Price");
		adjCloseChart.setTitle("Adjacent Close Price");
		
		//DECLARING XYCHART SERIES NAME
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series4 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series5 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series6 = new XYChart.Series<String, Number>();
		
		//CREATE ARRAYLIST TO STORE CSV DATA
		ArrayList<String> dateStrings = new ArrayList<String>();
		ArrayList<Double> openValue = new ArrayList<Double>();
		ArrayList<Double> lowValue = new ArrayList<Double>();
		ArrayList<Double> highValue = new ArrayList<Double>();
		ArrayList<Double> closeValue = new ArrayList<Double>();
		ArrayList<Double> volumeValue = new ArrayList<Double>();
		ArrayList<Double> adjCloseValue = new ArrayList<Double>();
		
		//READ CSV FILE AND STORE ALL THE DATES IN dateStrings ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			String dateS = ReadCsv.getFileData().get(i).getDate();
			dateStrings.add(dateS);

		}
		
		//READ CSV FILE AND STORE ALL THE OPEN PRICE IN openValue ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double open = ReadCsv.getFileData().get(i).getOpen();
			openValue.add(open);
		}
		
		//READ CSV FILE AND STORE ALL THE LOW PRICE IN lowValue ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double low = ReadCsv.getFileData().get(i).getLow();
			lowValue.add(low);
		}

		//READ CSV FILE AND STORE ALL THE HIGH PRICE IN highValue ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double high = ReadCsv.getFileData().get(i).getHigh();
			highValue.add(high);
		}
		
		//READ CSV FILE AND STORE ALL THE CLOSE PRICE IN closeValue ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double close = ReadCsv.getFileData().get(i).getClose();
			closeValue.add(close);
		}
		
		//READ CSV FILE AND STORE ALL THE VOLUME VALUES IN volumeValue ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double volume = ReadCsv.getFileData().get(i).getVolume();
			volumeValue.add(volume);
		}
		
		//READ CSV FILE AND STORE ALL THE ADJACENT CLOSE PRICE IN adjCloseValue ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double adjClose = ReadCsv.getFileData().get(i).getAdjClose();
			adjCloseValue.add(adjClose);
		}

		for (int i=0; i < dateStrings.size(); i++) {
			series1.getData().add(new XYChart.Data<String, Number>(dateStrings.get(i), openValue.get(i)));
			series2.getData().add(new XYChart.Data<String, Number>(dateStrings.get(i), lowValue.get(i)));
			series3.getData().add(new XYChart.Data<String, Number>(dateStrings.get(i), highValue.get(i)));
			series4.getData().add(new XYChart.Data<String, Number>(dateStrings.get(i), closeValue.get(i)));
			series5.getData().add(new XYChart.Data<String, Number>(dateStrings.get(i), volumeValue.get(i)));
			series6.getData().add(new XYChart.Data<String, Number>(dateStrings.get(i), adjCloseValue.get(i)));
		}
		
		//ADD ALL THE DATA TO THEIR RESPECTIVE CHARTS
		OpenChart.getData().clear();
		OpenChart.getData().add(series1);

		LowChart.getData().clear();
		LowChart.getData().add(series2);

		HighChart.getData().clear();
		HighChart.getData().add(series3);

		CloseChart.getData().clear();
		CloseChart.getData().add(series4);

		VolumeChart.getData().clear();
		VolumeChart.getData().add(series5);

		adjCloseChart.getData().clear();
		adjCloseChart.getData().add(series6);

	}




	// CREATE YEARLY GRAPH METHOD

	public static void createYearlyGraph() {
		
		//SETTING PREFFERED WIDTH OF ALL CHARTS
		
		OpenChart2.setPrefWidth(400);
		OpenChart3.setPrefWidth(300);

		HighChart2.setPrefWidth(400);
		HighChart3.setPrefWidth(300);

		LowChart2.setPrefWidth(400);
		LowChart3.setPrefWidth(300);

		CloseChart2.setPrefWidth(400);
		CloseChart3.setPrefWidth(300);

		VolumeChart2.setPrefWidth(400);
		VolumeChart3.setPrefWidth(300);

		adjCloseChart2.setPrefWidth(400);
		adjCloseChart3.setPrefWidth(300);
		
		
		//SETTING THE GRAPHS TO START FROM ACTUAL RANGE ON Y AXIS
		
		yAxis7.setForceZeroInRange(false);
		yAxis8.setForceZeroInRange(false);
		yAxis9.setForceZeroInRange(false);
		yAxis10.setForceZeroInRange(false);
		yAxis11.setForceZeroInRange(false);
		yAxis12.setForceZeroInRange(false);

		yAxis13.setForceZeroInRange(false);
		yAxis14.setForceZeroInRange(false);
		yAxis15.setForceZeroInRange(false);
		yAxis16.setForceZeroInRange(false);
		yAxis17.setForceZeroInRange(false);
		yAxis18.setForceZeroInRange(false);

		
		//DECLARING XYCHART SERIES NAME
		XYChart.Series<String, Number> series7 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series8 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series9 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series10 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series11 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series12 = new XYChart.Series<String, Number>();
		
		
		ArrayList<String> dateStrings2 = new ArrayList<String>();
		ArrayList<Double> openValue2 = new ArrayList<Double>();
		ArrayList<Double> lowValue2 = new ArrayList<Double>();
		ArrayList<Double> highValue2 = new ArrayList<Double>();
		ArrayList<Double> closeValue2 = new ArrayList<Double>();
		ArrayList<Double> volumeValue2 = new ArrayList<Double>();
		ArrayList<Double> adjCloseValue2 = new ArrayList<Double>();

		XYChart.Series<String, Number> series13 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series14 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series15 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series16 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series17 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series18 = new XYChart.Series<String, Number>();

		ArrayList<String> dateStrings3 = new ArrayList<String>();
		ArrayList<Double> openValue3 = new ArrayList<Double>();
		ArrayList<Double> lowValue3 = new ArrayList<Double>();
		ArrayList<Double> highValue3 = new ArrayList<Double>();
		ArrayList<Double> closeValue3 = new ArrayList<Double>();
		ArrayList<Double> volumeValue3 = new ArrayList<Double>();
		ArrayList<Double> adjCloseValue3 = new ArrayList<Double>();
		
		//READING CSV FILE TO GET ALL DATES AND STORE THEM IN dateStrings2 ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			String dateS2 = ReadCsv.getFileData().get(i).getDate();
			if(dateS2.contains("2017")) {
				dateStrings2.add(dateS2);
			}
		}
		
		//READING CSV FILE TO GET ALL DATES AND STORE THEM IN dateStrings3 ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			String dateS3 = ReadCsv.getFileData().get(i).getDate();
			if(dateS3.contains("2016")) {
				dateStrings3.add(dateS3);
			}
		}
		
		//READING CSV FILE TO GET ALL OPEN PRICE AND STORE THEM IN openValue2 ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double open2 = ReadCsv.getFileData().get(i).getOpen();
			openValue2.add(open2);

		}
		
		//READING CSV FILE TO GET ALL OPEN PRICE AND STORE THEM IN openValue3 ARRAYLIST
		for (int i=30; i<ReadCsv.getFileData().size(); i++) {
			double open3 = ReadCsv.getFileData().get(i).getOpen();
			openValue3.add(open3);
		}
		
		//READING CSV FILE TO GET ALL LOW PRICE AND STORE THEM IN lowValue2 ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double low2 = ReadCsv.getFileData().get(i).getLow();
			lowValue2.add(low2);
		}
		
		//READING CSV FILE TO GET ALL LOW PRICE AND STORE THEM IN 	lowValue3 ARRAYLIST
		for (int i=30; i<ReadCsv.getFileData().size(); i++) {
			double low3 = ReadCsv.getFileData().get(i).getLow();
			lowValue3.add(low3);
		}
		
		//READING CSV FILE TO GET ALL HIGH PRICE AND STORE THEM IN highValue2 ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double high2 = ReadCsv.getFileData().get(i).getHigh();
			highValue2.add(high2);
		}
		
		//READING CSV FILE TO GET ALL HIGH PRICE AND STORE THEM IN highValue3 ARRAYLIST
		for (int i=30; i<ReadCsv.getFileData().size(); i++) {
			double high3 = ReadCsv.getFileData().get(i).getHigh();
			highValue3.add(high3);
		}

		//READING CSV FILE TO GET ALL CLOSE PRICE AND STORE THEM IN closeValue2 ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double close2 = ReadCsv.getFileData().get(i).getClose();
			closeValue2.add(close2);
		}
		
		//READING CSV FILE TO GET ALL CLOSE PRICE AND STORE THEM IN closeValue3 ARRAYLIST
		for (int i=30; i<ReadCsv.getFileData().size(); i++) {
			double close3 = ReadCsv.getFileData().get(i).getClose();
			closeValue3.add(close3);
		}

		//READING CSV FILE TO GET ALL VOLUME PRICE AND STORE THEM IN volumeValue2 ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double volume2 = ReadCsv.getFileData().get(i).getVolume();
			volumeValue2.add(volume2);
		}

		//READING CSV FILE TO GET ALL VOLUME PRICE AND STORE THEM IN volumeValue3 ARRAYLIST
		for (int i=30; i<ReadCsv.getFileData().size(); i++) {
			double volume3 = ReadCsv.getFileData().get(i).getVolume();
			volumeValue3.add(volume3);
		}

		//READING CSV FILE TO GET ALL ADJACENT CLOSE PRICE AND STORE THEM IN adjCloseValue2 ARRAYLIST
		for (int i=0; i<ReadCsv.getFileData().size(); i++) {
			double adjClose2 = ReadCsv.getFileData().get(i).getAdjClose();
			adjCloseValue2.add(adjClose2);
		}
		
		//READING CSV FILE TO GET ALL ADJACENT CLOSE PRICE AND STORE THEM IN adjCloseValue3 ARRAYLIST
		for (int i=30; i<ReadCsv.getFileData().size(); i++) {
			double adjClose3 = ReadCsv.getFileData().get(i).getAdjClose();
			adjCloseValue3.add(adjClose3);
		}
		
		//POPULATION XYCHART WITH DATA FROM ARRAYALISTS
		for (int i=0; i < dateStrings2.size(); i++) {
			series7.getData().add(new XYChart.Data<String, Number>(dateStrings2.get(i), openValue2.get(i)));
			series8.getData().add(new XYChart.Data<String, Number>(dateStrings2.get(i), lowValue2.get(i)));
			series9.getData().add(new XYChart.Data<String, Number>(dateStrings2.get(i), highValue2.get(i)));
			series10.getData().add(new XYChart.Data<String, Number>(dateStrings2.get(i), closeValue2.get(i)));
			series11.getData().add(new XYChart.Data<String, Number>(dateStrings2.get(i), volumeValue2.get(i)));
			series12.getData().add(new XYChart.Data<String, Number>(dateStrings2.get(i), adjCloseValue2.get(i)));
		}
		
		//POPULATING XYCHART WITH DATA FROM ARRAYLISTS
		for (int i=0; i < dateStrings3.size(); i++) {
			series13.getData().add(new XYChart.Data<String, Number>(dateStrings3.get(i), openValue3.get(i)));
			series14.getData().add(new XYChart.Data<String, Number>(dateStrings3.get(i), lowValue3.get(i)));
			series15.getData().add(new XYChart.Data<String, Number>(dateStrings3.get(i), highValue3.get(i)));
			series16.getData().add(new XYChart.Data<String, Number>(dateStrings3.get(i), closeValue3.get(i)));
			series17.getData().add(new XYChart.Data<String, Number>(dateStrings3.get(i), volumeValue3.get(i)));
			series18.getData().add(new XYChart.Data<String, Number>(dateStrings3.get(i), adjCloseValue3.get(i)));
		}

		//ADDING SERIES TO CHARTS
		OpenChart2.getData().clear();
		OpenChart2.getData().add(series7);
		OpenChart2.setTitle("2017");
		
		LowChart2.getData().clear();
		LowChart2.getData().add(series8);
		LowChart2.setTitle("2017");
		
		HighChart2.getData().clear();
		HighChart2.getData().add(series9);
		HighChart2.setTitle("2017");
		
		CloseChart2.getData().clear();
		CloseChart2.getData().add(series10);
		CloseChart2.setTitle("2017");

		VolumeChart2.getData().clear();
		VolumeChart2.getData().add(series11);
		VolumeChart2.setTitle("2017");

		adjCloseChart2.getData().clear();
		adjCloseChart2.getData().add(series12);
		adjCloseChart2.setTitle("2017");

		OpenChart3.getData().clear();
		OpenChart3.getData().add(series13);
		OpenChart3.setTitle("2016");
		
		LowChart3.getData().clear();
		LowChart3.getData().add(series14);
		LowChart3.setTitle("2016");

		HighChart3.getData().clear();
		HighChart3.getData().add(series15);
		HighChart3.setTitle("2016");

		CloseChart3.getData().clear();
		CloseChart3.getData().add(series16);
		CloseChart3.setTitle("2016");

		VolumeChart3.getData().clear();
		VolumeChart3.getData().add(series17);
		VolumeChart3.setTitle("2016");

		adjCloseChart3.getData().clear();
		adjCloseChart3.getData().add(series18);
		adjCloseChart3.setTitle("2016");

	}





	//CREATE TAB PANE FOR GRAPH
	public static void createGraphTabPane() {
		
		//SETTING PREFFERD WIDTH FOR TABPANES
		main_tabpane.setPrefWidth(300);
		tabpane1.setPrefWidth(800);
		tabpane2.setPrefWidth(800);
		tabpane3.setPrefWidth(800);
		tabpane4.setPrefWidth(800);
		tabpane5.setPrefWidth(800);
		tabpane6.setPrefWidth(800);


		//CREATING TABS
		Tab main = new Tab("All Stocks");
		Tab tab1 = new Tab("Open");           
		Tab tab2 = new Tab("High");
		Tab tab3 = new Tab("Low");
		Tab tab4 = new Tab("Close");
		Tab tab5 = new Tab("Volume");
		Tab tab6 = new Tab("AdjClose");

		//ADDING CONTENTS TO THE TAB AND ANCHORPANE AND SETTING THE DIMENSIONS IN ANCHORPANE
		Tab open_yearly = new Tab("Yearly");
		Tab tab_open_all = new Tab("All");		
		tab_open_all.setContent(OpenChart);
		AnchorPane ap1 = new AnchorPane();
		AnchorPane.setLeftAnchor(OpenChart3, 400.0);
		AnchorPane.setRightAnchor(OpenChart3, 10.0);
		ap1.getChildren().addAll(OpenChart2,OpenChart3);
		open_yearly.setContent(ap1);
		tabpane1.getTabs().addAll(tab_open_all, open_yearly);
		AnchorPane p1 = new AnchorPane();
		AnchorPane.setLeftAnchor(tabpane1, 20.0);
		AnchorPane.setTopAnchor(tabpane1, 10.0);
		p1.getChildren().add(tabpane1);

		//ADDING CONTENTS TO THE TAB AND ANCHORPANE AND SETTING THE DIMENSIONS IN ANCHORPANE
		Tab high_yearly = new Tab("Yearly");
		Tab tab_high_all = new Tab("All");
		tab_high_all.setContent(HighChart);
		AnchorPane ap2 = new AnchorPane();
		AnchorPane.setLeftAnchor(HighChart3, 400.0);
		AnchorPane.setRightAnchor(HighChart3, 10.0);
		ap2.getChildren().addAll(HighChart2,HighChart3);
		high_yearly.setContent(ap2);
		tabpane2.getTabs().addAll(tab_high_all,high_yearly);
		AnchorPane p2 = new AnchorPane();
		AnchorPane.setLeftAnchor(tabpane2, 20.0);
		AnchorPane.setTopAnchor(tabpane2, 10.0);
		p2.getChildren().add(tabpane2);

		//ADDING CONTENTS TO THE TAB AND ANCHORPANE AND SETTING THE DIMENSIONS IN ANCHORPANE
		Tab low_yearly = new Tab("Yearly");
		Tab tab_low_all = new Tab("All");
		tab_low_all.setContent(LowChart);
		AnchorPane ap3 = new AnchorPane();
		AnchorPane.setLeftAnchor(LowChart3, 400.0);
		AnchorPane.setRightAnchor(LowChart3, 10.0);
		ap3.getChildren().addAll(LowChart2,LowChart3);
		low_yearly.setContent(ap3);
		tabpane3.getTabs().addAll(tab_low_all, low_yearly);
		AnchorPane p3 = new AnchorPane();
		AnchorPane.setLeftAnchor(tabpane3, 20.0);
		AnchorPane.setTopAnchor(tabpane3, 10.0);
		p3.getChildren().add(tabpane3);

		//ADDING CONTENTS TO THE TAB AND ANCHORPANE AND SETTING THE DIMENSIONS IN ANCHORPANE
		Tab close_yearly = new Tab("Yearly");
		Tab tab_close_all = new Tab("All");
		tab_close_all.setContent(CloseChart);
		AnchorPane ap4 = new AnchorPane();
		AnchorPane.setLeftAnchor(CloseChart3, 400.0);
		AnchorPane.setRightAnchor(CloseChart3, 10.0);
		ap4.getChildren().addAll(CloseChart2,CloseChart3);
		close_yearly.setContent(ap4);
		tabpane4.getTabs().addAll(tab_close_all, close_yearly);
		AnchorPane p4 = new AnchorPane();
		AnchorPane.setLeftAnchor(tabpane4, 20.0);
		AnchorPane.setTopAnchor(tabpane4, 10.0);
		p4.getChildren().add(tabpane4);

		//ADDING CONTENTS TO THE TAB AND ANCHORPANE AND SETTING THE DIMENSIONS IN ANCHORPANE
		Tab volume_yearly = new Tab("Yearly");
		Tab tab_volume_all = new Tab("All");
		tab_volume_all.setContent(VolumeChart);
		AnchorPane ap5 = new AnchorPane();
		AnchorPane.setLeftAnchor(VolumeChart3, 400.0);
		AnchorPane.setRightAnchor(VolumeChart3, 10.0);
		ap5.getChildren().addAll(VolumeChart2,VolumeChart3);
		volume_yearly.setContent(ap5);
		tabpane5.getTabs().addAll(tab_volume_all, volume_yearly);
		AnchorPane p5 = new AnchorPane();
		AnchorPane.setLeftAnchor(tabpane5, 20.0);
		AnchorPane.setTopAnchor(tabpane5, 10.0);
		p5.getChildren().add(tabpane5);


		Tab adjClose_yearly = new Tab("Yearly");
		Tab tab_adjClose_all = new Tab("All");
		tab_adjClose_all.setContent(adjCloseChart);
		AnchorPane ap6 = new AnchorPane();
		AnchorPane.setLeftAnchor(adjCloseChart3, 400.0);
		AnchorPane.setRightAnchor(adjCloseChart3, 10.0);
		ap6.getChildren().addAll(adjCloseChart2,adjCloseChart3);
		adjClose_yearly.setContent(ap6);
		tabpane6.getTabs().addAll(tab_adjClose_all, adjClose_yearly);
		AnchorPane p6 = new AnchorPane();
		AnchorPane.setLeftAnchor(tabpane6, 20.0);
		AnchorPane.setTopAnchor(tabpane6, 10.0);
		p6.getChildren().add(tabpane6);

		// ADD LABEL TO TABS
		main.setContent(StockChart);
		tab1.setContent(p1);
		tab2.setContent(p2);
		tab3.setContent(p3);
		tab4.setContent(p4);
		tab5.setContent(p5);
		tab6.setContent(p6);

		//ADD TABS TO THE TABPANE
		main_tabpane.getTabs().addAll( tab1, tab2, tab3, tab4, tab5, tab6);
		
		//THE TAB CLOSING PROPERTY IS MADE UNAVAILABLE
		main_tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabpane1.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabpane2.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabpane3.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabpane4.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabpane5.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabpane6.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

	} 



	//CREATE LIST VIEW
	public static void createListView() {
		
		/*Typed the contents of the audio on this site: 
		 * https://www.naturalreaders.com/online/
		 * And then recorded the voice in my mobile phone*/
		//PLAYING AUDIO ON APPLICATION RUN
		String sound = "Recording\\WelcomeInstruction.wav";
		Media media = new Media(Paths.get(sound).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(media.getSource());
		mediaPlayer.play();
		
		//SETTING VISIBILITY FOR OTHER TABPANES TO FALSE SO THAT THEY ARE NOT DISPLAYED
		main_tabpane.setVisible(false);
		Reporttabpane.setVisible(false);
		comparetabpane.setVisible(false);
		
		//CREATING TABLE
		createTable();
		//CREATING "STOCKS TABLE" TABPANE
		generalInfoTabPane();
		
		//POPULATING LISTVIEW WITH CONTENTS OF companyname OBSERVABLELIST
		companyListView.setItems(companyname);
		companyListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				//CLEARING ALL ELEMENTS TO REMOVE ANY PREVIOUS DATA
				getTableView().getItems().clear();
				getCompareTableView().getItems().clear();
				
				/*CLEARING TABS FROM TABPANE SO THAT THEY ARE NOT CREATED AGAIN 
				ON SELECTING NEW COMPANY NAME FROM LISTVIEW*/
				main_tabpane.getTabs().clear();
				comparetabpane.getTabs().clear();
				tabpane1.getTabs().clear();
				tabpane2.getTabs().clear();
				tabpane3.getTabs().clear();
				tabpane4.getTabs().clear();
				tabpane5.getTabs().clear();
				tabpane6.getTabs().clear();
				
				//SELECTING ALL CSV FILES FROM THE SPECIFIED FILE LOCATION
				File directory = new File("Csv");
				File files[] = directory.listFiles();
				
				for (int j = 0; j < files.length; j++) {
					getCompareTableView().setItems(CompareTable.reportcsv(files[j]));
				}
				readcsv.readCsv(company.get(companyListView.getSelectionModel().getSelectedIndex()));
				getTableView().setItems(ReadCsv.getFileData());
				
				//CALCULATING THE CHNAGE IN CLOSE PRICE 
				double change = ReadCsv.getFileData().get(1).getClose() - ReadCsv.getFileData().get(0).getClose();
				
				//SETTING FONTSTYLE FOR LABELS
				companyName.setFont(Font.font("Helvetica",FontPosture.ITALIC, 15));
				companySymbol.setFont(Font.font("Helvetica",FontPosture.ITALIC, 15));
				closeSymbol.setFont(Font.font("Helvetica",FontPosture.ITALIC, 15));
				prevCloseSymbol.setFont(Font.font("Helvetica",FontPosture.ITALIC, 15));
				changeSymbol.setFont(Font.font("Helvetica",FontPosture.ITALIC, 15));
				
				//SETTING TEXT FOR LABELS
				companySymbol.setText("Company Symbol: " + company.get(companyListView.getSelectionModel().getSelectedIndex())+ ".L");
				companyName.setText("Company Name: " + companyname.get(companyListView.getSelectionModel().getSelectedIndex()));
				closeSymbol.setText("Latest Close Price: " + ReadCsv.getFileData().get(0).getClose());
				prevCloseSymbol.setText("Previous Close Price: " + ReadCsv.getFileData().get(1).getClose());
				changeSymbol.setText("Change: "+ change );
				
				/*IF CHANGE IN CLOSE PRICE IS NEGATIVE, IT IS DISPLAYED IN RED BACKGROUND,
				 * IF CHANGE IN CLOSE PRICE IS POSITIVE, IT IS DISPLAYED IN GREEN BACKGROUND
				 */
				if (change < 0.0) {
					changeSymbol.setStyle("-fx-background-color: ORANGERED;");
				} else {
					changeSymbol.setStyle("-fx-background-color: DARKSEAGREEN;");
				}
				
				/*CALLING METHODS TO CREATE GRAPH TABPANE, CREATE GRAPH, CREATE YEARLY GRAPH, 
				CREATE COMPARE TABPANE AND CREATE COMPARE TABLE FOR COMPARING STOCKS*/ 
				createGraphTabPane();
				createGraph();
				createYearlyGraph();
				CreatecompareTabPane();
				createCompareTable();
			}
		});

		//POPULATING COMBOBOX WITH CONTENTS OF VIEWS OBSERVABLELIST
		comboBox.setItems(views);
		comboBox.setPromptText("Select View");
		//SETTING PREFFERD WIDTH FOR COMBOBOX 
		comboBox.setPrefWidth(200);
		//SETTING DEFAULT SELECTION FOR COMBOBOX
		comboBox.getSelectionModel().selectFirst();
		//LISTENING FOR CHANGES TO COMBOBOX SELECTION
		comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue == "Tabular Data") {

					/*TO CLEAR THE PREVIOUS DISPLAY, IF OTHER VIEW WAS
					 *  SELECTED EARLIER, BEFORE CREATING TABLE
					 */
					getTableView().setVisible(true);
					getCompareTableView().setVisible(false);
					main_tabpane.setVisible(false);
					Infotabpane.setVisible(true);
					Reporttabpane.setVisible(false);
					comparetabpane.setVisible(false);
					companyName.setVisible(true);
					companySymbol.setVisible(true);
					
					//CALL METHOD TO CREATE TABLE
					createTable();
					
					//CLACULATING THE CHANGE IN THE CLOSE PRICE FROM PREVIOUS DATE
					double change = ReadCsv.getFileData().get(1).getClose() - ReadCsv.getFileData().get(0).getClose();
					
					//SETTING THE TEXT AND FONTSTYLE FOR LABELS
					companyName.setFont(Font.font("Helvetica",FontPosture.ITALIC, 15));
					companySymbol.setFont(Font.font("Helvetica",FontPosture.ITALIC, 15));
					companyName.setText("Company Name: " + companyname.get(companyListView.getSelectionModel().getSelectedIndex()));
					companySymbol.setText("Company Symbol: " + company.get(companyListView.getSelectionModel().getSelectedIndex())+ ".L");
					closeSymbol.setText("Latest Close Price: " + ReadCsv.getFileData().get(0).getClose());
					prevCloseSymbol.setText("Previous Close Price: " + ReadCsv.getFileData().get(1).getClose());
					changeSymbol.setText("Change: "+ change );

				}
				else if (newValue == "Graphical Data") {

					//TO CLEAR THE PREVIOUS DISPLAY IF OTHER VIEW WAS SELECTED EARLIER
					getTableView().getColumns().clear();
					getCompareTableView().getColumns().clear();
					getTableView().setVisible(false);
					getCompareTableView().setVisible(false);
					
					//TO HIDE OTHER TABPANES AND SHOW ONLY TABPANE CONTAINING GRAPHS
					main_tabpane.setVisible(true);
					Reporttabpane.setVisible(false);
					Infotabpane.setVisible(false);
					comparetabpane.setVisible(false);
					
					//CALL METHOD TO CREATE GRAPH AND GRAPH TABPANE
					createGraph();
					createYearlyGraph();

				}
				else if (newValue == "Report") {

					try {
						//CLEARING TABS FROM TABPANE SO THAT THEY ARE NOT CREATED AGAIN 
						Reporttabpane.getTabs().clear();
						getTableView().getColumns().clear();
						getCompareTableView().getColumns().clear();
						
						
						//TO HIDE THE OTHER TABPANES AND SHOW ONLY TABPANES CONTAINING REPORT
						Reporttabpane.setVisible(true);
						main_tabpane.setVisible(false);
						Infotabpane.setVisible(false);
						comparetabpane.setVisible(false);
						getTableView().setVisible(false);
						
						//CALL METHOD TO CREATE REPORT TABPANE
						exceltabpane();

					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
				else if (newValue == "Compare Stocks") {
					/*Typed the contents of the audio on this site: 
					 * https://www.naturalreaders.com/online/
					 * And then recorded the voice in my mobile phone*/
					//PLAYING AUDIO WHEN USER SELECTS "COMPARE STOCKS" FROM COMBOBOX(DROPDOWN MENU)
					String bip = "Recording\\CompareInstruction.wav";
					Media hit = new Media(Paths.get(bip).toUri().toString());
					AudioClip mediaPlayer = new AudioClip(hit.getSource());
					mediaPlayer.play();
					
					//CLEARING TABS FROM TABPANE SO THAT THEY ARE NOT CREATED AGAIN 
					Reporttabpane.getTabs().clear();
					getTableView().getColumns().clear();
					
					//TO HIDE ALL OTHER TABPANE AND SHOWING ONLY COMPARE STOCKS TABPANE
					Reporttabpane.setVisible(false);
					main_tabpane.setVisible(false);
					Infotabpane.setVisible(false);
					comparetabpane.setVisible(true);
					getTableView().setVisible(false);
					getCompareTableView().setVisible(true);
					
					//CALL METHOD TO CRAETE COMPARE TABLE
					createCompareTable();
				}
			}
		});
	}




	//CREATE REPORT TAB PANE
	public static void exceltabpane() {
		
		AnchorPane csvPane = new AnchorPane();
		
		//SETTING BUTTONS TEXTS AND FONTSTYLES
		butn.setText("Generate Report For All Companies....");
		butn.setFont(Font.font("Helvetica",FontPosture.ITALIC, 25));
		butn2.setText("Generate Individual Report....");
		butn2.setFont(Font.font("Helvetica",FontPosture.ITALIC, 25));

		//SETTING LABEL TEXTS AND FONTSTYLES
		reportText.setText("Generate Report for all Companies: ");
		reportText.setFont(Font.font("Helvetica",FontPosture.ITALIC, 18));
		reportText2.setText("Generate Report for Individual Companies By Selecting Company Name: ");
		reportText2.setFont(Font.font("Helvetica",FontPosture.ITALIC, 18));
		
		
		//SETTING ANCHORPANE ELEMENTS DIMENSIONS//
		
		AnchorPane.setTopAnchor(reportText, 50.0);
		AnchorPane.setBottomAnchor(reportText, 400.0);
		AnchorPane.setLeftAnchor(reportText, 30.0);
		AnchorPane.setRightAnchor(reportText, 30.0);

		AnchorPane.setTopAnchor(butn, 150.0);
		AnchorPane.setBottomAnchor(butn, 300.0);
		AnchorPane.setLeftAnchor(butn, 30.0);
		AnchorPane.setRightAnchor(butn, 30.0);
		
		AnchorPane.setTopAnchor(reportText2, 250.0);
		AnchorPane.setBottomAnchor(reportText2, 200.0);
		AnchorPane.setLeftAnchor(reportText2, 30.0);
		AnchorPane.setRightAnchor(reportText2, 30.0);
		
		AnchorPane.setTopAnchor(butn2, 350.0);
		AnchorPane.setBottomAnchor(butn2, 100.0);
		AnchorPane.setLeftAnchor(butn2, 30.0);
		AnchorPane.setRightAnchor(butn2, 30.0);
		
		//ADDING ALL ELEMENTS TO ANCHORPANE
		csvPane.getChildren().addAll(butn, reportText, butn2, reportText2);
		Tab tabreport = new Tab("Report");
		
		//ADDING ANCHORPANE TO REPORT TABPANE
		tabreport.setContent(csvPane);
		Reporttabpane.getTabs().add(tabreport);
		
		//THE TAB CLOSING PROPERTY IS MADE UNAVAILABLE 
		Reporttabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		//HANDLING BUTTON CLICK ACTION 
		butn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e)  {
				
				//SETTING UP FILE CHOSSER FOR USER
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilter = 
						new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
				fileChooser.getExtensionFilters().add(extFilter);
				file = fileChooser.showSaveDialog(null);
				if (file != null) {
					try {
						createReport();
					}
					catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		
		//HANDLING BUTTON CLICK ACTION 
		butn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e)  {
				
				//SETTING UP FILE CHOSSER FOR USER
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
				fileChooser.getExtensionFilters().add(extFilter);
				file2 = fileChooser.showSaveDialog(null);
				if (file2 != null) {
					try {
						createIndividualReport();
					}
					catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		});
	}



	//GENERATE REPORT FOR ALL COMPANIES
	public static void createReport(){

		companiesS.addAll(Arrays.asList("AHT", "ANTO", "BA", "BATS", "CCH", "CCL", "CNA", "CPG", "EXPN", "EZJ", "GKN", "MDC", "PFG", "PPB",
				"PRU", "PSN", "RB", "RDSA", "RR", "SDR", "SHP", "SKY", "SSE", "STJ", "TSCO", "TUI", "VOD", "WPG"));


		companiesN.addAll(Arrays.asList("Ashtead Group plc", "Antofagasta plc",
				"BAE Systems plc", "British American Tobacco plc",
				"Coca-Cola HBC AG", "Carnival plc", "Centrica plc",  
				"Compass Group plc", "Experian plc", "EasyJet plc", "GKN plc", 
				"Mediclinic International plc", "Provident Financial plc","Paddy Power Betfair plc",
				"Prudential plc", "Persimmon plc", "Reckitt Benckiser Group plc", "Royal Dutch Shell plc",
				"Rolls-Royce Holdings plc", "Schroders plc", "Shire plc", "Sky plc",
				"SSE plc", "St. James's Place plc", "Tesco plc", "TUI AG", "Vodafone Group plc",
				"Worldpay Group plc"));

		//SELECTING ALL CSV FILES FROM SPECIFIED FILE LOCATION AND STORING IN FILES ARRAY 
		File directory = new File("Csv");
		File files[] = directory.listFiles();

		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		for (int j = 0; j < files.length; j++) {
			companyData.clear();
			companyData = reportCsv.reportcsv(files[j]);

			String filename = files[j].getName();
			filename = filename.substring(0, filename.lastIndexOf('.'));
			try {
				
				//FORMATTING THE REPORT
				writer.write(System.lineSeparator());
				writer.write(System.lineSeparator());
				writer.write(System.lineSeparator());
				writer.write(System.lineSeparator());
				writer.write(System.lineSeparator());
				writer.write(String.format("%-20s %-30s %-20s %-15s %-10s %-10s %-10s", "***************", "****************************",
						"***************","**********", "********", "******", "*********",  "******"));
				writer.write(System.lineSeparator());
				writer.write(String.format("%-20s %-30s %-20s %-15s %-10s %-10s %-10s", "Sequence Number", "Company Name ",
						"Company Symbol ","Date      ", "Highest ", "Lowest", "Adj Close",  "Close "));
				writer.write(System.lineSeparator());
				writer.write(String.format("%-20s %-30s %-20s %-15s %-10s %-10s %-10s", "***************", "****************************",
						"***************","**********", "********", "******", "*********",  "******"));
				writer.write(System.lineSeparator());

			} catch (IOException e) {

				e.printStackTrace();
			}

			for (int i = 0; i < companyData.size(); i++) {
				try {
					//FROMATTING AND WRITING THE DATA FOR REPORT
					writer.write(String.format("%-20s %-30s %-20s %-15s %-10s %-10s %-10s",(j+1),companiesN.get(j),filename + ".L", 
							companyData.get(i).getDate(),companyData.get(i).getHigh(),companyData.get(i).getLow(), companyData.get(i).getAdjClose(),
							companyData.get(i).getClose()));
					writer.write(System.lineSeparator());
					writer.write(String.format("%-20s %-30s %-20s %-15s %-10s %-10s %-10s", "----------------", "----------------------------",
							"---------------", "----------", "---------", "------", "----------",  "------"));
					writer.append(System.lineSeparator());

				} catch (IOException e2) {

					e2.printStackTrace();
				}
			}
		};
		try {
			
			writer.close();
			
			//ALERTING WHEN REPORT IS GENERATED SUCCESSFULLY
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Report Information");
			alert.setHeaderText(null);
			alert.setContentText("Report generated successfully!");
			
			/*Typed the contents of the audio on this site: 
			 * https://www.naturalreaders.com/online/
			 * And then recorded the voice in my mobile phone*/
			//PLAYING AUDIO WHEN REPORT IS GENERATED 
			Media sound=new Media(new File("Recording\\ReportAudio.wav").toURI().toString());
			MediaPlayer mediaPlayer=new MediaPlayer(sound);
			mediaPlayer.play();
			alert.showAndWait();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}



	//GENERATE REPORT FOR INDIVIDUAL COMPANIES
	
	public static void createIndividualReport(){
		try {
			writer = new BufferedWriter(new FileWriter(file2));
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		companyData2.clear();
		companyData2 = readcsv2.readCsv(company.get(companyListView.getSelectionModel().getSelectedIndex()));

		try {
			
			//FORMATTING THE REPORT
			writer.write(System.lineSeparator());
			writer.write(System.lineSeparator());
			writer.write(System.lineSeparator());
			writer.write(System.lineSeparator());
			writer.write(System.lineSeparator());
			writer.write(String.format("%-20s %-30s %-15s %-10s %-10s %-10s", "***************", "****************************",
					"**********", "********", "******", "*********",  "******"));
			writer.write(System.lineSeparator());
			writer.write(String.format("%-20s %-30s %-15s %-10s %-10s %-10s", "Sequence Number", "Company Name ",
					"Date      ", "Highest ", "Lowest", "Adj Close",  "Close "));
			writer.write(System.lineSeparator());
			writer.write(String.format("%-20s %-30s %-15s %-10s %-10s %-10s", "***************", "****************************",
					"**********", "********", "******", "*********",  "******"));
			writer.write(System.lineSeparator());

		} catch (IOException e) {

			e.printStackTrace();
		}

		for (int i = 0; i < companyData2.size(); i++) {
			try {
				
				//FORMATTING AND WRITING THE DATA TO THE REPORT
				writer.write(String.format("%-20s %-30s %-15s %-10s %-10s %-10s",(i),companyData2.get(i).getCompanyName(), 
						companyData2.get(i).getDate(),companyData2.get(i).getHigh(),companyData2.get(i).getLow(), companyData2.get(i).getAdjClose(),
						companyData2.get(i).getClose()));
				writer.write(System.lineSeparator());
				writer.write(String.format("%-20s %-30s %-15s %-10s %-10s %-10s", "----------------", "----------------------------",
						"---------------", "----------", "---------", "------", "----------",  "------"));
				writer.append(System.lineSeparator());

			} catch (IOException e2) {

				e2.printStackTrace();
			}
		}
		try {
			
			writer.flush();
			writer.close();
			
			//ALERTING WHEN REPORT IS GENERATED
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Report Information");
			alert.setHeaderText(null);
			alert.setContentText("Report generated successfully!");
			
			/*Typed the contents of the audio on this site: 
			 * https://www.naturalreaders.com/online/
			 * And then recorded the voice in my mobile phone*/
			//PLAYING AUDIO WHEN REPORT IS GENERATED 
			Media sound=new Media(new File("Recording\\ReportAudio.wav").toURI().toString());
			MediaPlayer mediaPlayer=new MediaPlayer(sound);
			mediaPlayer.play();
			alert.showAndWait();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

//End of Class Body
}

