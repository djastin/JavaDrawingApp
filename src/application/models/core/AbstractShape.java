package application.models.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public interface AbstractShape
{	
	public void setColor(Color color);
	public void setStart(Point2D.Float point);
	public Point getStart();
	public void draw(Graphics2D g);
}
