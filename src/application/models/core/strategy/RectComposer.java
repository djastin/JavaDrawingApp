package application.models.core.strategy;

import java.awt.Point;
import java.awt.geom.Point2D;
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
		Point2D.Float point = new Point2D.Float(x, y);
		rectangleAdapter.setStart(point);
		
		return rectangleAdapter;
	}

	@Override
	public void expand(int x, int y) 
	{		
		Point2D.Float newStartPosition = new Point2D.Float();
		newStartPosition.setLocation(getRectPositionsExpanding(rectangleAdapter.getStart(), new Point(x, y)));
		setLastAddedRectExpanding(newStartPosition);		
	}
	
	@Override
	public void complete(int x, int y) 
	{
		Point2D.Float newStartPosition = new Point2D.Float();
		
		Point2D.Float oldStart = new Point2D.Float();
		oldStart.setLocation(rectangleAdapter.getStart().x, rectangleAdapter.getStart().y);
		Point2D.Float args = new Point2D.Float();
		args.setLocation(x, y);
		
		newStartPosition.setLocation(getRectPositionsCompletion(oldStart, args));
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
	
	private void setLastAddedRectExpanding(Point2D.Float newStartPosition)
	{		
		rectangleAdapter.getRectangle().width = shapeWidth;
		rectangleAdapter.getRectangle().height = shapeHeight;
		rectangleAdapter.setStart(newStartPosition);
	}
	
	private Point2D.Float getRectPositionsCompletion(Point2D.Float startPosition, Point2D.Float releasedPosition)
	{
		Point2D.Float drawto = new Point2D.Float();
		drawto.setLocation(Math.max(releasedPosition.x, startPosition.x), 
				Math.max(releasedPosition.y, startPosition.y));
		
		Point2D.Float newStartPosition = new Point2D.Float();
		newStartPosition.setLocation(Math.min(releasedPosition.x, startPosition.x), 
				Math.min(releasedPosition.y, startPosition.y));
		shapeWidth = (int)Math.abs((drawto.x - newStartPosition.x));
		shapeHeight = (int)Math.abs((drawto.y - newStartPosition.y));
		
		return newStartPosition;
	}
	
	private void setLastAddedRectCompletion(Point2D.Float newStartPosition)
	{
		rectangleAdapter.getRectangle().width = shapeWidth;
		rectangleAdapter.getRectangle().height = shapeHeight;
		rectangleAdapter.setStart(newStartPosition);
	}
}
