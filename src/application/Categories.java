package application;
import java.awt.Insets;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.*;

public class Categories extends ListView<String> implements Initializable {
	
	
    @FXML
    private Label heading;

    @FXML
    private ListView<String> itemsList;
   
 ObservableList<String> listView = FXCollections.observableArrayList();
 ObservableList<String> categories = FXCollections.observableArrayList();
 String price;

 @FXML
 private ComboBox<String> categoryDropDown;
 static class Cell extends ListCell<String>{
	 HBox hbox = new HBox(300);
	 HBox hbox1 = new HBox(20);
	 Button add = new Button("ADD");
	 Button delete = new Button("DELETE");
	 Pane pane = new Pane();
	 Label label = new Label();
	 Label label1 = new Label();
	 
	 
	 public Cell(String price) {
		 super();
		 
		 label.setMinWidth(100);
		 hbox1.getChildren().addAll(add,delete);
		 hbox.getChildren().addAll(label,label1,hbox1);
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
	 }
	 
	 
 }
 public void initialize(URL arg0,ResourceBundle arg1) {
 itemsList.setItems(listView);
 fetchCategories();
 fetchFilteredItems();
 categoryDropDown.getItems().addAll(categories); 
 itemsList.setCellFactory(param->new Cell(price));
 
}
 @FXML
 void fetchFilteredItems() {
	System.out.print(categoryDropDown.getValue());
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
				
				listView.add(rs.getString("item_name"));
				price = " ";
				price = rs.getString("price");
			}
			System.out.print(listView+price);
			ps.close();
			rs.close();
		}
		catch(Exception e){
			System.out.println("Not Category fetched");
		}
 }
 
}
