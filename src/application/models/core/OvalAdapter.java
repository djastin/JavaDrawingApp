package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class OvalAdapter extends Ellipse2D.Float implements IAbstractShape
{
	private static final long serialVersionUID = 1L;
	private Color defaultColor;
	private int shapeWidth, shapeHeight;
	
	public OvalAdapter() 
	{
		defaultColor = Color.green.darker();
	}
	
	public void setLocation(int x, int y)
	{
		Point drawto = new Point(Math.max(x, getStart().x), Math.max(y, getStart().y));
		Point newstart = new Point(Math.min(x, getStart().x), Math.min(y, getStart().y));
		
		setBoundaries(drawto, newstart);
		setStart(newstart);
	}
	
	private void setBoundaries(Point drawto, Point newstart)
	{
		shapeWidth = Math.abs((drawto.x - newstart.x));
		shapeHeight = Math.abs((drawto.y - newstart.y));
		
		setWidth(shapeWidth);
		setHeight(shapeHeight);
	}
	
	@Override
	public Point getStart() 
	{
		return new Point((int)x, (int)y);
	}
	
	@Override
	public void setStart(Point point) 
	{
		x = (float)point.x;
		y = (float)point.y;
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
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}

	public void draw(Graphics2D g)
	{
		g.setColor(defaultColor); 
		g.drawOval((int)x, (int)y, (int)width, (int)height);
	}
}