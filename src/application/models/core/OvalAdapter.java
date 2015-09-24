package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class OvalAdapter implements AbstractShape
{
	private Ellipse2D.Float oval;
	private Color defaultColor;
	
	public OvalAdapter() 
	{
		oval = new Ellipse2D.Float();
		defaultColor = Color.green.darker();
	}
	
	public Ellipse2D.Float getOval()
	{
		return oval;
	}
	
	@Override
	public Point getStart() 
	{
		return new Point((int)oval.x, (int)oval.y);
	}
	
	@Override
	public void setStart(Point pt) 
	{
		oval.x = (int)pt.getX();
		oval.y = (int)pt.getY();
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

	public void draw(Graphics2D g)
	{
		g.setColor(defaultColor); 
		g.drawOval((int)oval.x, (int)oval.y, (int)oval.width, (int)oval.height);
	}
}