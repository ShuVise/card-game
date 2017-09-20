package player;


public class Player implements PlayerInterface
{
	private int life;
	private String name;
	
	public Player()
	{
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public String toString()
	{
		String output = new String();
		output += name + " - life: " + life;
		return output;
	}
}
