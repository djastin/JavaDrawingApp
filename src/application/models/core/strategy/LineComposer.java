package application.models.core.strategy;

import java.awt.Point;
import application.models.core.IAbstractShape;
import application.models.core.LineAdapter;
import application.models.interfaces.IShapeComposer;

public class LineComposer implements IShapeComposer
{
	private LineAdapter lineAdapter;
	
	public LineComposer() {	}

	@Override
	public IAbstractShape create(int x, int y) 
	{
		lineAdapter = new LineAdapter();
		lineAdapter.setStart(new Point(x, y));
				
		return lineAdapter;
	}

	@Override
	public void expand(int x, int y) 
	{
		lineAdapter.setEnd(new Point(x, y));
	}

	@Override
	public void complete(int x, int y) 
	{
		lineAdapter.setEnd(new Point(x, y));
	}

	@Override
	public IAbstractShape getShape() 
	{
		return lineAdapter;
	}
}
