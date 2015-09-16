package application.models.core.strategy;

import java.awt.Point;
import application.controllers.OOPDrawController;
import application.models.core.AbstractShape;
import application.models.core.MyRect;
import application.models.core.observer.Observer;
import application.models.core.observer.Subject;
import application.models.enums.ShapeEnum;
import application.models.interfaces.IShapeComposer;

public class RectComposer extends Observer implements IShapeComposer
{
	private MyRect rectangle;
	private int shapeWidth, shapeHeight;
	private OOPDrawController controller;
	private Subject subject;
	
	public RectComposer(OOPDrawController controller, Subject subject)
	{
		this.controller = controller;
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void create(int x, int y)
	{
		rectangle = new MyRect();
		rectangle.setStart(new Point(x, y));
		controller.getShapes().add(rectangle);
	}

	@Override
	public void expand(int x, int y) 
	{		
		Point newStartPosition = getRectPositionsExpanding(rectangle.getStart(), new Point(x, y));
		setLastAddedRectExpanding(newStartPosition);		
	}
	
	@Override
	public void complete(int x, int y) 
	{
		Point newStartPosition = getRectPositionsCompletion(rectangle.getStart(), new Point(x, y));
		setLastAddedRectCompletion(newStartPosition);		
	}
	
	public MyRect getRectangle()
	{
		return rectangle;
	}
	
	@Override
	public AbstractShape getShape()
	{
		return rectangle;
	}
	
	@Override
	public void update()
	{
		System.out.println("Shape created and drawing: " + subject.getActiveShape().
				getClass().getSimpleName());
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
		rectangle = (MyRect) controller.findLastAdded(ShapeEnum.RECT);
		rectangle.setWidth(shapeWidth);
		rectangle.setHeight(shapeHeight);
		rectangle.setStart(newStartPosition);
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
		rectangle = (MyRect) controller.findLastAdded(ShapeEnum.RECT);
		rectangle.setWidth(shapeWidth);
		rectangle.setHeight(shapeHeight);
		rectangle.setStart(newStartPosition);
	}
}
