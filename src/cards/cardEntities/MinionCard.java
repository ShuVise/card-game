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
	private List<List<CardAbility>> cardAbilities = new ArrayList<List<CardAbility>>();
	private List<CardAbility> cardOnPlayEffects = new ArrayList<CardAbility>();
	public MinionCard()
	{
		cardAbilities.add(cardOnPlayEffects);
	}
	public void addAbility(CardAbility ability)
	{
		ability.registerAbility(this);
	}
	public void registerAbilities()
	{
		for(List<CardAbility> list : cardAbilities)
		{
			for(CardAbility ability : list)
			{
				System.out.println(ability);
				ability.setOwner(owner);
			}
		}
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
		for(CardAbilityInterface ability : cardOnPlayEffects)
		{
			ability.execute();
		}
	}
	
	public Card clone()
	{
		MinionCard card = new MinionCard();
		card.name = this.name;
		card.owner = this.owner;
		card.cardOnPlayEffects = new ArrayList(cardOnPlayEffects);
		card.cardAbilities = new ArrayList(cardAbilities);
		return card;
	}
}
