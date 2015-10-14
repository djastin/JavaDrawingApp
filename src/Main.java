import application.models.core.strategy.FunnyShapeComposer;
import application.models.core.strategy.LineComposer;
import application.models.core.strategy.OvalComposer;
import application.models.core.strategy.RectComposer;
import application.models.factory.ComposerFactory;
import application.views.OOPDraw2;

public class Main 
{
	public static void main(String[] args)
	{
		/* Loading composers */
		
		ComposerFactory composerFactory = ComposerFactory.getInstance();

		LineComposer lineComposer = new LineComposer();
		OvalComposer ovalComposer = new OvalComposer();
		RectComposer rectComposer = new RectComposer();	
		FunnyShapeComposer funnyShapeComposer = new FunnyShapeComposer();
		
		composerFactory.addComposer(lineComposer);
		composerFactory.addComposer(ovalComposer);
		composerFactory.addComposer(rectComposer);
		composerFactory.addComposer(funnyShapeComposer);
			
		OOPDraw2 frame = new OOPDraw2();
		frame.setVisible(true);
	}
}
