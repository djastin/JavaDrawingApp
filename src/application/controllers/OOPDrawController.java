package application.controllers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import application.models.core.AbstractShape;
import application.models.core.MyLine;
import application.models.core.MyOval;
import application.models.core.MyRect;
import application.models.core.observer.Subject;
import application.models.core.strategy.LineComposer;
import application.models.core.strategy.OvalComposer;
import application.models.core.strategy.RectComposer;
import application.models.enums.ShapeEnum;
import application.models.interfaces.IShapeComposer;
import application.views.OOPDraw2;

public class OOPDrawController implements MouseListener, MouseMotionListener, 
	ActionListener
{
	private OOPDraw2 view;
	private IShapeComposer shapeComposer;
	private ArrayList<Object> shapes = new ArrayList<Object>();
	private Subject subject;
	
	public OOPDrawController(OOPDraw2 view)
	{
		this.view = view;
		this.subject = new Subject();
		setComposerToDefault();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) { }
		
	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) { } 

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		shapeComposer.create(arg0.getX(), arg0.getY());
		subject.setActiveShape(shapeComposer.getShape());
		subject.notifyAllObservers();
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		shapeComposer.complete(arg0.getX(), arg0.getY());
		view.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		shapeComposer.expand(arg0.getX(), arg0.getY());
		view.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) { }

	@Override
	public void actionPerformed(ActionEvent arg0)
	{		
		if(arg0.getActionCommand().equals("lineButton"))
		{
			setComposerToDefault();
		}
		else if(arg0.getActionCommand().equals("ovalButton"))
		{
			shapeComposer = new OvalComposer(this, subject);
		}
		else if(arg0.getActionCommand().equals("rectButton"))
		{
			shapeComposer = new RectComposer(this, subject);
		}
		else if(arg0.getActionCommand().equals("clearButton"))
		{
			clearScreen();
		}
	}
	
	public void clearScreen()
	{
		shapes.clear();
		view.repaint();
	}
	
	public AbstractShape findLastAdded(ShapeEnum type)
    {
    	AbstractShape result = null;
    	
    	int vectorIndex = shapes.size()-1;
    	
    	for(int i = vectorIndex; i >= vectorIndex; i--)
    	{
    		AbstractShape lastAdded = (AbstractShape) shapes.get(vectorIndex);
    		
    		if(type == ShapeEnum.LINE)
    			if(lastAdded instanceof MyLine)
    				result = lastAdded;
    		
    		if(type == ShapeEnum.OVAL)
    			if(lastAdded instanceof MyOval)
    				result = lastAdded;
    		
    		if(type == ShapeEnum.RECT)
    			if(lastAdded instanceof MyRect)
    				result = lastAdded;
    	}
    	return result;
    }
	
	public void paintAll(Graphics graphics)
	{
		for(Object shape : shapes)
		{
			((AbstractShape)shape).Draw((Graphics2D)graphics);
		}
	}
	
	public ArrayList<Object> getShapes()
    {
    	return shapes;
    }
	
	private void setComposerToDefault()
	{
		shapeComposer = new LineComposer(this, subject);
	}
}
