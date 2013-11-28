import java.io.IOException;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;

public class Block extends GameComponent {

	private Texture texture;
	private Vector2f Position, velocity;
	private String BlockType;
	private boolean AbG;
	private boolean isFalling;

	public final static int Width = 32, Height = 32;

	public Vector2f getPosition() {
		return this.Position;
	}

	public void setPosition(Vector2f position) {
		this.Position = position;
	}

	public String getBlockType() {
		return this.BlockType;
	}

	public void setBlockType(String blockType) {
		this.BlockType = blockType;
	}

	public Block(String nwType, Vector2f pos) {
		super(false, pos);
		this.BlockType = nwType;
		this.Position = pos;
		if (BlockType == "Sand") {
			setAbG(true);
		}
		try {
			if(BlockType!="Air"){
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Assets/" + BlockType
							+ "/tile0.png"));
			}
		} catch (IOException e) {

			e.printStackTrace();
			System.exit(0);
		}

	}

	@Override
	public void draw() {
		Color.white.bind();
		if(BlockType!="Air"){	
		texture.bind();
		glBegin(GL_QUADS);

		int x = (int) Position.x;
		int y = (int) Position.y;

		int xb = (int) Position.x + Width;
		int yb = (int) Position.y + Height;

		glTexCoord2f(0, 0);
		glVertex2f((float) x, (float) y);

		glTexCoord2f(0, 1);
		glVertex2f((float) x, (float) yb);

		glTexCoord2f(1, 1);
		glVertex2f((float) xb, (float) yb);

		glTexCoord2f(1, 0);
		glVertex2f((float) xb, (float) y);
		glEnd();
		}
		
	}

	@Override
	public void update() {
		calculateGravity();
	}

	@Override
	public void initialize() {
		try {
			glEnable(GL_TEXTURE_2D);
			glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
