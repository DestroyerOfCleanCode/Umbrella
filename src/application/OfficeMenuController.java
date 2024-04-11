package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class OfficeMenuController {
    @FXML
    private Text greeting;

    @FXML
    public void initialize() throws SQLException {
        greeting.setText(Helper.greetingEmployee(Main.employeeID));
    }

    @FXML
    private void logout() throws IOException {
        Main.employeeID = -1;
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
}
