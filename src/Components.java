import java.util.ArrayList;

public class Components {
	private ArrayList<GameComponent> comp;

	public Components() {
		comp = new ArrayList<GameComponent>();
	}

	public void add(GameComponent nwComp)
	{
		comp.add(nwComp);
	}
	
	public void remove(GameComponent nwComp)
	{
		comp.remove(nwComp);
	}
	
	public ArrayList<GameComponent> getComponents()
	{
		return comp;
		
	}

}
