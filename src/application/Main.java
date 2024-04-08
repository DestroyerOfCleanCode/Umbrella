package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
    private static Scene scene;
    private static double xOffset, yOffset;
	
	@Override
	public void start(Stage stage) {
		try {
			HBox root = (HBox) FXMLLoader.load(getClass().getResource("Login.fxml"));
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			// This allows window to be dragged
	        root.setOnMousePressed(event -> {
	            xOffset = stage.getX() - event.getScreenX();
	            yOffset = stage.getY() - event.getScreenY();
	        });

	        root.setOnMouseDragged(event -> {
	            stage.setX(event.getScreenX() + xOffset);
	            stage.setY(event.getScreenY() + yOffset);
	        });
			
	     // This disable window border and buttons
	        scene.setFill(Color.TRANSPARENT);
	        stage.initStyle(StageStyle.TRANSPARENT);

	        stage.setScene(scene);

	        // Disable window resize function
	        stage.setResizable(false);
	        
	        stage.setScene(scene);
	        stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

	public static void main(String[] args) {
		launch(args);
	}
}
