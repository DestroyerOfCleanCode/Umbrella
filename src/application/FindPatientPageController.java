package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FindPatientPageController {
	@FXML
	private Text greeting;
	
	@FXML 
	private TextField firstname_field;
	@FXML
	private TextField lastname_field;
	@FXML
	private DatePicker dob_field;
	
	@FXML
	private Text error_msg;
	
	
    @FXML
    private void findpatient() throws IOException {
        String firstname = firstname_field.getText();
        String lastname = lastname_field.getText();

        if (firstname.isBlank() || lastname.isBlank()) {
            error_msg.setText("Please fill in all fields");
            return;
        }
        
        if (!firstname.isBlank() && !lastname.isBlank()) {
        	System.out.print("patient found");
        	Main.setRoot("ExistingPatientsPage");
        }
        else {
        	error_msg.setText("Patient Not Found!");
        }
    }
    
    @FXML
    private void cancel() throws IOException {
        System.out.print("cancel pressed");
        Main.setRoot("OfficeMenuPage");
    }
    
    @FXML
    private void logout() throws IOException {
        System.out.print("logout pressed");
    	Main.id = 0;
    	Main.setRoot("Login");
    }
}
