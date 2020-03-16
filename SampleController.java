package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController {
	private ObservableList<Course> data;
	ObservableList<String> categories = FXCollections.observableArrayList();
	
    @FXML
    private TextField txtId;

    @FXML
    private TableView<Course> tblCourse;    
    
    @FXML
    private ComboBox<String> categoryDropdown;
    
//    @FXML
//    private int index;

    @FXML
    public void initialize() {
//    	index=1;
    	TableColumn tblColCourseId=new TableColumn("Name");
    	tblColCourseId.setMinWidth(300);
    	TableColumn tblstock=new TableColumn("Stock");
    	tblstock.setMinWidth(100);
    	TableColumn add=new TableColumn("");
    	add.setMinWidth(100);
    	TableColumn delete=new TableColumn("");
    	delete.setMinWidth(100);
    	tblCourse.getColumns().addAll(tblColCourseId,tblstock,add,delete);
    	tblColCourseId.setCellValueFactory(new PropertyValueFactory<Course,String>("courseId"));
    	tblstock.setCellValueFactory(new PropertyValueFactory<Course,String>("Stock"));
    	add.setCellValueFactory(new PropertyValueFactory<Course,String>("button"));
    	delete.setCellValueFactory(new PropertyValueFactory<Course,String>("button1"));
    	 fetchCategories();
    	 fetchFilteredItems();
    	 categoryDropdown.getItems().addAll(categories);
    }
    @FXML
    void fetchFilteredItems() {
   	System.out.println(categoryDropdown.getValue());
      onshow(categoryDropdown.getSelectionModel().getSelectedIndex()+1);
      System.out.println(categoryDropdown.getSelectionModel().getSelectedIndex()+1);
    }
    
    @FXML
    void fetchCategories() {
   try {
   	Class.forName("oracle.jdbc.driver.OracleDriver");
   	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abc","abc");
   	String SQL = " select name from category";
   	PreparedStatement ps=con.prepareStatement(SQL);
   	ResultSet rs = ps.executeQuery();
   	while(rs.next()) {
   		categories.add(rs.getString(1));	
   	}
   	ps.close();
   	rs.close();
   }
   catch(Exception e){
		System.out.println("Not Category fetched");
	}
}
      @FXML
    void onshow(int index) {
    	data = FXCollections.observableArrayList();
//    	index=1;
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abc","abc");
    		String sql = "SELECT name,stock from itms where id= "+index;
    		System.out.println(index);
    		ResultSet rs = con.createStatement().executeQuery(sql); 
    		while(rs.next()) {
    			data.add(new Course(rs.getString(1),rs.getString(2)));
    			System.out.print("hello");
    		}
    		tblCourse.getItems().clear();
    		tblCourse.setItems(data);
    		con.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
