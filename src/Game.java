import java.util.ArrayList;


import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import screens.RoundAboutScreen;

import static org.lwjgl.opengl.GL11.*;

public class Game {
	private Components components;
	private Camera camera;
	private LevelGenerator gl;
	private long lastFPS = 0;
	private int fps = 0;

	//ArrayList<GameComponent> components;

	public Game() {
		RoundAboutScreen RAS = new RoundAboutScreen(816,816);

		
		components = new Components();
		gl = new LevelGenerator(1);
		components = gl.GenerateLevel(1, components);
		CollisionDetectionService cds = new CollisionDetectionService(components);
		
		initGl(RAS.WINDOWHEIHGT, RAS.WINDOWWIDTH);

		lastFPS = getTime();
		
		do
		{
			glClear(GL_COLOR_BUFFER_BIT);
			updateFPS();
			for(GameComponent comp : components.getComponents())
			{
				comp.update();
				comp.draw();
			}
			camera.update();
			Display.update();
		}
		while(!Display.isCloseRequested());
	}
	public void updateFPS() {
	    
		if (getTime() - lastFPS > 1000) {
	        Display.setTitle("FPS: " + fps);
		fps = 0;
		lastFPS += 1000;
	    }
	    fps++;
	}
	
	public long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public void initGl(int height, int width)
	{
		camera = new Camera(gl.getPlayer());
		glEnable(GL_BLEND);
		glViewport(0,0,width,height);
		glMatrixMode(GL_MODELVIEW);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);		
	}
	

}
