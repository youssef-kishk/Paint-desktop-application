package model;
import java.util.HashMap;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
public class Ellipses extends Shapes{
	private double centerX;
	private double centerY;
	private double radiusX;
	private double radiusY;
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
	public double getRadiusX() {
		return radiusX;
	}
	public void setRadiusX(double radiusX) {
		this.radiusX = radiusX;
	}
	public double getRadiusY() {
		return radiusY;
	}
	public void setRadiusY(double radiusY) {
		this.radiusY = radiusY;
	}
	public Paint getColor() {
		return color;
	}
	public void setColor(Paint color) {
		this.color = color;
	}
	public void setPosition(double centerX, double centerY, double radiusX, double radiusY) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.radiusX = radiusX;
		this.radiusY = radiusY;
	}
	public HashMap<String, Double> getAllProperties(){
		HashMap<String, Double>  map = new HashMap<String, Double> ();
		map.put("CenterX", centerX);
		map.put("CenterY", centerY);
		map.put("RadiusX", radiusX);
		map.put("RadiusY", radiusY);
		return map ;
	}
	public void setPosition() {}
	public String getType(){
		return "Ellipses";
	}
	
	//check if mouse click position is on that shape or not
	public static boolean contains(Shapes shape,double x,double y){
		Ellipse temp = new Ellipse(((Ellipses) shape).getCenterX(),((Ellipses) shape).getCenterY(),
								((Ellipses) shape).getRadiusX(),((Ellipses) shape).getRadiusY());
		if(temp.contains(x, y))
			return true;
		return false;
	}
}
