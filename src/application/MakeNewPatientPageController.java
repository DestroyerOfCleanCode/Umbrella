package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class MakeNewPatientPageController {
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
    private void confirm() throws IOException {
        String firstName = firstname_field.getText();
        String lastName = lastname_field.getText();
        String dob = Helper.dateConvert(dob_field.getValue());

        if (firstName.isBlank() || lastName.isBlank() || dob_field.getValue() == null) {
            error_msg.setText("Please fill in all fields");
            return;
        }

        String username = Helper.generateUsername(firstName, lastName);
        String password = Helper.generatePassword();

        Helper.createPatientAccount(username, password, firstName, lastName, dob);

        error_msg.setFill(Paint.valueOf("#0d74ca"));
        error_msg.setText("An account for this patient has been created with username: " + username + " and password: "
                + password);
    }

    @FXML
    private void cancel() throws IOException {
        Main.setRoot("OfficeMenuPage");
    }

    @FXML
    private void logout() throws IOException {
        Main.employeeID = -1;
        Main.setRoot("Login");
    }
}
