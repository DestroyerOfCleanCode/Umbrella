package application;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
    private static Scene scene;
    private static double xOffset, yOffset;

    static Connection connection = null;
    static Statement stmt = null;
    
    static int id;
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("fxml/Login.fxml"));
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			// This allows window to be dragged
	        root.setOnMousePressed(event -> {
	            xOffset = stage.getX() - event.getScreenX();
	            yOffset = stage.getY() - event.getScreenY();
	        });

	        root.setOnMouseDragged(event -> {
	            stage.setX(event.getScreenX() + xOffset);
	            stage.setY(event.getScreenY() + yOffset);
	        });
			
	     // This disable window border and buttons
	        scene.setFill(Color.TRANSPARENT);
	        stage.initStyle(StageStyle.TRANSPARENT);

	        stage.setScene(scene);

	        // Disable window resize function
	        stage.setResizable(false);
	        
	        stage.setScene(scene);
	        stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

	public static void main(String[] args) {
		try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS Account (ID INTEGER PRIMARY KEY AUTOINCREMENT, Username TEXT NOT NULL UNIQUE, Password TEXT NOT NULL, Type TEXT NOT NULL);";
            stmt.executeUpdate(query);

            query = "CREATE TABLE IF NOT EXISTS Patient (ID INTEGER PRIMARY KEY AUTOINCREMENT, firstName TEXT NOT NULL, lastName TEXT NOT NULL, dob DATE NOT NULL, phoneNumber TEXT, email TEXT, insuranceNumber TEXT, pharmacy TEXT, weight REAL, height REAL, bodyTemp REAL, bloodPressureHi REAL, bloodPressureLo REAL, allergies TEXT, healthIssues TEXT, medications TEXT);";
            stmt.executeUpdate(query);

            launch();

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
	}
	
}
