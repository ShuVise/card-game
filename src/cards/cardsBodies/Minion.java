package cards.cardsBodies;

import gameState.GameState;
import gameState.actions.MinionDies;
import guiEngine.BodyGUI;
import guiEngine.guiUtilities.BoardGUI;
import guiEngine.guiUtilities.CardGUI;
import main.MainLoop;
import player.Player;

public class Minion implements CardBodyInterface
{
	private int hp, attack;
	private String name;
	private BodyGUI gui = null;
	public Minion(String name, int attack, int hp)
	{
		this.name = name;
		this.hp = hp;
		this.attack = attack;
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
			MainLoop.addAction(new MinionDies(this));
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

	@Override
	public void dies() 
	{
		GameState.getGameState().removeMinionFromField(this);
		BoardGUI.getInstance().removeBodyFromField(gui);
	}
}
