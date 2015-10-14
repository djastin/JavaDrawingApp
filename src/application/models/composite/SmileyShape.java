package application.models.composite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import application.models.core.OvalAdapter;

public class SmileyShape extends ComposedShape
{
	private OvalAdapter headOval, eye1Oval, eye2Oval;
	private int shapeWidth, shapeHeight;
	
	public SmileyShape()
	{
		this.defaultColor = Color.green;
		
		addShapesToList();		
	}
	
	public void addShapesToList()
	{
		headOval = new OvalAdapter();
		eye1Oval = new OvalAdapter();
		eye2Oval = new OvalAdapter();
		
		addShape(headOval);
		addShape(eye1Oval);
		addShape(eye2Oval);
	}
	
	public void initializePositionsOfShapes()
	{
		Point shapePositionEye1 = new Point(startPosition.x + 5, startPosition.y + 5);
		Point shapePositionEye2 = new Point(startPosition.x + 20, startPosition.y + 5);

		headOval.setStart(startPosition);
		eye1Oval.setStart(shapePositionEye1);
		eye2Oval.setStart(shapePositionEye2);
	}
	
	public void setWidth(int width)
	{
		shapeWidth = width;
	}
	
	public void setHeight(int height)
	{
		shapeHeight = height;
	}
	
	@Override
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.BLUE);
		g.drawOval((int)headOval.x, (int)headOval.y, shapeWidth, shapeHeight);
		//g.drawOval((int)eye1Oval.x + 80, (int)eye1Oval.y + 15, 70, 70);
		//g.drawOval((int)eye2Oval.x + 10, (int)eye2Oval.y + 15, 70, 70);
	}
}
