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
    private static Stage stage;

    public static double xOffset, yOffset;

    static int patientID;
    static int employeeID;

    static Connection connection = null;
    static Statement stmt = null;
	
	@Override
	public void start(Stage mainStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("fxml/Login.fxml"));
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			stage = mainStage;
			Helper.makeDraggable(root, stage);
			
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
        Helper.makeDraggable(scene.getRoot(), stage);
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

            query = "CREATE TABLE IF NOT EXISTS Patient (ID INTEGER PRIMARY KEY NOT NULL, firstName TEXT NOT NULL, lastName TEXT NOT NULL, dob DATE NOT NULL, phoneNumber TEXT, email TEXT, address TEXT, insuranceNumber TEXT, pharmacyAddress TEXT, pharmacyPhoneNumber TEXT, weight REAL, height REAL, bodyTemp REAL, bloodPressureHi REAL, bloodPressureLo REAL, healthHistory TEXT, immunization TEXT);";
            stmt.executeUpdate(query);

            query = "CREATE TABLE IF NOT EXISTS Employee (ID INTEGER PRIMARY KEY NOT NULL, FirstName TEXT NOT NULL, LastName TEXT);";
            stmt.executeUpdate(query);

            query = "CREATE TABLE IF NOT EXISTS Appointment (ID INTEGER PRIMARY KEY AUTOINCREMENT, PatientID INTEGER NOT NULL, DoctorID INTEGER NOT NULL, Date DATE NOT NULL, Allergies TEXT, HealthConcern TEXT, PhysExam TEXT, DocConcern TEXT, Prescription TEXT);";
            stmt.executeUpdate(query);

//             Helper.createEmployeeAccount("miles", "123", "Miles", "", "Doctor");

            launch();

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
	}
	
}
