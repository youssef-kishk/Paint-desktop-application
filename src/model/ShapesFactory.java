package model;

import javafx.scene.shape.Shape;

public class ShapesFactory {
	public String getShapeType(Shape shape){
		if(shape.getClass().toString().equals("class javafx.scene.shape.Line"))
			return "line";
		else if(shape.getClass().toString().equals("class javafx.scene.shape.Rectangle"))
			return "rectangle";
		else if(shape.getClass().toString().equals("class javafx.scene.shape.Circle"))
			return "circle";
		else if(shape.getClass().toString().equals("class javafx.scene.shape.Ellipse"))
			return "ellipse";
		return"";
	}
}
