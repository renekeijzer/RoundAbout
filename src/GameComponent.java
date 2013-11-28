import org.lwjgl.util.vector.Vector2f;


public abstract class GameComponent implements MovableGameObject {
	private Vector2f velocity;
	private float gravity = 0.5f;
	private boolean AbG;
	private boolean grounded;
	
	public void setAbG(boolean abg){this.AbG = abg;}
	
	protected Vector2f Position;
	
	
	public GameComponent(boolean AbG, Vector2f Position)
	{
		this.AbG = AbG;
		this.Position = Position;
		velocity = new Vector2f(0,0);
		initialize();
		
	};
	
	
	public abstract void draw();
	public abstract void update();
	public abstract void initialize();
	public abstract Vector2f getPosition();
	
	public void calculateGravity()
	{
		if(AbG && !grounded)
		{
			velocity.y = velocity.y + gravity;
			Position.y = Position.y + velocity.y;
		}
	}

	
}