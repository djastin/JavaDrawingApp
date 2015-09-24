package application.models.core.strategy;

import java.awt.Point;
import application.models.core.AbstractShape;
import application.models.core.LineAdapter;
import application.models.interfaces.IShapeComposer;

public class LineComposer implements IShapeComposer
{
	private LineAdapter lineAdapter;
	
	public LineComposer() {	}

	@Override
	public AbstractShape create(int x, int y) 
	{
		Point startPos = new Point(x, y);
		lineAdapter = new LineAdapter();
		lineAdapter.setStart(startPos);
		
		return lineAdapter;
	}

	@Override
	public void expand(int x, int y) 
	{
		Point endPos = new Point(x, y);
		lineAdapter.setEnd(endPos);
	}

	@Override
	public void complete(int x, int y) 
	{
		Point endPos = new Point(x, y);
		lineAdapter.setEnd(endPos);
	}

	@Override
	public AbstractShape getShape() 
	{
		return lineAdapter;
	}
}
