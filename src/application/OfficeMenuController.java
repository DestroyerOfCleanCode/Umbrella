package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class OfficeMenuController {
	@FXML
	private Text greeting;
		
    @FXML
    private void logout() throws IOException {
        System.out.print("logout pressed");
    	Main.id = 0;
    	Main.setRoot("Login");
    }
	
    @FXML
    private void newPatient() throws IOException {
    	Main.setRoot("MakeNewPatientPage");
    }
    
    @FXML
    private void existingPatient() throws IOException {
    	Main.setRoot("FindPatientPage");
    }
    
    @FXML
    private void viewMessages() throws IOException {
    	Main.setRoot("OfficeMessagingPage");
    }
}
