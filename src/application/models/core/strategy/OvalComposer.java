package application.models.core.strategy;

import java.awt.Point;
import application.controllers.OOPDrawController;
import application.models.core.AbstractShape;
import application.models.core.MyOval;
import application.models.core.observer.Observer;
import application.models.core.observer.Subject;
import application.models.enums.ShapeEnum;
import application.models.interfaces.IShapeComposer;

public class OvalComposer extends Observer implements IShapeComposer
{
	private MyOval oval;
	private int shapeWidth, shapeHeight;
	private OOPDrawController controller;
	private Subject subject;
	
	public OvalComposer(OOPDrawController controller, Subject subject)
	{
		this.controller = controller;
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void create(int x, int y)
	{
		Point startPos = new Point(x, y);
		oval = new MyOval();
		oval.setStart(startPos);
		controller.getShapes().add(oval);
	}

	@Override
	public void expand(int x, int y)
	{	
		initializeLastAddedOvalExpanding(oval.getStart(), new Point(x, y));
	}

	@Override
	public void complete(int x, int y)
	{
		initializeLastAddedOvalCompletion(oval.getStart(), new Point(x, y));
	}
	
	public MyOval getOval()
	{
		return oval;
	}
	
	@Override
	public void update()
	{
		System.out.println("Shape created and drawing: " + subject.getActiveShape().
				getClass().getSimpleName());	
	}
	
	@Override
	public AbstractShape getShape() 
	{
		return oval;
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
		
		oval = (MyOval) controller.findLastAdded(ShapeEnum.OVAL);
		oval.setWidth(shapeWidth);
		oval.setHeight(shapeHeight);
		oval.setStart(newStartPosition);
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
		
		oval = (MyOval) controller.findLastAdded(ShapeEnum.OVAL);
		oval.setWidth(shapeWidth);
		oval.setHeight(shapeHeight);
		oval.setStart(newStartPosition);
	}
}
