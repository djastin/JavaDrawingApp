package application.models.facade;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import application.models.core.IAbstractShape;
import application.models.core.ShapeManager;
import application.models.core.strategy.LineComposer;
import application.models.factory.ComposerFactory;
import application.models.interfaces.IShapeComposer;

public class ComposerFacade
{
	private ComposerFactory composerFactory;
	private IShapeComposer currentComposer;
	private ShapeManager shapeManager;
	
	public ComposerFacade()
	{
		composerFactory = ComposerFactory.getInstance();
		shapeManager = ShapeManager.getInstance();
	}
	
	public void paintAllShapes(Graphics graphics)
	{
		for(Object shape : getShapes() )
		{
			((IAbstractShape)shape).draw((Graphics2D)graphics);
		}
	}
	
	public void clearShapes()
	{
		getShapes().clear();
	}
	
	public void setCurrentComposer(String whichComposer)
	{
		for(IShapeComposer composer : composerFactory.getComposers())
			if(whichComposer.equals(composer.getClass().getSimpleName()))
				currentComposer = composer;
	}
	
	public void createShape(int x, int y)
	{
		IAbstractShape shape_result = currentComposer.create(x, y);
		getShapes().add(shape_result);
	}
	
	public void expandShape(int x, int y)
	{
		currentComposer.expand(x, y);
	}
	
	public void completeShape(int x, int y)
	{
		currentComposer.complete(x, y);
	}
	
	public void setComposerToDefault()
	{
		currentComposer = new LineComposer();
	}
	
	public ArrayList<Object> getShapes()
	{
		return shapeManager.getShapes();
	}

}
