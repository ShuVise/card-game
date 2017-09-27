package cards.cardEntities;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.cardAbilities.CardAbility;
import gameState.GameState;
import guiEngine.BodyGUI;
import guiEngine.guiUtilities.MinionGUI;
import player.Player;

public class MinionCard implements Card
{
	private BodyGUI center = null;
	private String name;
	private Player owner;
	private List<CardAbility> cardOnPlayEffects = new ArrayList<CardAbility>();
	
	private MinionGUI parent = null;
	public MinionCard()
	{
	}
	
	public void setParent(MinionGUI parent)
	{
		this.parent = parent;
	}
	public Card getCard()
	{
		return this;
	}
	
	public void registerOnPlayEffect(CardAbility ability)
	{
		cardOnPlayEffects.add(ability);
	}
	
	public void setOwner(Player player)
	{
		owner = player;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return this.name;
	}
	
	public void select()
	{
		System.out.println(name + "'s stats: ");
	}
	
	public String toString()
	{
		String output = new String();
		output += name;
		return output;
	}
	
	public void play() 
	{
		for(CardAbility ability : cardOnPlayEffects)
		{
			ability.execute();
		}
	}
	@Override
	public Card clone()
	{
		MinionCard newMinion = new MinionCard();
		newMinion.setName(name);
		for(CardAbility ability : cardOnPlayEffects)
		{
			ability.cloneToCard(newMinion);
		}
		return newMinion;
	}

	@Override
	public void setGUICenter(BodyGUI gui)
	{
		center = gui;
	}

	@Override
	public BodyGUI getGUICenter() 
	{
		return center;
	}
}
