package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class RectAdapter extends Rectangle2D.Double implements IAbstractShape 
{
	private static final long serialVersionUID = 1L;
	private Color defaultColor;
	private int width, height;
	
	public RectAdapter() 
	{
		defaultColor = Color.blue.brighter();
	}
	
	public Point getStart()
	{
		return new Point((int)x, (int)y);
	}
	
	public void setStart(Point point)
	{
		x = point.x;
		y = point.y;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	@Override
	public void setColor(Color color) 
	{
		defaultColor = color;
	}

	@Override
	public void draw(Graphics2D g) 
	{
		g.setColor(defaultColor); 
		g.drawRect((int)x, (int)y, (int)width, (int)height);
	}
}
