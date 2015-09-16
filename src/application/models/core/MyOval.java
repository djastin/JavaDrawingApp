package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class MyOval extends AbstractShape
{
	public MyOval() { }
	
	public void setStart(Point pt) 
	{
		pointStart = pt;
	}

	public void setEnd(Point pt) 
	{
		pointEnd = pt;
	}

	public void setWidth(int w)
	{
		shapeWidth = w;
	}

	public void setHeight(int h)
	{
		shapeHeight = h;
	}

	public Point getStart()
	{
		return pointStart;
	}

	public Point getEnd()
	{
		return new Point(0, 0);
	}

	public int getWidth() 
	{
		return shapeWidth;
	}

	public int getHeight()
	{
		return shapeHeight;
	}

	public void Draw(Graphics2D g)
	{
		g.setColor(Color.green.darker()); 
		g.drawOval(pointStart.x, pointStart.y, shapeWidth, shapeHeight);
	}
}