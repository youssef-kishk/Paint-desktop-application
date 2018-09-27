package controller;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import model.Circles;
import model.Ellipses;
import model.Lines;
import model.Rectangles;
public class ShapeProperties extends ShapesEngine{
	public void addShape(){
		if(getPressedButtonType().equals("line"))
			drawLine();
		else if(getPressedButtonType().equals("rectangle"))
			drawRectangle();
		else if(getPressedButtonType().equals("circle"))
			drawCircle();
		else if(getPressedButtonType().equals("ellipse"))
			drawEllipse();
	}
	
	public void drawLine(){
		check=0;
		Line l = new Line();
		//set value of starting of line if it's not set before
		getDrawingPane().setOnMousePressed(e->{
			if(l.getStartX()==0&&l.getStartY()==0){
				l.setStartX(e.getX());
				l.setStartY(e.getY());
				getDrawingPane().getChildren().add(l);
			}
			//determine end of line on the second press
			else if(check!=1){
				check=1;
				l.setEndX(e.getX());
				l.setEndY(e.getY());
				Lines drawenLine = new Lines();
				undoHistory.push(l);
				drawenLine.setPosition(l.getStartX(),l.getStartY(),l.getEndX(),l.getEndY());
				shapesArray.add(drawenLine);
			}
		});
		//change size of line by moving mouse
		getDrawingPane().setOnMouseMoved(e->{
			if(check==0){
				l.setEndX(e.getX());
				l.setEndY(e.getY());
			}	
			});	
	}
	public void drawRectangle(){
		check=0;
		Rectangle r = new Rectangle();	
		r.setFill(Color.TRANSPARENT);
		r.setStroke(Color.BLACK);
		//set value of starting of line if it's not set before
		getDrawingPane().setOnMousePressed(e->{
			if(r.getX()==0&&r.getY()==0){
				r.setX(e.getX());
				r.setY(e.getY());
				r.setHeight(0);
				r.setWidth(0);
				getDrawingPane().getChildren().add(r);
			}
			else if(check!=1){
				check=1;
				r.setWidth(Math.abs((e.getX() - r.getX())));
				r.setHeight(Math.abs((e.getY() - r.getY())));
				Rectangles drawenRectangle = new Rectangles();
				undoHistory.push(r);
				drawenRectangle.setPosition(r.getX(),r.getY(),r.getWidth(),r.getHeight());
				shapesArray.add(drawenRectangle);
			}
		});
		getDrawingPane().setOnMouseMoved(e->{
			if(check==0){
				r.setWidth(Math.abs((e.getX() - r.getX())));
				r.setHeight(Math.abs((e.getY() - r.getY())));
			}
		});	
	}
	public void drawCircle(){
		check=0;
		Circle c = new Circle();
		c.setFill(Color.TRANSPARENT);
		c.setStroke(Color.BLACK);
		getDrawingPane().setOnMousePressed(e->{
			if(c.getCenterX()==0&&c.getCenterY()==0){
				c.setCenterX(e.getX());
				c.setCenterY(e.getY());
				c.setRadius(0);
				getDrawingPane().getChildren().add(c);
			}
			else if(check!=1){
				check=1;
				if(c.getRadius()+c.getCenterY()<getDrawingPane().getPrefHeight()&&c.getCenterY()-c.getRadius()>0
					&&c.getRadius()+c.getCenterX()<getDrawingPane().getPrefWidth()&&c.getCenterX()-c.getRadius()>0){
					c.setRadius((Math.abs(e.getX() - c.getCenterX()) + Math.abs(e.getY() - c.getCenterY())) / 2);
					Circles drawenCircle = new Circles();
					undoHistory.push(c);
					drawenCircle.setPosition(c.getCenterX(),c.getCenterY(),c.getRadius());
					shapesArray.add(drawenCircle);
				}
				else
					check=0;
			}
		});
		getDrawingPane().setOnMouseMoved(e->{
			if(check==0)
				   c.setRadius((Math.abs(e.getX() - c.getCenterX()) + Math.abs(e.getY() - c.getCenterY())) / 2);
		});	
	}
	public void drawEllipse(){
		check=0;
		Ellipse elps = new Ellipse();
		elps.setFill(Color.TRANSPARENT);
		elps.setStroke(Color.BLACK);
		getDrawingPane().setOnMousePressed(e->{
			if(elps.getCenterX()==0&&elps.getCenterY()==0){ 
				elps.setCenterX(e.getX());
                elps.setCenterY(e.getY());
                elps.setRadiusX(0);
                elps.setRadiusY(0);
				getDrawingPane().getChildren().add(elps);
			}
			else if(check!=1){
				check=1;
				if(elps.getRadiusY()+elps.getCenterY()<getDrawingPane().getPrefHeight()&&elps.getCenterY()-elps.getRadiusY()>0
					&&elps.getRadiusX()+elps.getCenterX()<getDrawingPane().getPrefWidth()&&elps.getCenterX()-elps.getRadiusX()>0)
					{
					elps.setRadiusX(Math.abs(e.getX() - elps.getCenterX()));
					elps.setRadiusY(Math.abs(e.getY() - elps.getCenterY()));
					Ellipses drawenEllipse = new Ellipses();
					undoHistory.push(elps);
					drawenEllipse.setPosition(elps.getCenterX(),elps.getCenterY(),elps.getRadiusX(),elps.getRadiusY());
					shapesArray.add(drawenEllipse);
					}
				else 
					check=0;
			}

		});
		getDrawingPane().setOnMouseMoved(e->{
			if(check==0){
					elps.setRadiusX(Math.abs(e.getX() - elps.getCenterX()));
					elps.setRadiusY(Math.abs(e.getY() - elps.getCenterY()));
			}
		});	
	}	
	
