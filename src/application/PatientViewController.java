package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public void initialize() throws SQLException {
		ArrayList<String> data = Helper.fetchPatientDataFromId(Main.id);

		String firstName = data.get(0);
		String lastName = data.get(1);
		String dob = data.get(2);
		String phoneNumber = data.get(3);
		String email = data.get(4);
		String insuranceNumber = data.get(5);
		String pharmacy = data.get(6);
		String weight = data.get(7);
		String height = data.get(8);
		String bodyTemp = data.get(9);
		String bloodPressureHi = data.get(10);
		String bloodPressureLo = data.get(11);
		String allergies = data.get(12);
		String healthIssues = data.get(13);
		String medications = data.get(14);

		greeting.setText("Hello " + firstName);
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
