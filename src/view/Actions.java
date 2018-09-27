package view;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
public abstract class Actions {	
	public double x=0;
	public double y=0;
	@FXML
	private ColorPicker colorPicker;
	@FXML
	private Pane drawingPane;
	@FXML
	private Button line;
	@FXML
	private Button rectangle;
	@FXML
	private Button circle;
	@FXML
	private Button ellipse;
	@FXML
	private Button undoButton;
	@FXML
	private Button redoButton;
	@FXML 
	private Button editButton;
	@FXML
	private Button openButton;
	@FXML
	private Button saveButton;
	public ColorPicker getColorPicker() {
		return colorPicker;
	}
	public Pane getDrawingPane() {
		return drawingPane;
	}
	public Button getLine() {
		return line;
	}
	public Button getRectangle() {
		return rectangle;
	}
	public Button getCircle() {
		return circle;
	}
	public Button getEllipse() {
		return ellipse;
	}
	public Button getUndoButton() {
		return undoButton;
	}
	public Button getRedoButton() {
		return undoButton;
	}
	public Button getEditButton(){
		return editButton;
	}
	public Button getOpenButton() {
		return openButton;
	}
	public Button getsaveButton() {
		return saveButton;
	}
	
}
