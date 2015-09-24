package application.models.core.strategy;

import java.awt.Point;
import application.models.core.AbstractShape;
import application.models.core.RectAdapter;
import application.models.interfaces.IShapeComposer;

public class RectComposer implements IShapeComposer
{
	private RectAdapter rectangleAdapter;
	private int shapeWidth, shapeHeight;
	
	public RectComposer() { }

	@Override
	public AbstractShape create(int x, int y)
	{
		rectangleAdapter = new RectAdapter();
		rectangleAdapter.setStart(new Point(x, y));
		
		return rectangleAdapter;
	}

	@Override
	public void expand(int x, int y) 
	{		
		Point newStartPosition = getRectPositionsExpanding(rectangleAdapter.getStart(), new Point(x, y));
		setLastAddedRectExpanding(newStartPosition);		
	}
	
	@Override
	public void complete(int x, int y) 
	{
		Point newStartPosition = getRectPositionsCompletion(rectangleAdapter.getStart(), new Point(x, y));
		setLastAddedRectCompletion(newStartPosition);		
	}
	
	public RectAdapter getRectangle()
	{
		return rectangleAdapter;
	}
	
	@Override
	public AbstractShape getShape()
	{
		return rectangleAdapter;
	}
	
	private Point getRectPositionsExpanding(Point startPosition, Point draggedPosition)
	{
		Point drawto = new Point(Math.max(draggedPosition.x, startPosition.x), 
				Math.max(draggedPosition.y, startPosition.y));
		Point newStartPosition = new Point(Math.min(draggedPosition.x, startPosition.x), 
				Math.min(draggedPosition.y, startPosition.y));
		shapeWidth = Math.abs((drawto.x - newStartPosition.x));
		shapeHeight = Math.abs((drawto.y - newStartPosition.y));
		
		return newStartPosition;
	}
	
	private void setLastAddedRectExpanding(Point newStartPosition)
	{		
		rectangleAdapter.getRectangle().width = shapeWidth;
		rectangleAdapter.getRectangle().height = shapeHeight;
		rectangleAdapter.setStart(newStartPosition);
	}
	
	private Point getRectPositionsCompletion(Point startPosition, Point releasedPosition)
	{
		Point drawto = new Point(Math.max(releasedPosition.x, startPosition.x),
				Math.max(releasedPosition.y, startPosition.y));
		Point newStartPosition = new Point(Math.min(releasedPosition.x, startPosition.x), 
				Math.min(releasedPosition.y, startPosition.y));
		shapeWidth = Math.abs((drawto.x - newStartPosition.x));
		shapeHeight = Math.abs((drawto.y - newStartPosition.y));
		
		return newStartPosition;
	}
	
	private void setLastAddedRectCompletion(Point newStartPosition)
	{
		rectangleAdapter.getRectangle().width = shapeWidth;
		rectangleAdapter.getRectangle().height = shapeHeight;
		rectangleAdapter.setStart(newStartPosition);
	}
}
