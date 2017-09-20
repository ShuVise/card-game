package cards.cardsBodies;

import player.Player;

public class Minion implements CardBodyInterface
{
	private int hp;
	private String name;
	private int myId;
	private Player owner;
	public Minion(String name, int hp)
	{
		this.name = name;
		this.hp = hp;
		this.myId = 0;
	}
	
	public void setOwner(Player player)
	{
		this.owner = player;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getMyId()
	{
		return myId;
	}
	
	public void setMyId(int id)
	{
		myId = id;
	}
	
	public void select() 
	{
		
	}

	public String toString()
	{
		String output = new String();
		output = name + " " + hp;
		return output;
	}
}
