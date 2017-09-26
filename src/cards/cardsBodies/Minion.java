package cards.cardsBodies;

import player.Player;

public class Minion implements CardBodyInterface
{
	private int hp, attack;
	private String name;
	private int myId;
	private Player owner;
	public Minion(String name, int attack, int hp)
	{
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.myId = 0;
	}
	
	public int getHP()
	{
		return hp;
	}
	
	public int getAttack()
	{
		return attack;
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
		output = name + " " + attack + "/" + hp;
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
