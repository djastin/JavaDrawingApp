package application.models.core.observer;

import java.util.ArrayList;
import java.util.List; 

import application.models.core.AbstractShape;

public class Subject 
{
	private List<Observer> observers = new ArrayList<Observer>();
	private AbstractShape activeShape;
	
	public Subject() { } 
	
	public void attach(Observer observer)
	{
		observers.add(observer);
	}
	
	public void notifyAllObservers()
	{
		for(Observer observer : observers)
		{
			observer.update();
		}
	}
		
	public AbstractShape getActiveShape()
	{
		return activeShape;
	}
	
	public void setActiveShape(AbstractShape activeShape)
	{
		this.activeShape = activeShape;
		notifyAllObservers();
	}
}
