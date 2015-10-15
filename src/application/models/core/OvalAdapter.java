package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class OvalAdapter extends Ellipse2D.Float implements IAbstractShape
{
	private static final long serialVersionUID = 1L;
	private Color defaultColor;
	
	public OvalAdapter() 
	{
		defaultColor = Color.green.darker();
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