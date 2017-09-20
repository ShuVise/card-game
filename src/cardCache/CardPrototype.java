package cardCache;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.cardAbilities.CardAbility;

public abstract class CardPrototype
{
	protected String name;
	protected List<CardAbility> cardAbilities = new ArrayList<CardAbility>();
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void addCardAbility(CardAbility ability)
	{
		cardAbilities.add(ability);
	}
	public abstract Card getCard();
	
	public String toString() 
	{
		String output = new String("");
		for(CardAbility ability : cardAbilities)
		{
			output += ability + " ";
		}
		return output;
	}
}
