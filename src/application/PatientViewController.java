package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PatientViewController {
	@FXML
	private Text greeting;
	
	@FXML
	private VBox pastAppointmentsBox;
	
	@FXML
	private TextField phoneNumberField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField addressField;
	
	@FXML
	private TextField insuranceNumberField;
	
	@FXML
	private TextField pharmAddressField;
	@FXML
	private TextField pharmNumberField;
	
	@FXML
	private TextField vaccineField;
	@FXML
	private TextField vaccineDateField;
	@FXML
	private VBox immunizationsBox;
	
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
    private void saveAdditionalInformation() throws IOException {
		String phonenumber = phoneNumberField.getText();
		String email = emailField.getText();
		String address = addressField.getText();
		String insuranceNumber = insuranceNumberField.getText();
		String pharmAddress = pharmAddressField.getText();
		String pharmNumber = pharmNumberField.getText();
		System.out.println(phonenumber + ", " + email + ", " + address + ", " + insuranceNumber + ", "
				+ pharmAddress + ", " + pharmNumber);
    }
	
	@FXML
    private void addNewVaccine() throws IOException {
		String vaccine = vaccineField.getText();
		String vaccineDate = vaccineDateField.getText();
		System.out.println(vaccine + ", " + vaccineDate);
    }
	
	@FXML
    private void sendMessage() throws IOException {
		String message = messageField.getText();
		System.out.println(message);
    }
}
