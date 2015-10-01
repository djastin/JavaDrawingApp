package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RectAdapter implements AbstractShape 
{
	private Rectangle2D.Float rectangle;
	private Color defaultColor;
	
	public RectAdapter() 
	{
		rectangle = new Rectangle2D.Float();
		defaultColor = Color.blue.brighter();
	}
	
	public Rectangle2D.Float getRectangle()
	{
		return rectangle;
	}
	
	public Point getStart()
	{
		return new Point((int)rectangle.x, (int)rectangle.y);
	}
	
	public void setStart(Point2D.Float pt)
	{
		rectangle.x = pt.x;
		rectangle.y = pt.y;
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
		g.drawRect((int)rectangle.x, (int)rectangle.y, (int)rectangle.width, 
				(int)rectangle.height);
	}
}
