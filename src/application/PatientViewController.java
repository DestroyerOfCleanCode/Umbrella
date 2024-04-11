package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PatientViewController {
	@FXML
	private Text greeting;

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
	private TextArea immunizations;

	@FXML
	private TextArea pastAppointments;

	@FXML
	private TextArea MessageBox;

	@FXML
	private TextField messageField;

	private Patient patient;

	@FXML
	public void initialize() throws SQLException {
		patient = Helper.fetchPatientData(Main.patientID);

		if (patient == null) {
			return;
		}

		populatePatientData();
	}

	private void populatePatientData() throws SQLException {
		greeting.setText("Hello " + patient.getFirstName());
		phoneNumberField.setText(patient.getPhoneNumber() == null ? "" : patient.getPhoneNumber());
		emailField.setText(patient.getEmail() == null ? "" : patient.getEmail());
		addressField.setText(patient.getAddress() == null ? "" : patient.getAddress());
		insuranceNumberField.setText(patient.getInsuranceNumber() == null ? "" : patient.getInsuranceNumber());
		pharmAddressField.setText(patient.getPharmacyAddress() == null ? "" : patient.getPharmacyAddress());
		pharmNumberField.setText(patient.getPharmacyPhoneNumber() == null ? "" : patient.getPharmacyPhoneNumber());
		immunizations.setText(patient.getImmunization() == null ? "" : patient.getImmunization());
		pastAppointments.setText(Helper.appointmentsAsString(patient.getId()));
		MessageBox.setText(Helper.messagesAsString(patient.getId()));
	}

	@FXML
	private void logout() throws IOException {
		Main.patientID = -1;
		Main.setRoot("Login");
	}

	@FXML
	private void saveAdditionalInformation() throws IOException, SQLException {
		String phoneNumber = phoneNumberField.getText();
		String email = emailField.getText();
		String address = addressField.getText();
		String insuranceNumber = insuranceNumberField.getText();
		String pharmAddress = pharmAddressField.getText();
		String pharmNumber = pharmNumberField.getText();

		if (!phoneNumber.isBlank()) {
			patient.setPhoneNumber(phoneNumber);
		}

		if (!email.isBlank()) {
			patient.setEmail(email);
		}

		if (!address.isBlank()) {
			patient.setAddress(address);
		}

		if (!insuranceNumber.isBlank()) {
			patient.setInsuranceNumber(insuranceNumber);
		}

		if (!pharmAddress.isBlank()) {
			patient.setPharmacyAddress(pharmAddress);
		}

		if (!pharmNumber.isBlank()) {
			patient.setPharmacyPhoneNumber(pharmNumber);
		}

		if (!phoneNumber.isBlank() || !email.isBlank() || !address.isBlank() || !insuranceNumber.isBlank()
				|| !pharmAddress.isBlank() || !pharmNumber.isBlank()) {
			if (Helper.updatePatientData(patient)) {
				populatePatientData();
			}
		}
	}

	@FXML
	private void updateImmunization() throws IOException, SQLException {
		String imm = immunizations.getText();
		patient.setImmunization(imm);

		if (Helper.updatePatientData(patient)) {
			populatePatientData();
		}
	}

	@FXML
	private void sendMessage() throws IOException, SQLException {
		String message = messageField.getText();
		if (message.isBlank()) {
			return;
		}

		messageField.clear();
		Helper.sendMessage(patient.getId(), message);
		MessageBox.setText(Helper.messagesAsString(patient.getId()));
	}
}
