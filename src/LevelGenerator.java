import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.util.vector.Vector2f;

public class LevelGenerator {
	public Components components;
	private ArrayList<ArrayList<Block>> Map;
	private Player player;
	public String[] strTypes;
	private int Level;

	public Player getPlayer() {	return this.player;}
	public void setPlayer(Player player) {	this.player = player;}
	
	public ArrayList<ArrayList<Block>> GetLevel() {return this.Map;}
	
	public LevelGenerator(int nwLevel) {
		strTypes = new String[] { "Air", "Solid", "Lava", "Water", "Sand",
				"Gravel", "Spikes", "Wood", "Stone", "Ice", "Mines", "Bombs",
				"Glass", };

		
		Level = nwLevel;
		Map = new ArrayList<ArrayList<Block>>();
	}

	public Components GenerateLevel(int Level, Components components) {
		ArrayList<Block> temprow = new ArrayList<Block>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("levels/level" + Level + ".txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String line = null;
		try {
			int y = 0;
			while ((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				int x = 0;	
				
				for(String str : tmp)
					{
						
						Block block;
						if(x == 0 && y == 0)
						{
						block = new Block(strTypes[Integer.parseInt(str)], new Vector2f(0,0));
						}
						else if (x == 0)
						{
						block = new Block(strTypes[Integer.parseInt(str)], new Vector2f(0, Block.Height * y));
						}
						else
						{
						block = new Block(strTypes[Integer.parseInt(str)], new Vector2f(Block.Width * x, Block.Height * y));
						}
						x++;
						temprow.add(block);
						components.add(block);
					}
				Map.add(temprow);
				y++;
			}
			player = new Player(new Vector2f(0,0));
			components.add(player);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return components;
	}
}
