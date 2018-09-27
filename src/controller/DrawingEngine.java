package controller;
import javafx.scene.shape.Shape;
public interface DrawingEngine {
	//return type of the shape ex:Line,rectangle,.....
	public String getShapeType(Shape shape);
	//add new Shape to drawing page
	public void addShape();
	//delete an existing shape
	public void deleteShape();
	//fill the color of certain existing shape
	public void fillShapeColor();
	//undo the last drawing action
	public void undo();
	//redo the last drawing action
	public void redo();
	//edit the dimensions of an existing shape
	public void editShape();
	//save current drawing to both .xml &.json files
	public void saveDrawings();
	//copy data of file to drawing page
	public void openDrawings();
}
