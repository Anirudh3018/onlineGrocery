package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private AnchorPane rootPane;

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
    
    public String emailId;
	
    // Event Listener on Button[#login].onAction	
    @FXML
    void login() {
    	int flag = 0;
		String username = email.getText();
		emailId = email.getText();
		String pwd1 = password.getText();
		System.out.println(username);
		System.out.print(pwd1);
		if (username.length() == 0 || pwd1.length() == 0) {
			invalid.setText("Please enter all values");
			return;
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abc","abc");
			String SQL = "select password from customer where email='" + username + "'";
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
				if(rs.next())	
			{
				String pwd2=rs.getString("password");
				System.out.print(pwd2);
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
				rootPane.getChildren().setAll(root);
			} else {
				invalid.setText("Invalid username/Password");
			}
		}
    	catch(Exception e){
    		e.printStackTrace();
		}
    	

    }


    
    @FXML
    void signup() {
    	try {	
	    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("CreateUser.fxml"));

	    	rootPane.getChildren().setAll(root);
    	}
    	catch(Exception e){
    		e.printStackTrace();
		}

    }


}