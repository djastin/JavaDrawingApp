package application.controllers;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import application.models.facade.ComposerFacade;
import application.views.OOPDraw2;

public class OOPDrawController implements MouseListener, MouseMotionListener, 
	ActionListener
{
	private OOPDraw2 view;
	private ComposerFacade composerFacade;
	
	public OOPDrawController(OOPDraw2 view)
	{
		this.view = view;
		
		composerFacade = new ComposerFacade();
		composerFacade.setComposerToDefault();
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
		composerFacade.createShape(arg0.getX(), arg0.getY());
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		composerFacade.completeShape(arg0.getX(), arg0.getY());
		view.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		composerFacade.expandShape(arg0.getX(), arg0.getY());
		view.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) { }

	@Override
	public void actionPerformed(ActionEvent arg0)
	{		
		composerFacade.setCurrentComposer(arg0.getActionCommand());
		
		if(arg0.getActionCommand().equals("clearButton"))
			clearScreen();
	}
	
	public void clearScreen()
	{
		composerFacade.clearShapes();
		view.repaint();
	}
	
	public void paintAll(Graphics graphics)
	{
		composerFacade.paintAllShapes(graphics);
	}
}
