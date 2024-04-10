package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class OfficeMessagingController {
	@FXML
	private Text greeting;

	@FXML
	private VBox messageVBox;

	@FXML
	public void initialize() throws SQLException {
		greeting.setText(Helper.greetingEmployee(Main.employeeID));
	}

	@FXML
	private void back() throws IOException {
		Main.setRoot("OfficeMenuPage");
	}

	@FXML
	private void logout() throws IOException {
		Main.employeeID = -1;
		Main.setRoot("Login");
	}
}
