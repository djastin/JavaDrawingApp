package application.models.core;

import java.awt.Graphics2D;
import java.awt.Point;

public class MyLine extends AbstractShape 
{
	public MyLine() { }
	
	@Override
	public void setStart(Point pt)
	{
		pointStart = pt;
	}

	public void setEnd(Point pt)
	{
		pointEnd = pt;
	}

	public Point getStart() 
	{
		return pointStart;
	}

	public Point getEnd()
	{
		return pointEnd;
	}

	public void Draw(Graphics2D g)
	{
		g.setColor(defaultColor); 
		g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
	}
}
