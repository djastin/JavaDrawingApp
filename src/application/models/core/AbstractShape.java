package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public interface AbstractShape
{	
	public void setColor(Color color);
	public void setStart(Point point);
	public Point getStart();
	public void draw(Graphics2D g);
}
