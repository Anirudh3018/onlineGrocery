package application;
import java.awt.Insets;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

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

    @FXML
    private Button modify;

    @FXML
    private Button placeOrder;

    @FXML
    private Label amountSummary;
   
 static ObservableList<String> listView = FXCollections.observableArrayList();
 static ObservableList<String> listViewSub = FXCollections.observableArrayList();
 String item_name;
 String brand;
 String price;
 static int cart_id = 0;
 static int orderId=0;


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
		 
		 decrease.setShape(new Circle(1.5));
		 delete.setShape(new Circle(1.5));
		 Image image = new Image(getClass().getResourceAsStream("delete.png"));
			ImageView imageView = new ImageView(image);

			imageView.setFitWidth(20);

			imageView.setFitHeight(20);
		 delete.setGraphic(imageView);
		 
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
//		         System.out.println(parsedItem[0]); //brand
//		         System.out.println(parsedItem[1]); //itemName
//		         System.out.println(parsedItem[2]); //price
		    	 
		         int qty = 1;
		         String itemId="";
		         String actualPrice="";
		         
		         try {
		        		Class.forName("oracle.jdbc.driver.OracleDriver");
		        		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nidhi","ilmm2526");
		        		String SQLsub = "select item_id,price from items where item_name='" + parsedItem[1] + "'";
		        		PreparedStatement psub=con.prepareStatement(SQLsub);
		        		ResultSet rsub = psub.executeQuery();
		        		System.out.print("RS");
		        		if(rsub.next()) {
		        			 itemId= rsub.getString("item_id");
		        			  actualPrice = rsub.getString("price"); 
		        		}
		        		psub.close();
		        		rsub.close();
		        		
		        		String SQL="declare  \r\n" + 
		        				"Id number(5):="+Integer.parseInt(itemId)+";\r\n" + 
		        				"flag number(1);\r\n" + 
		        				"CURSOR c1 is select item_id from cart;\r\n" + 
		        				"begin \r\n" + 
		        				"flag:=0;\r\n" + 
		        				"for itemIds in c1\r\n" + 
		        				"loop \r\n" + 
		        				"if itemIds.item_id =Id then\r\n" + 
		        				"flag := 1;\r\n" + 
		        				"EXIT;\r\n" + 
		        				"else \r\n" + 
		        				"flag := 0;\r\n" + 
		        				"end if;\r\n" + 
		        				"end loop;\r\n" + 
		        				"if flag =1 then\r\n" + 
		        				"update cart set item_qty = item_qty+1 where item_id =Id;\r\n" + 
		        				"elsif flag =0 then\r\n" + 
		        				"insert into cart values("+cart_id+","+Integer.parseInt(itemId)+",'"+parsedItem[1]+"',"+qty+","+Integer.parseInt(actualPrice)+");\r\n" + 
		        				"end if;\r\n" + 
		        				"end; ";
		        		PreparedStatement ps=con.prepareStatement(SQL);
		        		ResultSet rs = ps.executeQuery();
		        		fetchItems();
		        		System.out.println("Added to cart");
		        		ps.close();
		        		rs.close();
		        	}
		        	catch(Exception e){
		        		System.out.println(e);
		        	}
		     }
		 });
		 
		 decrease.setOnAction(new EventHandler<ActionEvent>() { //Function to add item to cart
		     @Override
		     public void handle(ActionEvent event) {
		    	 
		    	 String item =label.getText();
		    	 String[] parsedItem =item.split("  ");
		    	 String itemId=""; 
		    	   try {
		    		   
		        		Class.forName("oracle.jdbc.driver.OracleDriver");
		        		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nidhi","ilmm2526");
		        		String SQLsub = "select item_id from items where item_name='" + parsedItem[1] + "'";
		        		PreparedStatement psub=con.prepareStatement(SQLsub);
		        		ResultSet rsub = psub.executeQuery();
		        		if(rsub.next()) {
		        			 itemId= rsub.getString("item_id");
		        		}
		        		
		        		String SQL = "update cart set item_qty = item_qty-1 where item_id ="+Integer.parseInt(itemId);
		        		PreparedStatement ps=con.prepareStatement(SQL);
		        		ResultSet rs = ps.executeQuery();
		        		fetchItems();
		        		System.out.println("Decreased to cart");
		        		ps.close();
		        		rs.close();
		        		
		     }
		    	   catch(Exception e) {
		    		   System.out.print("Couldnt decrement from cart");
		    		   }
		    	   }
		    	   
});
		 delete.setOnAction(new EventHandler<ActionEvent>() { //Function to add item to cart
		     @Override
		     public void handle(ActionEvent event) {
		    	 
		    	 String item =label.getText();
		    	 String[] parsedItem =item.split("  ");
		    	 String itemId=""; 
		    	   try {
		        		Class.forName("oracle.jdbc.driver.OracleDriver");
		        		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nidhi","ilmm2526");
		        		String SQLsub = "select item_id from items where item_name='" + parsedItem[1] + "'";
		        		PreparedStatement psub=con.prepareStatement(SQLsub);
		        		ResultSet rsub = psub.executeQuery();
		        		if(rsub.next()) {
		        			 itemId= rsub.getString("item_id");
		        		}
		        		
		        		String SQL = "delete from cart where item_id ="+Integer.parseInt(itemId);
		        		PreparedStatement ps=con.prepareStatement(SQL);
		        		ResultSet rs = ps.executeQuery();
		        		fetchItems();
		        		System.out.println("Deleted from cart");
		        		ps.close();
		        		rs.close();
		        		
		     }
		    	   catch(Exception e) {
		    		   System.out.print("Couldnt delete from cart");
		    		   }
		    	   }
		    	   
});
		 
		 
	 }
	 
	 
 }
 public void initialize(URL arg0,ResourceBundle arg1) {
 fetchItems();
 itemsList.setItems(listView);
 itemsList.setCellFactory(param->new Cell());
}


