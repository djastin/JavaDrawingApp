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
		Point startPos = new Point(x, y);
		ovalAdapter = new OvalAdapter();
		ovalAdapter.setStart(startPos);
		
		return ovalAdapter;
	}

	@Override
	public void expand(int x, int y)
	{	
		Point startPos = new Point((int)ovalAdapter.getOval().x, (int)ovalAdapter.getOval().y);
		initializeLastAddedOvalExpanding(startPos, new Point(x, y));
	}

	@Override
	public void complete(int x, int y)
	{
		initializeLastAddedOvalCompletion(ovalAdapter.getStart(), new Point(x, y));
	}
	
	@Override
	public AbstractShape getShape() 
	{
		return ovalAdapter;
	}
	
	private Point initializeOvalPositionsExpanding(Point startPosition, Point draggedPosition)
	{
		Point drawto = new Point(Math.max(draggedPosition.x, startPosition.x), 
				Math.max(draggedPosition.y, startPosition.y));
		Point newStartPosition = new Point(Math.min(draggedPosition.x, startPosition.x), 
				Math.min(draggedPosition.y, startPosition.y));
		shapeWidth = Math.abs((drawto.x - newStartPosition.x));
		shapeHeight = Math.abs((drawto.y - newStartPosition.y));
		
		return newStartPosition;
	}
	
	private void initializeLastAddedOvalExpanding(Point startPosition, Point draggedPosition)
	{
		Point newStartPosition = initializeOvalPositionsExpanding(startPosition, draggedPosition);
		
		ovalAdapter.getOval().width = shapeWidth;
		ovalAdapter.getOval().height = shapeHeight;
		ovalAdapter.setStart(newStartPosition);
	}
	
	private Point initializeOvalPositionsCompletion(Point startPosition, Point releasedPosition)
	{
		Point drawto = new Point(Math.max(releasedPosition.x, startPosition.x), 
				Math.max(releasedPosition.y, startPosition.y));
		Point newStartPosition = new Point(Math.min(releasedPosition.x, startPosition.x),
				Math.min(releasedPosition.y, startPosition.y));
		shapeWidth = Math.abs((drawto.x - newStartPosition.x));
		shapeHeight = Math.abs((drawto.y - newStartPosition.y));
		
		return newStartPosition;
	}
	
	private void initializeLastAddedOvalCompletion(Point startPosition, Point releasedPosition)
	{
		Point newStartPosition = initializeOvalPositionsCompletion(startPosition, releasedPosition);
		
		ovalAdapter.getOval().width = shapeWidth;
		ovalAdapter.getOval().height = shapeHeight;
		ovalAdapter.setStart(newStartPosition);
	}
}
