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
    private Label invalid;
	
    // Event Listener on Button[#login].onAction	
    @FXML
    void login() {
    	int flag = 0;
		String username = email.getText();
		String pwd1 = password.getText();
		if (username.length() == 0 || pwd1.length() == 0) {
			invalid.setText("Please enter all values");
			return;
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbs_project",
					"Ankita23");
			String SQL = "select password from customer where email='" + username + "'";
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			/*if (!(rs.next())) // username doesnt exist
			{
				invalid.setText("Username doesn't exist");
				flag = -1; // otherwise gets overwritten by the 'invalid user....' message
			} */
				if(rs.next())	//username exists
			{
				String pwd2=rs.getString("password");
				if (pwd1.equals(pwd2)) {
					flag = 1;
				} 
				else {
					flag = 0;
				}
			}
			if (flag == 1) {
				invalid.setText("");
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Categories.fxml"));
				Stage stg = new Stage();
				Scene scene = new Scene(root, 600, 800);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stg.setScene(scene);
				stg.show();
			} else {
				invalid.setText("Invalid username/Password");
			}
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
