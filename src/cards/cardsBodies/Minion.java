package cards.cardsBodies;

import player.Player;

public class Minion implements CardBodyInterface
{
	private int hp, attack;
	private String name;
	private int myId;
	private Player owner;
	public Minion(String name, int hp, int attack)
	{
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.myId = 0;
	}
	
	public void setOwner(Player player)
	{
		this.owner = player;
	}
	
	public Player getOwner()
	{
		return owner;
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
		output = name + " " + hp + "/" + attack;
		return output;
	}

	private void checkIfAlive()
	{
		if(hp <= 0)
		{
			System.out.println(name + " has died!");
		}
	}
	
	@Override
	public void inflictDamage(int damage)
	{
		hp-=damage;
		checkIfAlive();
	}
}
