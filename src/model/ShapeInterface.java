package model;
import java.util.Map;
import javafx.scene.paint.Paint;
public interface ShapeInterface{
	public void setPosition();
	public Map<String, Double> getAllProperties();
	public void setColor(Paint color);
	public Paint getColor();
	public  String getType();
}
