package screens;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class RoundAboutScreen{
	
	public int WINDOWWIDTH;
	public int WINDOWHEIHGT;
	
	public RoundAboutScreen(int wdHeight, int wdWidth)
	{
		try {
			this.WINDOWWIDTH = wdWidth;
			this.WINDOWHEIHGT = wdHeight;
			
			Display.setDisplayMode(new DisplayMode(wdHeight, wdWidth));
			Display.setVSyncEnabled(true);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
}