@FXML 
 static void fetchItems() {
	 try {  
		 System.out.print("In fetch");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nidhi","ilmm2526");
			String SQL = "select item_name,item_qty,item_price from cart";
			PreparedStatement ps=con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			listView.clear();
			System.out.print("BEFORE WHILE");
			while(rs.next()) {
       		listView.add("x"+rs.getString("item_qty")+"  "+rs.getString("item_name")+"  \nRs."+rs.getString("item_price"));
				
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
void modify(ActionEvent event) {
	try {	
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("Categories.fxml"));
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

@FXML
void placeOrder(ActionEvent event) {
	 try { 
		 LoginPageController emailObj = new LoginPageController(); 
		 System.out.print(emailObj.emailId); //data fetched from login when login happens
		 System.out.print("In fetch");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nidhi","ilmm2526");
			String SQL = "declare\r\n" + 
					"CURSOR c2 is select cust_id,items.item_id,cart.item_name,cart.item_price,cart.item_qty from items,cart,customer where items.item_name=cart.item_name and email='jessSingh@gmail.com'; \r\n" +//change email to email='"+emailObj.emailId+"' 
					"order_id number(6):=0;\r\n" + 
					"cust_id number(6):=1;\r\n" + 
					"begin\r\n" + 
					"for item in c2\r\n" + 
					"loop\r\n" + 
					"insert into order_history values("+orderId+",item.item_id,'item.item_name',item.item_qty,item.item_price,item.cust_id); \r\n" + 
					"end loop;\r\n" + 
					"delete from cart;\r\n"+    //delete from cart after sending order to order_history
					"end;";
			PreparedStatement ps=con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			//TODO also direct to orderSummary page;
			//TODO add cart subtotal
			System.out.println("Order placed");
			orderId = orderId+1;
			ps.close();
			rs.close();
		}
		catch(Exception e){
			System.out.println("Order Not placed");
		}
}

 
}
