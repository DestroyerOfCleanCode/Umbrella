package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
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
	private TextArea immunizations;

	@FXML
	private VBox MessageBox;

	@FXML
	private TextField messageField;

	@FXML
	public void initialize() throws SQLException {
		ArrayList<String> data = Helper.fetchPatientDataFromId(Main.id);

		String firstName = data.get(0);
		String lastName = data.get(1);
		String dob = data.get(2);
		String phoneNumber = data.get(3);
		String email = data.get(4);
		String address = data.get(5);
		String insuranceNumber = data.get(6);
		String pharmacyAddress = data.get(7);
		String pharmacyPhoneNumber = data.get(8);
		String weight = data.get(9);
		String height = data.get(10);
		String bodyTemp = data.get(11);
		String bloodPressureHi = data.get(12);
		String bloodPressureLo = data.get(13);
		String healthHistory = data.get(14);
		String immunization = data.get(15);

		greeting.setText("Hello " + firstName + " " + lastName);
		phoneNumberField.setText(phoneNumber);
		emailField.setText(email);
		addressField.setText(address);
		insuranceNumberField.setText(insuranceNumber);
		pharmAddressField.setText(pharmacyAddress);
		pharmNumberField.setText(pharmacyPhoneNumber);
		immunizations.setText(immunization);
		
	}

	@FXML
	private void logout() throws IOException {
		Main.id = -1;
		Main.setRoot("Login");
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
