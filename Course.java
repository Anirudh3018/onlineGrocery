package application;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class Course {
	private StringProperty courseId;
	private StringProperty Stock;
	private Button button;
	private Button button1;
	
	public void setCourseId(String cid)
	{
		courseId.set(cid);
	}
	public void setStock(String stock)
	{
		Stock.set(stock);
	}
	public String getCourseId()
	{
		return courseId.get();
	}
	
	public String getStock()
	{
		return Stock.get();
	}
	
	public void setButton(Button button)
	{
		this.button=button;
	}
	
	public Button getButton()
	{
		return button;
	}
	
	public void setButton1(Button button1)
	{
		this.button1=button1;
	}
	
	public Button getButton1()
	{
		return button1;
	}
	public Course(String cid,String stock)
	{
		courseId = new SimpleStringProperty(cid);
		Stock =new SimpleStringProperty(stock);
		this.button=new Button("ADD");
		this.button1=new Button("DEL");
	}
	
}
