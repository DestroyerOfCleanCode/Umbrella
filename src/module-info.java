module Umbrella {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires bcrypt;
	
	opens application to javafx.graphics, javafx.fxml;
}
