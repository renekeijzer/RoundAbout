import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glVertex2f;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;


public class Player extends GameComponent{
	private Vector2f Position, velocity;
	private boolean AbG;
	private static int Width = 30, Height = 62;
	private float maxVelocity, minVelocity;
	private boolean isFalling;
	
	public Vector2f getPosition() {	return this.Position;}
	public void setPosition(Vector2f position) { this.Position = position;}
	
	public boolean isAbG() {return this.AbG;} 
	public void setAbG(boolean abG) {this.AbG = abG;}
	

	public Player(Vector2f Pos)
	{
		super(true, Pos);
		this.minVelocity = -10;
		this.maxVelocity = 10;
		this.velocity = new Vector2f(0,0);
		
		this.Position = Pos;
		this.AbG = true;
	}
	
	@Override
	public void draw() {
		Color.white.bind();
			glBegin(GL_QUADS);
			glColor3f(0.5f,0.5f,1.0f);
			glVertex2f(Position.x, Position.y);
			glVertex2f(Position.x, Position.y + Height);
			glVertex2f(Position.x + Width, Position.y + Height);
			glVertex2f(Position.x + Width, Position.y);
		glEnd();
	}

	@Override
	public void update() {
			calculateGravity();
	//	if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
	//	{
	//		
	//	}
		
		
			
		if( Keyboard.isKeyDown(Keyboard.KEY_A)){
			if(velocity.x > minVelocity)
			{
				velocity.x = velocity.x - 0.5f;
			}
		}else if( Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			if(velocity.x < maxVelocity)
			{
				velocity.x = velocity.x + 0.5f;
			}
		}else
		{
			if(velocity.x < 0)
			{
				velocity.x = velocity.x + 0.5f;
			}else if (velocity.x > 0)
			{
				velocity.x = velocity.x - 0.5f;
			}
		}

		Position.x = Position.x + velocity.x;
		
		}

	@Override
	public void initialize() {
		glEnable(GL_TEXTURE_2D);
		glClearColor(0.0f,0.0f,0.0f,0.0f);	
		
	}



}
