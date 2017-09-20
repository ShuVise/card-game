package cards.cardEntities;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.cardAbilities.CardAbility;
import cards.cardAbilities.CardAbilityInterface;
import gameState.GameState;
import player.Player;

public class MinionCard implements Card
{
	private String name;
	private Player owner;
	private List<CardAbility> cardOnPlayEffects = new ArrayList<CardAbility>();
	public void addAbility(CardAbility ability)
	{
		ability.registerAbility(this);
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
	
	public void play(Player player) 
	{
		for(CardAbilityInterface ability : cardOnPlayEffects)
		{
			ability.execute();
		}
	}
}
