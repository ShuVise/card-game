package cards.cardEntities;

import java.util.ArrayList;
import java.util.List;

import cardCache.CardPrototype;
import cards.Card;
import cards.cardAbilities.CardAbility;
import gameState.GameState;

public class VasalCard implements Card
{
	private String name;
	private List<CardAbility> cardAbilities = new ArrayList<CardAbility>();
	public void addAbility(CardAbility ability)
	{
		cardAbilities.add(ability);
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return this.name;
	}
	
	public void play()
	{
		for(CardAbility ability : cardAbilities)
		{
			ability.execute();
		}
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
}
