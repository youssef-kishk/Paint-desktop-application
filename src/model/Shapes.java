package model;
import java.util.Map;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
public abstract class Shapes extends Shape implements ShapeInterface{
	public abstract Map<String, Double> getAllProperties();
	public abstract void setColor(Paint color);
	public abstract Paint getColor();
	public abstract String getType();
	@SuppressWarnings("restriction")
	public com.sun.javafx.geom.Shape impl_configShape() {return null;}
	
}
