package application.models.core;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class AbstractShape extends Object
{
	protected Point pointStart; 
	protected Point pointEnd; 
	protected int shapeWidth; 
	protected int shapeHeight; 
	protected Color defaultColor; 

	public AbstractShape() 
	{
		defaultColor = Color.red;
	}

	public Point getStart()
	{
		return pointStart;
	}

	public Point getEnd()
	{
		return pointEnd;
	}
	
	public abstract void setStart(Point pt);
	public abstract void setEnd(Point pt);
	public abstract void Draw(Graphics2D g);
}
