package application.models.core.strategy;

import java.awt.geom.Point2D;
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
		Point2D.Float startPos = new Point2D.Float();
		startPos.setLocation(x, y);
		lineAdapter = new LineAdapter();
		lineAdapter.setStart(startPos);
				
		return lineAdapter;
	}

	@Override
	public void expand(int x, int y) 
	{
		Point2D.Float endPos = new Point2D.Float();
		endPos.setLocation(x, y);
		lineAdapter.setEnd(endPos);
	}

	@Override
	public void complete(int x, int y) 
	{
		Point2D.Float endPos = new Point2D.Float();
		endPos.setLocation(x, y);
		lineAdapter.setEnd(endPos);
	}

	@Override
	public AbstractShape getShape() 
	{
		return lineAdapter;
	}
}
