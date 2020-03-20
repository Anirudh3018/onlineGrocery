package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreateUser {
	int cust_id = 0;
	
	@FXML
	private AnchorPane rootPane;

    @FXML
    private TextField firstname;

    @FXML
    private PasswordField password;

    @FXML
    private TextField flatno;

    @FXML
    private TextField city;

    @FXML
    private TextField street;

    @FXML
    private TextField locality;

    @FXML
    private Button create;

    @FXML
    private TextField email;

    @FXML
    private TextField lastname;
    

    @FXML
    private TextField mobileno;

    @FXML
    void createaccount() {
    	try{
    		cust_id = cust_id+1;
    		Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abc","abc");
			String _firstname = firstname.getText();
			String _lastname = lastname.getText();
			String _mobileno = mobileno.getText();
			String _email = email.getText();
			String _password = password.getText();
			String _flatno = flatno.getText();
			String _city = city.getText();
			String _street = street.getText();
			String _locality = locality.getText();
			Integer phone =Integer.parseInt(_mobileno);
			String SQL="insert into customer values("+cust_id+",'"+_firstname+"','"+_lastname+"',"+phone+",'"+_email+"','"+_password+"','"+_flatno+"','"+_street+"','"+_locality+"','"+_city+"')";
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.executeQuery();
			System.out.println("USER CREATED");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    @FXML
    void loginPage()
    {
    	try {	
	    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("LoginPage.fxml"));

	    	rootPane.getChildren().setAll(root);
    	}
    	catch(Exception e){
    		e.printStackTrace();
		}
    }



}