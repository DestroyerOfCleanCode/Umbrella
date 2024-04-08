package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignUpController {

    @FXML
    private TextField username_field;
    @FXML
    private TextField firstName_field;
    @FXML
    private TextField lastName_field;
    @FXML
    private DatePicker dob_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private PasswordField confirmPassword_field;
    @FXML
    private Text error_msg;

    @FXML
    private void signUp() {
        String username = username_field.getText();
        String firstName = firstName_field.getText();
        String lastName = lastName_field.getText();
        LocalDate dob = dob_field.getValue();
        String password = password_field.getText();
        String confirmPassword = confirmPassword_field.getText();

        if (username.isBlank() || firstName.isBlank() || lastName.isBlank() || password.isBlank()
                || confirmPassword.isBlank() || dob == null) {
            error_msg.setText("Please fill out all fields");
            return;
        }

        if (dob.isAfter(LocalDate.now().plusDays(1)) || dob.isEqual(LocalDate.now().plusDays(1))) {
            error_msg.setText("Invalid date of birth");
            return;
        }

        if (confirmPassword.equals(password) == false) {
            error_msg.setText("Passwords do not match");
            return;
        }
    }

    @FXML
    private void exit() {
        Helper.exit();
    }

    @FXML
    private void login() throws IOException {
        Main.setRoot("Login");
    }

}
