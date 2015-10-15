package application.models.interfaces;

import application.models.core.IAbstractShape;

public interface IShapeComposer
{
	public IAbstractShape create(int x, int y);
	public void expand(int x, int y);
	public void complete(int x, int y);
	
	public IAbstractShape getShape();
}

