package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MakeNewPatientPageController {
	
	
    @FXML
    private void cancel() throws IOException {
    	Main.setRoot("OfficeMenuPage");
    }
}
