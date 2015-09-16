package application.models.interfaces;

import application.models.core.AbstractShape;

public interface IShapeComposer
{
	public void create(int x, int y);
	public void expand(int x, int y);
	public void complete(int x, int y);
	
	public AbstractShape getShape();
}

