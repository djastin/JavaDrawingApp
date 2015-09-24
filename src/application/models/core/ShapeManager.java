package application.models.core;

import java.util.ArrayList;

public class ShapeManager 
{
	private ArrayList<Object> shapes = new ArrayList<Object>();
	private static ShapeManager instance;

	private ShapeManager() 
	{
		shapes = new ArrayList<Object>();
	} 
	
	public static ShapeManager getInstance()
	{
		if(instance == null)
		{
			instance = new ShapeManager();
		}
		return instance;
	}
	
	public void addShape(AbstractShape shape)
	{
		shapes.add(shape);
	}
	
	public ArrayList<Object> getShapes()
	{
		return shapes;
	}
	
	
}
