package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	private TextField bodyTemp;
	@FXML
	private TextField maxBP;
	@FXML
	private TextField minBP;
	@FXML
	private TextField weight;
	@FXML
	private TextField height;

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
	private TextArea healthHistoryBox;

	@FXML
	private TextArea immunizationsBox;

	@FXML
	private TextArea pastAppointmentsBox;

	@FXML
	private TextArea MessageBox;

	@FXML
	private TextField messageField;

	private Patient patient;

	public void initialize() throws SQLException {
		patient = Helper.fetchPatientData(Main.patientID);

		if (patient == null) {
			return;
		}

		greeting.setText(Helper.greetingEmployee(Main.employeeID));
		populatePatientData();
	}

	private void populatePatientData() throws SQLException {
		patientName.setText(patient.getFirstName() + " " + patient.getLastName());
		firstname.setText(patient.getFirstName());
		lastname.setText(patient.getLastName());
		dob.setText("" + patient.getDob());
		bodyTemp.setText("" + patient.getBodyTemp());
		maxBP.setText("" + patient.getBloodPressureHi());
		minBP.setText("" + patient.getBloodPressureLo());
		weight.setText("" + patient.getWeight());
		height.setText("" + patient.getHeight());
		phonenumber.setText(patient.getPhoneNumber());
		email.setText(patient.getEmail());
		address.setText(patient.getAddress());
		insurancenumber.setText(patient.getInsuranceNumber());
		pharmaddress.setText(patient.getPharmacyAddress());
		pharmnumber.setText(patient.getPharmacyPhoneNumber());
		healthHistoryBox.setText(patient.getHealthHistory());
		immunizationsBox.setText(patient.getImmunization());
		pastAppointmentsBox.setText(Helper.appointmentsAsString(patient.getId()));
	}

	@FXML
	private void savePatient() throws SQLException {
		String healthHistory = healthHistoryBox.getText();
		String immunization = immunizationsBox.getText();
		String temp = bodyTemp.getText();
		String maxB = maxBP.getText();
		String minB = minBP.getText();
		String w = weight.getText();
		String h = height.getText();
		try {
			if (Double.parseDouble(temp) > 0) {
				patient.setBodyTemp(Double.parseDouble(temp));
			}

			if (Double.parseDouble(maxB) > 0) {
				patient.setBloodPressureHi(Double.parseDouble(maxB));
			}

			if (Double.parseDouble(minB) > 0) {
				patient.setBloodPressureLo(Double.parseDouble(minB));
			}

			if (Double.parseDouble(w) > 0) {
				patient.setWeight(Double.parseDouble(w));
			}

			if (Double.parseDouble(h) > 0) {
				patient.setHeight(Double.parseDouble(h));
			}

			if (!healthHistory.isBlank()) {
				patient.setHealthHistory(healthHistory);
			}

			if (!immunization.isBlank()) {
				patient.setImmunization(immunization);
			}

			if (!healthHistory.isBlank() || !immunization.isBlank()) {
				if (Helper.updatePatientData(patient)) {
					populatePatientData();
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void logout() throws IOException {
		Main.employeeID = -1;
		Main.patientID = -1;
		Main.setRoot("Login");
	}

	@FXML
	private void goback() throws IOException {
		Main.patientID = -1;
		Main.setRoot("OfficeMenuPage");
	}

	@FXML
	private void sendMessage() throws IOException {
		String message = messageField.getText();
		System.out.print(message);
	}

	@FXML
	private void appointment() throws IOException {
		Main.setRoot("AppointmentPage");
	}

	private void addMessage(String string) throws IOException {
	}
}
