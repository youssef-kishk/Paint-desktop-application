package model;
import java.util.HashMap;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
public class Lines extends Shapes{
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	private Paint color=Color.TRANSPARENT;
	public Paint getColor() {
		return color;
	}
	public void setColor(Paint color) {
		this.color = color;
	}
	public double getStartX() {
		return startX;
	}
	public void setStartX(double startX) {
		this.startX = startX;
	}
	public double getStartY() {
		return startY;
	}
	public void setStartY(double startY) {
		this.startY = startY;
	}
	public double getEndX() {
		return endX;
	}
	public void setEndX(double endX) {
		this.endX = endX;
	}
	public double getEndY() {
		return endY;
	}
	public void setEndY(double endY) {
		this.endY = endY;
	}
	public void setPosition(double startX, double startY, double endX, double endY){
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	public HashMap<String, Double> getAllProperties(){
		HashMap<String, Double>  map = new HashMap<String, Double> ();
		map.put("StartX", startX);
		map.put("StartY", startY);
		map.put("EndX", endX);
		map.put("EndY",endY);
		return map ;
	}	
	public void setPosition() {}
	public String getType(){
		return "Lines";
	}
	//check if mouse click position is on that shape or not
	public static boolean contains(Shapes l,double x,double y){
		Line temp = new Line(((Lines) l).getStartX(),((Lines) l).getStartY(),((Lines) l).getEndX(),((Lines) l).getEndY());
		
		if(temp.contains(x, y))
			return true;
		return false;
	}


}
