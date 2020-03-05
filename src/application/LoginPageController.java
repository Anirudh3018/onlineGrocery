package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginPageController {

    @FXML
    private PasswordField password;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private TextField email;

    @FXML
    void ffffff26() {

    }

    @FXML
    void login() {
    	try {	
	    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
			Stage stg=new Stage();
			Scene scene=new Scene(root,550,710);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stg.setScene(scene);
			stg.show();
    	}
    	catch(Exception e){
    		e.printStackTrace();
		}
    	

    }

//    @FXML
//    void 030100() {
//
//    }
    
    @FXML
    void signup() {
    	try {	
	    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
			Stage stg=new Stage();
			Scene scene=new Scene(root,550,710);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stg.setScene(scene);
			stg.show();
    	}
    	catch(Exception e){
    		e.printStackTrace();
		}

    }

//    @FXML
//    void 030100(ActionEvent event) {
//
//    }

}