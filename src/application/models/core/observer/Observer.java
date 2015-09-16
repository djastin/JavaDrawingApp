package application.models.core.observer;

public abstract class Observer 
{
	protected Subject subject;
	public abstract void update();
}
