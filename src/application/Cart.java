package application;
import java.awt.Insets;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Cart extends ListView<String> implements Initializable {
	
	
    @FXML
    private Label heading;

    @FXML
    private ListView<String> itemsList;
   
 ObservableList<String> listView = FXCollections.observableArrayList();
 String item_name;
 String brand;
 String price;
 static int count = 0;


 @FXML
 private ComboBox<String> categoryDropDown;
 
 static class Cell extends ListCell<String>{
	 HBox hbox = new HBox(300);
	 HBox hbox1 = new HBox(20);
	 Button add = new Button("+");
	 Button decrease = new Button("-");
	 Button delete = new Button("");
	 Pane pane = new Pane();
	 Label label = new Label();
	 public Cell() {
		super();
		 label.setMinWidth(300);
		 add.setShape(new Circle(1.5));
		 
		 hbox1.getChildren().addAll(add,decrease,delete);
		 hbox.getChildren().addAll(label,hbox1);
		 hbox.setHgrow(pane, Priority.ALWAYS);
	 }
	 public void updateItem(String name,boolean empty) {
		 super.updateItem(name,empty);
		 setText(null);
		 setGraphic(null);
		 if(name!=null&&!empty) {
			 label.setText(name);
			 setGraphic(hbox);
			}
		 add.setOnAction(new EventHandler<ActionEvent>() { //Function to add item to cart
		     @Override
		     public void handle(ActionEvent event) {
		    	 String item =label.getText();
		    	 String[] parsedItem =item.split("  ");
		    	 System.out.println();
		    	 System.out.println(parsedItem[1]);
		    	 String itemId="";
		    	 try {
		        		Class.forName("oracle.jdbc.driver.OracleDriver");
		        		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abc","abc");
		        		String SQLsub = "select item_qty from cart where item_name='" + parsedItem[1] + "'";
		        		PreparedStatement psub=con.prepareStatement(SQLsub);
		        		ResultSet rsub = psub.executeQuery();
		        		if(rsub.next()) {
		        			count=Integer.parseInt(rsub.getString("item_qty"));
		        		}
		        		System.out.println(count);		        	
		        		psub.close();
		        		rsub.close();
		        	}
		        	catch(Exception e){
		        		System.out.println(e);
		        	}
		     }
});
		 
		 decrease.setOnAction(new EventHandler<ActionEvent>() { //Function to add item to cart
		     @Override
		     public void handle(ActionEvent event) {
		    	 
		      }	   
});
		 delete.setOnAction(new EventHandler<ActionEvent>() { //Function to add item to cart
		     @Override
		     public void handle(ActionEvent event) {
		    			    	
		      }	    	   
}); 
	 }
 }
 public void initialize(URL arg0,ResourceBundle arg1) {
 fetchItems();
 itemsList.setItems(listView);
 itemsList.setCellFactory(param->new Cell());
}
void fetchPrice()
{
	String price="";
	try {  
		 System.out.print("In fetch");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abc","abc");
			String SQL = "select sum(item_qty*item_price) as tot_price from cart";
			PreparedStatement ps=con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();	
			if(rs.next())
			{
				price=rs.getString("tot_price");
				price1.setText(price);
			}
			System.out.println();
			System.out.println(price);
			ps.close();
			rs.close();
		}
		catch(Exception e){
			System.out.println("No items fetched");
		}
}

@FXML 
 void fetchItems() {
	 try {  
		 System.out.print("In fetch");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abc","abc");
			String SQL = "select item_name,item_qty,item_price from cart";
			PreparedStatement ps=con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			listView.clear();
			System.out.print("BEFORE WHILE");
			while(rs.next()) {
				listView.add("x"+rs.getString("item_qty")+"  "+rs.getString("item_name")+" \nRs."+rs.getString("item_price"));
				
			}
			System.out.print("AFTER WHILE");
			
			ps.close();
			rs.close();
		}
		catch(Exception e){
			System.out.println("No items fetched");
		}
 }
@FXML
void back()
{
	try {	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("Categories.fxml"));
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
}
