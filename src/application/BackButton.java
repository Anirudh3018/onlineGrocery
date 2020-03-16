package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    private Button backButton;
    
    @FXML
    private Button exitButton;

    @FXML
    void back() {
    	try {	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stg=new Stage();
		Scene scene=new Scene(root,800,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stg.setScene(scene);
		stg.show();
    	}catch(Exception e)
		{
		e.printStackTrace();
		}
    }
    @FXML
    void exit() {
    	Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
