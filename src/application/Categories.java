package application;
import java.awt.Insets;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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

    @FXML
    private MenuButton categoryDropDown;
 
 ObservableList<String> listView = FXCollections.observableArrayList("Nidhi","Anirudh","Ankita","newItem1","newItem2","newItem3");
 
 static class Cell extends ListCell<String>{
	 HBox hbox = new HBox(300);
	 HBox hbox1 = new HBox(20);
	 Button add = new Button("ADD");
	 Button delete = new Button("DELETE");
	 Pane pane = new Pane();
	 Label label = new Label();
	 
	 public Cell() {
		 super();
		 label.setMinWidth(80);
		 hbox1.getChildren().addAll(add,delete);
		 hbox.getChildren().addAll(label,hbox1);
		 hbox.setHgrow(pane, Priority.ALWAYS);
		 
		
		 
	 }
	 public void updateItem(String name,boolean empty) {
		 super.updateItem(name, empty);
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
 itemsList.setCellFactory(param->new Cell());
 
}
}
