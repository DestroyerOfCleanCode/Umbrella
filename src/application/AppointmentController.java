package application;

import java.io.IOException;

import javafx.fxml.FXML;
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
	private TextField allergiesField;
	@FXML
	private TextField healthConcernsField;
	
	@FXML
	private TextField eyesField;
	@FXML
	private TextField throatField;
	@FXML
	private TextField stomachField;
	@FXML
	private TextField earsField;
	@FXML
	private TextField heartField;
	@FXML
	private TextField lungsField;
	
	@FXML
	private TextField concernsField;
	@FXML
	private TextField prescriptionsField;
	
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
		String eyes = eyesField.getText();
		String throat = throatField.getText();
		String ears = earsField.getText();
		String heart = heartField.getText();
		String lungs = lungsField.getText();
		String stomach = stomachField.getText();
		String concerns = concernsField.getText();
		String prescriptions = prescriptionsField.getText();
		System.out.println(height + ", " + weight + ", " + bodyTemp + ", " + bpHi + ", " + bpLo + ", " +
				 allergies + ", " + healthConcerns + ", " + eyes + ", " + throat + ", " + ears + ", " + heart + ", " +
				 lungs + ", " + stomach + ", " + concerns + ", " + prescriptions);
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
		String eyes = eyesField.getText();
		String throat = throatField.getText();
		String ears = earsField.getText();
		String heart = heartField.getText();
		String lungs = lungsField.getText();
		String stomach = stomachField.getText();
		String concerns = concernsField.getText();
		String prescriptions = prescriptionsField.getText();
		System.out.println(height + ", " + weight + ", " + bodyTemp + ", " + bpHi + ", " + bpLo + ", " +
				 allergies + ", " + healthConcerns + ", " + eyes + ", " + throat + ", " + ears + ", " + heart + ", " +
				 lungs + ", " + stomach + ", " + concerns + ", " + prescriptions);
        Main.setRoot("ExistingPatientsPage");
    }
}
