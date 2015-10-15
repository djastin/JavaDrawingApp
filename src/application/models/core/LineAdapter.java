package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class LineAdapter extends Line2D implements IAbstractShape
{
	private Color defaultColor;
	private Point startCoordination, endCoordination;
	
	public LineAdapter() 
	{
		defaultColor = Color.black;
		
		startCoordination = new Point();
		endCoordination = new Point();
	}

	@Override
	public void setColor(Color color)
	{
		defaultColor = color;
	}
	
	public Color getColor()
	{
		return defaultColor;
	}
	
	@Override
	public Point getStart() 
	{
		return startCoordination;
	}

	public Point getEnd() 
	{
		return endCoordination;
	}
	
	@Override
	public void setStart(Point point) 
	{
		startCoordination = point;
	}

	public void setEnd(Point point) 
	{
		endCoordination = point;
	}
	
	@Override
	public void draw(Graphics2D g)
	{				
		g.setColor(defaultColor); 
		g.drawLine((int)getX1(), (int)getY1(), (int)getX2(), (int)getY2());
	}

	@Override
	public Rectangle2D getBounds2D()
	{
		return null;
	}

	@Override
	public Point2D getP1()
	{
		return startCoordination;
	}

	@Override
	public Point2D getP2()
	{
		return endCoordination;
	}

	@Override
	public double getX1()
	{
		return startCoordination.x;
	}

	@Override
	public double getX2() 
	{
		return endCoordination.x;
	}

	@Override
	public double getY1()
	{
		return startCoordination.y;
	}

	@Override
	public double getY2()
	{
		return endCoordination.y;
	}

	@Override
	public void setLine(double arg0, double arg1, double arg2, double arg3)
	{
		
	}
}
