package application;
	
import java.io.FileInputStream;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Main extends Application {
	private static Stage primaryStage;
	public static Stage getPrimaryStage() {
		return Main.primaryStage;
	}

	//MAIN METHOD
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {

		AnchorPane root = new AnchorPane();
		StackPane pane = new StackPane();
		
		//SEETING THE TEXT AND FONTSTYLES FOR TEXT
		Text greet = new Text("WELCOME TO THE STOCK APP");
		greet.setTextAlignment(TextAlignment.CENTER);
		greet.setFont(Font.font(null, FontWeight.MEDIUM, 50));
		greet.setX(450); 
		greet.setY(300);
		
		//SELECTING THE IMAGES FOR SPLASH/WELCOME SCREEN
		FileInputStream input = new FileInputStream(
				"images\\welcome.jpg");
		Image image = new Image(input);
		ImageView imgView = new ImageView(image);
		
		//SETTING THE WIDTH OF THE IMAGE FOR THE SPLAS/WELCME SCREEN
		imgView.setFitHeight(600);
		imgView.setFitWidth(900);
		
		//ADDING THE IMAGE AND TEXT TO THE STACKPANE
		pane.getChildren().addAll(imgView,greet);
		StackPane.setAlignment(greet, Pos.CENTER);
		
		//ADDING THE STACKPANE TO ANCHORPANE
		root.getChildren().setAll(pane);

		//LOAD WELCOME SCREEN WITH FADE IN EFFECT
		FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
		fadeIn.setFromValue(0);
		fadeIn.setToValue(1);
		fadeIn.setCycleCount(1);

		//FINISH WELCOME SCREEN WITH FADE OUT EFFECT
		FadeTransition fadeOut = new FadeTransition(Duration.seconds(2.5), pane);
		fadeOut.setFromValue(1);
		fadeOut.setToValue(0);
		fadeOut.setCycleCount(1);

		fadeIn.play();

		//AFTER FADE IN, START FADE OUT
		fadeIn.setOnFinished((e) -> {
			fadeOut.play();
		});
		fadeOut.setOnFinished((e) -> {
			try {
				root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
				root.getChildren().setAll(stockController.getCompanyListView(),stockController.Infotabpane,
						stockController.comboBox, stockController.main_tabpane, stockController.Reporttabpane,
						stockController.comparetabpane);
				stockController.createListView();
			} catch (Exception e2) {
			}
		});
		
		
		//SETTING THE DIMENSIONS OF ELEMENTS IN ANCHORPANE(ROOT PANE)
		
		AnchorPane.setTopAnchor(stockController.getCompanyListView(), 15.0);
		AnchorPane.setLeftAnchor(stockController.getCompanyListView(), 100.0);
		AnchorPane.setRightAnchor(stockController.getCompanyListView(), 500.0);
		AnchorPane.setBottomAnchor(stockController.getCompanyListView(), 490.0);

		AnchorPane.setTopAnchor(stockController.Infotabpane, 130.0);
		AnchorPane.setLeftAnchor(stockController.Infotabpane, 30.0);
		AnchorPane.setRightAnchor(stockController.Infotabpane, 30.0);
		AnchorPane.setBottomAnchor(stockController.Infotabpane, 30.0);

		AnchorPane.setTopAnchor(stockController.main_tabpane, 130.0);
		AnchorPane.setLeftAnchor(stockController.main_tabpane, 30.0);
		AnchorPane.setRightAnchor(stockController.main_tabpane, 30.0);
		AnchorPane.setBottomAnchor(stockController.main_tabpane, 30.0);

		AnchorPane.setTopAnchor(stockController.comboBox, 40.0);
		AnchorPane.setLeftAnchor(stockController.comboBox, 500.0);
		AnchorPane.setRightAnchor(stockController.comboBox, 100.0);
		AnchorPane.setBottomAnchor(stockController.comboBox, 520.0);
		
		AnchorPane.setTopAnchor(stockController.Reporttabpane, 130.0);
		AnchorPane.setLeftAnchor(stockController.Reporttabpane, 30.0);
		AnchorPane.setRightAnchor(stockController.Reporttabpane, 30.0);
		AnchorPane.setBottomAnchor(stockController.Reporttabpane, 30.0);
		
		AnchorPane.setTopAnchor(stockController.comparetabpane, 130.0);
		AnchorPane.setLeftAnchor(stockController.comparetabpane, 30.0);
		AnchorPane.setRightAnchor(stockController.comparetabpane, 30.0);
		AnchorPane.setBottomAnchor(stockController.comparetabpane, 30.0);
		
		//SETTING THE DIMENSION AND COLOR OF SCENE
		Scene scene = new Scene(root, 900, 600, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

