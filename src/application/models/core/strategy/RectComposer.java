package application.models.core.strategy;

import java.awt.Point;
import application.models.core.IAbstractShape;
import application.models.core.RectAdapter;
import application.models.interfaces.IShapeComposer;

public class RectComposer implements IShapeComposer
{
	private RectAdapter rectangleAdapter;
	
	public RectComposer() { }

	@Override
	public IAbstractShape create(int x, int y)
	{
		rectangleAdapter = new RectAdapter();
		Point startPos = new Point(x, y);
		rectangleAdapter.setStart(startPos);
		
		return rectangleAdapter;
	}

	@Override
	public void expand(int x, int y) 
	{		
		Point startPos = rectangleAdapter.getStart();
		Point drawto = new Point(Math.max(x, startPos.x), Math.max(y, startPos.y));
		Point newstart = new Point(Math.min(x, startPos.x), Math.min(y, startPos.y));
		
		int shapeWidth, shapeHeight;
		shapeWidth = Math.abs((drawto.x - newstart.x));
		shapeHeight = Math.abs((drawto.y - newstart.y));
		rectangleAdapter.setWidth(shapeWidth);
		rectangleAdapter.setHeight(shapeHeight);
		rectangleAdapter.setStart(newstart);
	}
	
	@Override
	public void complete(int x, int y) 
	{
		Point startPos = rectangleAdapter.getStart();
		
		Point drawto = new Point(Math.max(x, startPos.x), Math.max(y, startPos.y));
		Point newstart = new Point(Math.min(x, startPos.x), Math.min(y, startPos.y));
		
		int shapeWidth, shapeHeight;
		shapeWidth = Math.abs((drawto.x - newstart.x));
		shapeHeight = Math.abs((drawto.y - newstart.y));
		rectangleAdapter.setWidth(shapeWidth);
		rectangleAdapter.setHeight(shapeHeight);
		rectangleAdapter.setStart(newstart);
	}
	
	public RectAdapter getRectangle()
	{
		return rectangleAdapter;
	}
	
	@Override
	public IAbstractShape getShape()
	{
		return rectangleAdapter;
	}
}
