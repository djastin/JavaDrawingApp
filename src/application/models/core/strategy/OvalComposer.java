package application.models.core.strategy;

import java.awt.Point;
import application.models.core.IAbstractShape;
import application.models.core.OvalAdapter;
import application.models.interfaces.IShapeComposer;

public class OvalComposer implements IShapeComposer
{
	private OvalAdapter ovalAdapter;
	
	public OvalComposer() { }

	@Override
	public IAbstractShape create(int x, int y)
	{		
		ovalAdapter = new OvalAdapter();
		ovalAdapter.setStart(new Point(x, y));
		
		return ovalAdapter;
	}

	@Override
	public void expand(int x, int y)
	{	
		ovalAdapter.setLocation(x, y);
	}

	@Override
	public void complete(int x, int y)
	{
		ovalAdapter.setLocation(x, y);
	}
	
	@Override
	public IAbstractShape getShape() 
	{
		return ovalAdapter;
	}
}
