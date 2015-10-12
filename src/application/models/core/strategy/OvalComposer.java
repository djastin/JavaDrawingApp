package application.models.core.strategy;

import java.awt.Point;
import application.models.core.AbstractShape;
import application.models.core.OvalAdapter;
import application.models.interfaces.IShapeComposer;

public class OvalComposer implements IShapeComposer
{
	private OvalAdapter ovalAdapter;
	private int shapeWidth, shapeHeight;
	
	public OvalComposer() { }

	@Override
	public AbstractShape create(int x, int y)
	{		
		ovalAdapter = new OvalAdapter();
		Point point = new Point(x, y);
		ovalAdapter.setStart(point);
		
		return ovalAdapter;
	}

	@Override
	public void expand(int x, int y)
	{	
		Point startPos = ovalAdapter.getStart();
		
		Point drawto = new Point(Math.max(x, startPos.x), Math.max(y, startPos.y));
		Point newstart = new Point(Math.min(x, startPos.x), Math.min(y, startPos.y));
		
		int shapeWidth, shapeHeight;
		shapeWidth = Math.abs((drawto.x - newstart.x));
		shapeHeight = Math.abs((drawto.y - newstart.y));

		ovalAdapter.setWidth(shapeWidth);
		ovalAdapter.setHeight(shapeHeight);
		ovalAdapter.setStart(newstart);
	}

	@Override
	public void complete(int x, int y)
	{
		Point startPos = ovalAdapter.getStart();
		
		Point drawto = new Point(Math.max(x, startPos.x), Math.max(y, startPos.y));
		Point newstart = new Point(Math.min(x, startPos.x), Math.min(y, startPos.y));
		shapeWidth = Math.abs((drawto.x - newstart.x));
		shapeHeight = Math.abs((drawto.y - newstart.y));

		ovalAdapter.setWidth(shapeWidth);
		ovalAdapter.setHeight(shapeHeight);
		ovalAdapter.setStart(newstart);
	}
	
	@Override
	public AbstractShape getShape() 
	{
		return ovalAdapter;
	}
}
