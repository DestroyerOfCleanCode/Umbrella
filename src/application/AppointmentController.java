package application;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class AppointmentController {
	@FXML
	private Text greeting;
	@FXML
	private Text patientName;
	@FXML
	private DatePicker doa;
	@FXML
	private TextArea allergiesField;
	@FXML
	private TextArea healthConcernsField;

	@FXML
	private TextArea physicalResultsField;

	@FXML
	private TextArea doctorConcernsField;
	@FXML
	private TextArea prescriptionsField;

	public void initialize() throws SQLException {
		Patient patient = Helper.fetchPatientData(Main.patientID);
		greeting.setText(Helper.greetingEmployee(Main.employeeID));
		patientName.setText(patient.getFirstName() + " " + patient.getLastName());
	}

	@FXML
	private void logout() throws IOException {
		Main.employeeID = -1;
		Main.patientID = -1;
		Main.setRoot("Login");
	}

	@FXML
	private void goback() throws IOException, SQLException {
		LocalDate date = doa.getValue();
		String allergies = allergiesField.getText();
		String healthConcerns = healthConcernsField.getText();
		String physExam = physicalResultsField.getText();
		String doctorConcerns = doctorConcernsField.getText();
		String prescriptions = prescriptionsField.getText();

		if (date == null) {
			return;
		}

		Helper.createAppointment(date, Main.patientID, Main.employeeID, allergies, healthConcerns, physExam,
				doctorConcerns, prescriptions);

		Main.setRoot("ExistingPatientsPage");
	}

	@FXML
	private void endAppointment() throws IOException {
		Main.setRoot("ExistingPatientsPage");
	}
}
