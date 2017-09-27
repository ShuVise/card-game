package cards.cardsBodies;

import guiEngine.BodyGUI;
import guiEngine.guiUtilities.CardGUI;
import player.Player;

public class Minion implements CardBodyInterface
{
	private int hp, attack;
	private String name;
	private int myId;
	private BodyGUI gui = null;
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
	
	public Minion clone()
	{
		Minion cloned = new Minion(name,attack,hp);
		return cloned;
	}

	@Override
	public void setGUI(BodyGUI gui) 
	{
		this.gui = gui;
	}

	@Override
	public BodyGUI getGU() {
		return gui;
	}
}
