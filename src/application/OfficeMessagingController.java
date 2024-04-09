package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class OfficeMessagingController {
	@FXML
	private Text greeting;
	
	@FXML
	private VBox messageVBox;
	
	@FXML
    private void back() throws IOException {
        System.out.print("back pressed");
        Main.setRoot("OfficeMenuPage");
    }
	
	@FXML
    private void logout() throws IOException {
        System.out.print("logout pressed");
    	Main.id = 0;
    	Main.setRoot("Login");
    }
}
