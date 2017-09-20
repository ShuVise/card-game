package cards.cardEntities;

import java.util.List;

import cardCache.CardPrototype;
import cardCache.VasalPrototype;
import cards.cardAbilities.CardAbility;

public class CardBuilder 
{
	
	public CardPrototype buildCard(String name, List<CardAbility> cardAbilities, String type)
	{
		CardPrototype card = null;
		if(type.equalsIgnoreCase("minion"))
		{
			System.out.println("Building card named: " + name);
			card = new VasalPrototype();
			card.setName(name);
			for(CardAbility ability : cardAbilities) card.addCardAbility(ability);
		}
		return card;
	}
}
