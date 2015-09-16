package application.models.core.strategy;

import java.awt.Point;
import application.controllers.OOPDrawController;
import application.models.core.AbstractShape;
import application.models.core.MyLine;
import application.models.core.observer.Observer;
import application.models.core.observer.Subject;
import application.models.enums.ShapeEnum;
import application.models.interfaces.IShapeComposer;

public class LineComposer extends Observer implements IShapeComposer
{
	private MyLine line;
	private OOPDrawController controller;
	private Subject subject;
	
	public LineComposer(OOPDrawController controller, Subject subject)
	{
		this.controller = controller;
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void create(int x, int y) 
	{
		Point startPos = new Point(x, y);
		line = new MyLine();
		line.setStart(startPos);
		controller.getShapes().add(line);
	}

	@Override
	public void expand(int x, int y) 
	{
		Point endPos = new Point(x, y);
		line = (MyLine) controller.findLastAdded(ShapeEnum.LINE);
		line.setEnd(endPos);
	}

	@Override
	public void complete(int x, int y) 
	{
		Point endPos = new Point(x, y);
		line = (MyLine) controller.findLastAdded(ShapeEnum.LINE);
		line.setEnd(endPos);
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
		return line;
	}
}