	public int searchShape(){
		for(int i=0;i<shapesArray.size();i++){
			if(shapesArray.get(i).getType().equals("Lines")&&Lines.contains(shapesArray.get(i), x, y))
				return i;
			else if(shapesArray.get(i).getType().equals("Ellipses")&&Ellipses.contains(shapesArray.get(i), x, y))
					return i;
			else if(shapesArray.get(i).getType().equals("Rectangles")&&Rectangles.contains(shapesArray.get(i), x, y))
					return i;
			else if(shapesArray.get(i).getType().equals("Circles")&&Circles.contains(shapesArray.get(i), x, y))
						return i;
			
		}
		return -1;
	}
	
	public int searchUndoHistory(Node node){
		for(int i=0;i<undoHistory.size();i++){
			if(undoHistory.get(i).equals(node)){
				return i;
			}
		}
		return -1;
	}
	
	public void editLine(int check,MouseEvent e){
			Line l = (Line) getDrawingPane().getChildren().get(check);
			l.setEndX(e.getX());
			l.setEndY(e.getY());
			getDrawingPane().getChildren().remove(check);
			shapesArray.remove(check);
			getDrawingPane().getChildren().add(l);		
			Lines drawenLine = new Lines();
			undoHistory.push(l);
			drawenLine.setPosition(l.getStartX(),l.getStartY(),l.getEndX(),l.getEndY());
			shapesArray.add(drawenLine);
		}
	public void editRectangle(int check,MouseEvent e){
		Rectangle r = (Rectangle) getDrawingPane().getChildren().get(check);
		r.setWidth(Math.abs((e.getX() - r.getX())));
		r.setHeight(Math.abs((e.getY() - r.getY())));
		getDrawingPane().getChildren().remove(check);
		shapesArray.remove(check);
		getDrawingPane().getChildren().add(r);	
		Rectangles drawenRectangle = new Rectangles();
		undoHistory.push(r);
		drawenRectangle.setPosition(r.getX(),r.getY(),r.getWidth(),r.getHeight());
		shapesArray.add(drawenRectangle);
	}
	public void editCircle(int check,MouseEvent e){
		Circle c = (Circle) getDrawingPane().getChildren().get(check);
		c.setRadius((Math.abs(e.getX() - c.getCenterX()) + Math.abs(e.getY() - c.getCenterY())) / 2);
		getDrawingPane().getChildren().remove(check);
		shapesArray.remove(check);
		getDrawingPane().getChildren().add(c);	
		Circles drawenCircle= new Circles();
		undoHistory.push(c);
		drawenCircle.setPosition(c.getCenterX(),c.getCenterY(),c.getRadius());
		shapesArray.add(drawenCircle);
	}
	public void editEllipse(int check,MouseEvent e){
		Ellipse elps = (Ellipse) getDrawingPane().getChildren().get(check);
		elps.setRadiusX(Math.abs(e.getX() - elps.getCenterX()));
		elps.setRadiusY(Math.abs(e.getY() - elps.getCenterY()));
		getDrawingPane().getChildren().remove(check);
		shapesArray.remove(check);
		getDrawingPane().getChildren().add(elps);	
		Ellipses drawenEllipse = new Ellipses();
		undoHistory.push(elps);
		drawenEllipse.setPosition(elps.getCenterX(),elps.getCenterY(),elps.getRadiusX(),elps.getRadiusY());
		shapesArray.add(drawenEllipse);
	}

}