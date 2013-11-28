import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

import static org.lwjgl.opengl.GL11.*;

public class Camera{
	
	private Vector2f CameraPos;
	private GameComponent GC;
	private boolean slow;
	private boolean manual;
	private float velocity;
	private float x,y,xb,yb;
	
	public Camera(GameComponent GC)
	{
		this.GC = GC;
		x = (int) GC.getPosition().x;
		y = (int) GC.getPosition().y;
	}
	
	private void DoLogic()
	{
		CameraPos = new Vector2f(GC.getPosition().x, GC.getPosition().y);
		x = (float) (CameraPos.x+15 - Display.getDisplayMode().getWidth() /2);
		y = (float) (CameraPos.y+30 - Display.getDisplayMode().getHeight() /2);
		
		xb = (float) (CameraPos.x+15 + Display.getDisplayMode().getWidth() / 2);
		yb = (float) (CameraPos.y+30 + Display.getDisplayMode().getHeight() / 2);

		
	}
	
	public void update()
	{
		if( Keyboard.isKeyDown(Keyboard.KEY_Z))
		{
			System.out.println("FreeForm camera enabled!");
			manual = (manual) ? false : true;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(manual)
		{	
			
			HandleKeyboard();
		}
		else
		{
			DoLogic();
		}
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(x, xb, yb, y, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	
	}
	
	private void HandleKeyboard()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
		{
			yb--;
			y--;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S))
		{
			yb++;
			y++;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			xb--;
			x--;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			xb++;
			x++;
		}
	}

}
