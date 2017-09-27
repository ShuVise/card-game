package player;

import cards.cardsBodies.CardBodyInterface;
import guiEngine.BodyGUI;

public class Player implements PlayerInterface, CardBodyInterface
{
	private int hp;
	private String name;
	
	public Player()
	{
		
	}
	
	public void setHp(int hp)
	{
		this.hp = hp;
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
		output += name + " - life: " + hp;
		return output;
	}

	@Override
	public void select() 
	{
		
	}

	private void checkIfAlive()
	{
		if(hp<=0)
		{
			System.out.println(name + " has died!");
		}
	}
	
	@Override
	public void inflictDamage(int damage) 
	{
		hp-=damage;
		System.out.println("Deatl damage " + damage + " to " + name);
		checkIfAlive();
		
	}

	@Override
	public void setGUI(BodyGUI gui) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BodyGUI getGU() {
		// TODO Auto-generated method stub
		return null;
	}
}
