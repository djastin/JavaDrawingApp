package application.models.core.strategy;

import java.awt.Point;

import application.models.composite.SmileyShape;
import application.models.core.AbstractShape;
import application.models.interfaces.IShapeComposer;

public class FunnyShapeComposer implements IShapeComposer
{
	private SmileyShape smileyShape;
	private int shapeWidth, shapeHeight;
	
	@Override
	public AbstractShape create(int x, int y)
	{
		Point startPos = new Point(x, y);
		smileyShape = new SmileyShape();
		smileyShape.setStart(startPos);
		//smileyShape.initializePositionsOfShapes();
				
		return smileyShape;
	}

	@Override
	public void expand(int x, int y) 
	{				
		Point startPos = smileyShape.getStart();
		
		Point drawto = new Point(Math.max(x, startPos.x), Math.max(y, startPos.y));
		Point newstart = new Point(Math.min(x, startPos.x), Math.min(y, startPos.y));
		
		int shapeWidth, shapeHeight;
		shapeWidth = Math.abs((drawto.x - newstart.x));
		shapeHeight = Math.abs((drawto.y - newstart.y));

		smileyShape.setWidth(shapeWidth);
		smileyShape.setHeight(shapeHeight);
		smileyShape.setStart(newstart);
	}

	@Override
	public void complete(int x, int y) 
	{
		Point startPos = smileyShape.getStart();
		
		Point drawto = new Point(Math.max(x, startPos.x), Math.max(y, startPos.y));
		Point newstart = new Point(Math.min(x, startPos.x), Math.min(y, startPos.y));
		shapeWidth = Math.abs((drawto.x - newstart.x));
		shapeHeight = Math.abs((drawto.y - newstart.y));

		smileyShape.setWidth(shapeWidth);
		smileyShape.setHeight(shapeHeight);
		smileyShape.setStart(newstart);
	}

	@Override
	public AbstractShape getShape() 
	{
		return smileyShape;
	}

}
