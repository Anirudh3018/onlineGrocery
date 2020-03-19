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

public class Categories extends ListView<String> implements Initializable {
	

    @FXML
    private AnchorPane Cart;
    @FXML
    private Label heading;

    @FXML
    private ListView<String> itemsList;
   
 ObservableList<String> listView = FXCollections.observableArrayList();
 ObservableList<String> categories = FXCollections.observableArrayList();
 String item_name;
 String brand;
 String price;
 static int cart_id = 0;


 @FXML
 private ComboBox<String> categoryDropDown;
 
 static class Cell extends ListCell<String>{
	 HBox hbox = new HBox(300);
	 HBox hbox1 = new HBox(20);
	 Button add = new Button("+");
	 
	 Button qty=new Button("0");
	 
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
		    	 
			     
			 //set text for qty button    
			 Connection con1;
					try {
						con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
								"dbs_project","Ankita23");
					
					String SQL1 = "select * from cart where item_name='"+parsedItem[1]+"'";
					PreparedStatement ps1 = con1.prepareStatement(SQL1);
					ResultSet rs1 = ps1.executeQuery();
					if (rs1.next())
					{
					int q=Integer.parseInt(rs1.getString("item_qty"))+1;
					qty.setText(q+"");
					}
					else qty.setText("1");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					    
			     
			     
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
			 
			 //set text for qty button  
			 Connection con1;
					try {
						con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
								"dbs_project","Ankita23");
					
					String SQL1 = "select * from cart where item_name='"+parsedItem[0]+"'";
					PreparedStatement ps1 = con1.prepareStatement(SQL1);
					ResultSet rs1 = ps1.executeQuery();
					if (rs1.next())
					{
					int q=Integer.parseInt(rs1.getString("item_qty"))-1;
					qty.setText(q+"");
					}
					else qty.setText("1");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					    
			     
			     
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
				   
				   //if qty=0,delete it
						
						SQL="select * from cart where item_id="+Integer.parseInt(itemId);
						ps = con.prepareStatement(SQL);
						rs = ps.executeQuery();					
												
						if (rs.next())
						{
						System.out.print("qty is "+rs.getString("item_qty")+"\n");
						if(rs.getInt("item_qty")==0)
						{
							SQL = "delete from cart where item_id="+ Integer.parseInt(itemId);
							ps = con.prepareStatement(SQL);
							rs = ps.executeQuery();
						}
						}
				   
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
			     
			 qty.setText(0+"");
					    
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
 itemsList.setItems(listView);
 fetchCategories();
 fetchFilteredItems();
 categoryDropDown.getItems().addAll(categories); 
 itemsList.setCellFactory(param->new Cell());
}

 @FXML
 void fetchFilteredItems() {
   fetchItems(categoryDropDown.getSelectionModel().getSelectedIndex()+1);
 }
 
 @FXML
 void fetchCategories() {
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nidhi","ilmm2526");
	String SQL = " select category_name from categories";
	PreparedStatement ps=con.prepareStatement(SQL);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		categories.add(rs.getString("category_name"));
	
	}
	ps.close();
	rs.close();
}
catch(Exception e){
	System.out.println("Not Category fetched");
}

 }
 
 
 
 void fetchItems(int index) {
	 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nidhi","ilmm2526");
			String SQL = "select item_name,brand,price from items where category_id ="+index;
			PreparedStatement ps=con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			listView.clear();
			while(rs.next()) {
				listView.add(rs.getString("brand")+"  "+rs.getString("item_name")+"  Rs."+rs.getString("price"));
				
			}
			ps.close();
			rs.close();
		}
		catch(Exception e){
			System.out.println("Not Category fetched");
		}
 }
 
 @FXML
 void goToCart(ActionEvent event) {
	 try {	
	    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("Cart.fxml"));
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
 
}
