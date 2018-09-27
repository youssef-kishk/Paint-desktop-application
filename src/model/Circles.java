package model;
import java.util.HashMap;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
public class Circles extends Shapes{
	private double centerX;
	private double centerY;
	private double radius;
	private Paint color=Color.TRANSPARENT;
	public double getCenterX() {
		return centerX;
	}
	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}
	public double getCenterY() {
		return centerY;
	}
	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Paint getColor() {
		return color;
	}
	public void setColor(Paint color) {
		this.color = color;
	}
	public void setPosition(double centerX, double centerY, double radius){
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}
	public HashMap<String, Double> getAllProperties(){
		HashMap<String, Double>  map = new HashMap<String, Double> ();
		map.put("CenterX", centerX);
		map.put("CenterY", centerY);
		map.put("Radius", radius);
		return map ;
	}
	
	public void setPosition() {}
	public String getType(){
		return "Circles";
	}
//	public static boolean searchShape(ArrayList<Shapes> array,double x,double y){
//		for(int i=0;i<array.size();i++){
//			if(array.get(i).contains(array.get(i),x, y))
//				return true;
//		}
//		return false;
//	}
	//check if mouse click position is on that shape or not
	public static boolean contains(Shapes shape,double x,double y){
		Circle temp = new Circle(((Circles) shape).getCenterX(),((Circles) shape).getCenterY(),
								((Circles) shape).getRadius());
		if(temp.contains(x, y))
			return true;
		return false;
	}
}
