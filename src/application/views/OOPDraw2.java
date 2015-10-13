package application.views;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import application.controllers.OOPDrawController;
import application.models.factory.ComposerFactory;
import application.models.interfaces.IShapeComposer;

public class OOPDraw2 extends JFrame
{
	private static final long serialVersionUID = 4695753453561082104L;
	private Button btnClear;
	boolean brect = false;
	private OOPDrawController controller;

	public OOPDraw2()
	{
		controller = new OOPDrawController(this);
		initGUI();
	}

	@Override
	public void paint(Graphics g)
	{
		setShapeDetails(g);
		controller.paintAll(g);
	}
	
	public void setShapeDetails(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, getSize().width, getSize().height);
		g.setColor(new Color(255, 255, 154));
		g.fillRect(1, 1, getSize().width - 3, getSize().height - 3);
	}
	
	private void initGUI()
	{
		setFrameOptions();
		setMouseListener();
		initializeButtons();
	}
	
	public void setFrameOptions()
	{
		setSize(800, 600);
		setTitle("POSE 2.0 hairy drawing tool");
		setLayout(new FlowLayout());
	}
	
	public void setMouseListener()
	{
		this.addMouseListener(controller);
		this.addMouseMotionListener(controller);
	}
	
	public void initializeButtons()
	{
		ComposerFactory composerFactory = ComposerFactory.getInstance();
		
		for(IShapeComposer composer : composerFactory.getComposers())
		{
			String composerName = composer.getClass().getSimpleName();
			
			Button button = new Button(composerName.replace("Composer", ""));
			button.setActionCommand(composerName);
			button.addActionListener(controller);
			
			add(button);
		}
		
		btnClear = new Button("Clear");
		btnClear.setActionCommand("clearButton");
		btnClear.addActionListener(controller);
		add(btnClear);
	}
}
