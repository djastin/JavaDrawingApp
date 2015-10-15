package application.models.composite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import application.models.core.IAbstractShape;

public class ComposedShape implements IAbstractShape
{
	protected Color defaultColor;
	protected Point startPosition;
	private ArrayList<IAbstractShape> shapes;
	
	public ComposedShape()	
	{
		shapes = new ArrayList<IAbstractShape>();
	}
	
	public ArrayList<IAbstractShape> getShapes()
	{
		return shapes;
	}
	
	public void addShape(IAbstractShape shape)
	{
		shapes.add(shape);
	}
	
	public void addAllShapes(ArrayList<IAbstractShape> list)
	{
		shapes.addAll(shapes);
	}
	
	public void clearShapes()
	{
		shapes.clear();
	}

	@Override
	public void setColor(Color color) 
	{
		this.defaultColor = color;
	}
	
	public Color getColor()
	{
		return defaultColor;
	}

	@Override
	public void setStart(Point point) 
	{
		startPosition = point;
	}
	
	public void setWidth(int width)
	{
		
	}
	
	public void setHeight(int height)
	{
		
	}

	@Override
	public Point getStart() 
	{
		return startPosition;
	}

	@Override
	public void draw(Graphics2D g) 
	{
		
	}
}
