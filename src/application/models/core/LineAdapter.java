package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class LineAdapter implements AbstractShape
{
	private Line2D.Float line;
	private Color defaultColor;
	
	public LineAdapter() 
	{
		line = new Line2D.Float();
	}
	
	public Line2D.Float getLine()
	{
		return line;
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
		return new Point((int)line.getP1().getX(), (int)line.getP1().getY());
	}

	public Point getEnd() 
	{
		return new Point((int)line.getP2().getX(), (int)line.getP2().getY());
	}
	
	@Override
	public void setStart(Point2D.Float point) 
	{
		line.getP1().setLocation(point);
	}

	public void setEnd(Point2D.Float point) 
	{
		line.getP2().setLocation(point);
	}
	
	@Override
	public void draw(Graphics2D g)
	{		
		int startX, startY, endX, endY;
		startX = (int)line.getP1().getX();
		startY = (int)line.getP1().getY();
		endX = (int)line.getP2().getX();
		endY = (int)line.getP2().getY();
				
		g.setColor(defaultColor); 
		g.drawLine(startX, startY, endX, endY);
	}
}
