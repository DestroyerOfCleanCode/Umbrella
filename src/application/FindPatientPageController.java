package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
    public void initialize() throws SQLException {
        greeting.setText(Helper.greetingEmployee(Main.employeeID));
    }

    @FXML
    private void findpatient() throws IOException, SQLException {
        String firstname = firstname_field.getText();
        String lastname = lastname_field.getText();
        String dob = Helper.dateConvert(dob_field.getValue());

        if (firstname.isBlank() || lastname.isBlank() || dob_field.getValue() == null) {
            error_msg.setText("Please fill in all fields");
            return;
        }

        Patient patient = Helper.fetchPatientData(firstname, lastname, dob);

        if (patient == null) {
            error_msg.setText("Patient Not Found!");
            return;
        }

        Main.patientID = patient.getId();
        Main.setRoot("ExistingPatientsPage");
    }

    @FXML
    private void cancel() throws IOException {
        Main.setRoot("OfficeMenuPage");
    }

    @FXML
    private void logout() throws IOException {
        Main.employeeID = -1;
        Main.patientID = -1;
        Main.setRoot("Login");
    }
}
