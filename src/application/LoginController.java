package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Text error_msg;

    @FXML
    private void exit() {
        Helper.exit();
    }

    @FXML
    private void login() throws SQLException, IOException {
        String username = username_field.getText();
        String password = password_field.getText();

        if (username.isBlank() || password.isBlank()) {
            error_msg.setText("Please fill in all fields");
            return;
        }

        int ID = Helper.authenticate(username, password);

        if (ID == -1) {
            error_msg.setText("Incorrect username or password");
            return;
        }

        String type = Helper.fetchTypeFromId(ID);
        error_msg.setText("");

        if (type.equals("Patient")) {
            Main.patientID = ID;
            Main.setRoot("PatientView");
            return;
        }

        Main.employeeID = ID;
        Main.setRoot("OfficeMenuPage");
    }

    @FXML
    private void signUp() throws IOException {
        Main.setRoot("SignUp");
    }
}
