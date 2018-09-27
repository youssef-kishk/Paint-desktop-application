package controller;
import view.Actions;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Stack;

import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.stage.FileChooser;
import model.Shapes;
import model.ShapesFactory;
public abstract class ShapesEngine extends Actions implements DrawingEngine{
	protected ArrayList<Shapes> shapesArray = new ArrayList<Shapes>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Stack<Shape> undoHistory = new Stack();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Stack<Shape> redoHistory = new Stack();
	public int check=0;
	//search for the existing of certain shape
	public abstract int searchShape();
	//search within the undo stack for certain shape
	public abstract int searchUndoHistory(Node node);
	public abstract void editLine(int check,MouseEvent e);
	public abstract void editRectangle(int check,MouseEvent e);
	public abstract void editCircle(int check,MouseEvent e);
	public abstract void editEllipse(int check,MouseEvent e);
	
	public String getPressedButtonType(){
		if(getLine().isPressed())
			return "line";
		else if(getRectangle().isPressed())
			return "rectangle";
		else if(getCircle().isPressed())
			return "circle";
		else if(getEllipse().isPressed())
			return "ellipse";
		return"";
	}
	public String getShapeType(Shape shape){
		ShapesFactory factory = new ShapesFactory();
		return factory.getShapeType(shape);
	}
	public void deleteShape(){
		getDrawingPane().setOnMousePressed(e->{
			x=e.getX();
			y=e.getY();
			int check = searchShape();
			try{
			if(check!=-1&&!getDrawingPane().getChildren().isEmpty()){
				undoHistory.remove(searchUndoHistory(getDrawingPane().getChildren().get(check)));
				getDrawingPane().getChildren().remove(check);
				shapesArray.remove(check);
			}
			}
			catch(Exception ex){
				getDrawingPane().getChildren().clear();
			}
		});
		
	}
	public void fillShapeColor(){
		getDrawingPane().setOnMousePressed(e->{
			x=e.getX();
			y=e.getY();
			int check = searchShape();
			try{
			if(check!=-1){
				shapesArray.get(check).setColor(getColorPicker().getValue());
				((Shape)getDrawingPane().getChildren().get(check)).setFill(getColorPicker().getValue());
			}
			}
			catch(Exception ex){
				getDrawingPane().getChildren().clear();
			}
		});
	}		
	public void undo(){
			if(!undoHistory.isEmpty()){
				redoHistory.push(undoHistory.pop());
				getDrawingPane().getChildren().remove(redoHistory.peek());
			}
	}
	public void redo(){
		if(!redoHistory.isEmpty()){
			undoHistory.push(redoHistory.pop());
			getDrawingPane().getChildren().add(undoHistory.peek());
		}
	}
	int count=0;
	public void editShape(){
		count =0;
		getDrawingPane().setOnMousePressed(e->{
			if(count==0){
				count=1;
				x=e.getX();
				y=e.getY();
			}
			else if(count==1){
			int check = searchShape();
			try{
			if(check!=-1){
				if(getShapeType((Shape) getDrawingPane().getChildren().get(check)).equals("line"))
					editLine(check,e);
				else if(getShapeType((Shape) getDrawingPane().getChildren().get(check)).equals("rectangle")) 
					editRectangle(check,e);
				else if(getShapeType((Shape) getDrawingPane().getChildren().get(check)).equals("circle")) 
					editCircle(check,e);
				else if(getShapeType((Shape) getDrawingPane().getChildren().get(check)).equals("ellipse")) 
					editEllipse(check,e);
			}
			}
			catch(Exception ex){
				getDrawingPane().getChildren().clear();
			}
			count=0;
			}
		});
	}
	public void saveDrawings(){
        FileChooser savefile = new FileChooser();
        savefile.setTitle("Save File");       
        File fileXML = new File("save.xml");
        File fileJSON = new File("save.JSON");
        if (fileXML != null&&fileJSON!=null) {
            try {
                WritableImage writableImage = new WritableImage(1080, 790);
                getDrawingPane().snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", fileXML);
                ImageIO.write(renderedImage, "png", fileJSON);
            } catch (IOException ex) {
                System.out.println("Error!");
            }
        }
	}
	/*defects:when opening drawing we can't edit it and any new shape added can't be edited*/
	public void openDrawings(){
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Open File");
        File file = new File("save.xml");
        if (file != null) {
            try {
                InputStream io = new FileInputStream(file);
                Image img = new Image(io);
                ImageView image= new ImageView(img);
                getDrawingPane().getChildren().add(image);
            } catch (IOException ex) {
                System.out.println("Error!");
            }
        }
	}
}