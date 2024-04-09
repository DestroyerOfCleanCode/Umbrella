package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ExistingPatientsPageController {
	@FXML
	private Text greeting;
	@FXML
	private Text patientName;
	
	@FXML
	private Text firstname;
	@FXML
	private Text lastname;
	@FXML
	private Text dob;
	@FXML
	private Text sex;
	@FXML
	private Text bloodpressure;
	@FXML
	private Text weight;
	@FXML
	private Text height;
	
	@FXML
	private TextField phonenumber;
	@FXML
	private TextField email;
	@FXML
	private TextField address;
	
	@FXML
	private TextField insurancenumber;
	
	@FXML
	private TextField pharmaddress;
	@FXML
	private TextField pharmnumber;
	
	@FXML
	private VBox healthHistoryBox;
	
	@FXML
	private VBox immunizationsBox;
	
	@FXML
	private VBox pastAppointmentsBox;
	
	@FXML
	private VBox MessageBox;	
	
	@FXML
	private TextField messageField;
	
	@FXML
    private void logout() throws IOException {
        Main.setRoot("Login");
        Main.id = 0;
    }
    
	@FXML
    private void goback() throws IOException {
        Main.setRoot("OfficeMenuPage");
    }
    
    @FXML
    private void sendMessage() throws IOException {
    	String message = messageField.getText();
    	System.out.print(message);
    }
    
    @FXML
    private void appointment() throws IOException {
    	System.out.print("appointment button pressed");
    	Main.setRoot("AppointmentPage");
    }
    
}
