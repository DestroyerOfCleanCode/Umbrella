package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AppointmentController {
	@FXML
	private Text greeting;
	@FXML
	private Text patientName;
	
	@FXML
	private TextField heightField;
	@FXML
	private TextField weightField;
	@FXML
	private TextField bodyTempField;
	@FXML
	private TextField bpHiField;
	@FXML
	private TextField bpLoField;
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
	
	@FXML
    private void logout() throws IOException {
        Main.setRoot("Login");
        Main.id = 0;
    }
	
	@FXML
    private void goback() throws IOException {
		String height = heightField.getText();
		String weight = weightField.getText();
		String bodyTemp = bodyTempField.getText();
		String bpHi = bpHiField.getText();
		String bpLo = bpLoField.getText();
		String allergies = allergiesField.getText();
		String healthConcerns = healthConcernsField.getText();
		String eyes = physicalResultsField.getText();
		String doctorConcerns = doctorConcernsField.getText();
		String prescriptions = prescriptionsField.getText();
		System.out.println(height + ", " + weight + ", " + bodyTemp + ", " + bpHi + ", " + bpLo + ", " +
				 allergies + ", " + healthConcerns + ", " + eyes + ", " + doctorConcerns + ", " + prescriptions);
        Main.setRoot("ExistingPatientsPage");
    }
	
	@FXML
    private void endAppointment() throws IOException {
		String height = heightField.getText();
		String weight = weightField.getText();
		String bodyTemp = bodyTempField.getText();
		String bpHi = bpHiField.getText();
		String bpLo = bpLoField.getText();
		String allergies = allergiesField.getText();
		String healthConcerns = healthConcernsField.getText();
		String eyes = physicalResultsField.getText();
		String doctorConcerns = doctorConcernsField.getText();
		String prescriptions = prescriptionsField.getText();
		System.out.println(height + ", " + weight + ", " + bodyTemp + ", " + bpHi + ", " + bpLo + ", " +
				 allergies + ", " + healthConcerns + ", " + eyes + ", " + doctorConcerns + ", " + prescriptions);
        Main.setRoot("ExistingPatientsPage");
    }
}
