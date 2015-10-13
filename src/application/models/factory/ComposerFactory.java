package application.models.factory;

import java.util.ArrayList;

import application.models.enums.ComposerEnum;
import application.models.interfaces.IShapeComposer;

public class ComposerFactory 
{
	private static ComposerFactory instance;
	private ArrayList<IShapeComposer> composers;
	
	private ComposerFactory() 
	{
		composers = new ArrayList<IShapeComposer>();
	}
	
	public static ComposerFactory getInstance()
	{
		if(instance == null)
		{
			instance = new ComposerFactory();
		}
		return instance;
	}
	
	public ArrayList<IShapeComposer> getComposers()
	{
		return composers;
	}
	
	public void addComposer(IShapeComposer composer)
	{
		composers.add(composer);
	}
	
	public IShapeComposer getComposer(ComposerEnum choice)
	{
		IShapeComposer composer_result = null;
		
		for(IShapeComposer composer : composers)
		{	
			if(choice.toString().equals(composer.getClass().getSimpleName()))
			{
				composer_result = composer;
			}
		}
		
		return composer_result;
	}
	
	
	

}
