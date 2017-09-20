package cards.cardEntities;

import java.util.List;

import cards.Card;
import cards.cardAbilities.CardAbility;
import cards.cardAbilities.CardAbilityInterface;

public class CardBuilder 
{
	
	public Card buildCard(String name, List<CardAbility> cardAbilities, String type)
	{
		Card card = null;
		if(type.equalsIgnoreCase("minion"))
		{
			System.out.println("Building card named: " + name);
			MinionCard minionCard = new MinionCard();
			minionCard.setName(name);
			for(CardAbility ability : cardAbilities) minionCard.addAbility(ability);
			card = minionCard;
		}
		return card;
	}
}
