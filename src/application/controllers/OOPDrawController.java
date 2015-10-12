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
import application.models.core.ShapeManager;
import application.models.core.strategy.LineComposer;
import application.models.core.strategy.OvalComposer;
import application.models.core.strategy.RectComposer;
import application.models.interfaces.IShapeComposer;
import application.views.OOPDraw2;

public class OOPDrawController implements MouseListener, MouseMotionListener, 
	ActionListener
{
	private OOPDraw2 view;
	private IShapeComposer currentComposer;
	
	public OOPDrawController(OOPDraw2 view)
	{
		this.view = view;
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
		AbstractShape shape_result = currentComposer.create(arg0.getX(), arg0.getY());
		getShapes().add(shape_result);
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		currentComposer.complete(arg0.getX(), arg0.getY());
		view.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		currentComposer.expand(arg0.getX(), arg0.getY());
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
			currentComposer = new OvalComposer();
		}
		else if(arg0.getActionCommand().equals("rectButton"))
		{
			currentComposer = new RectComposer();
			
		}
		else if(arg0.getActionCommand().equals("clearButton"))
		{
			clearScreen();
		}
	}
	
	public void clearScreen()
	{
		getShapes().clear();
		
		view.repaint();
	}
	
	public void paintAll(Graphics graphics)
	{
		for(Object shape : getShapes() )
		{
			((AbstractShape)shape).draw((Graphics2D)graphics);
		}
	}
	
	private void setComposerToDefault()
	{
		currentComposer = new LineComposer();
	}
	
	private ArrayList<Object> getShapes()
	{
		return ShapeManager.getInstance().getShapes();
	}
}
