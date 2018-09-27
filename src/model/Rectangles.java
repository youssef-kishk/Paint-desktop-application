package model;
import java.util.HashMap;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
public class Rectangles extends Shapes{
	private double edgeX;
	private double edgeY;
	private double width;
	private double height;
	private Paint color=Color.TRANSPARENT;
	public double getEdgeX() {
		return edgeX;
	}
	public void setEdgeX(double edgeX) {
		this.edgeX = edgeX;
	}
	public double getEdgeY() {
		return edgeY;
	}
	public void setEdgeY(double edgeY) {
		this.edgeY = edgeY;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Paint getColor() {
		return color;
	}
	public void setColor(Paint color) {
		this.color = color;
	}
	public void setPosition(double edgeX, double edgeY, double width, double height){
		this.edgeX = edgeX;
		this.edgeY = edgeY;
		this.width = width;
		this.height = height;
	}
	public HashMap<String, Double> getAllProperties(){
		HashMap<String, Double>  map = new HashMap<String, Double> ();
		map.put("EdgeX", edgeX);
		map.put("EdgeY", edgeY);
		map.put("Width", width);
		map.put("Height",height);
		return map ;
	}
	public void setPosition(){}
	public String getType(){
		return "Rectangles";
	}
	//check if mouse click position is on that shape or not
	public static boolean contains(Shapes shape,double x,double y){
		Rectangle temp = new Rectangle(((Rectangles) shape).getEdgeX(),((Rectangles) shape).getEdgeY(),
								((Rectangles) shape).getWidth(),((Rectangles) shape).getHeight());
		if(temp.contains(x, y))
			return true;
		return false;
	}
}
