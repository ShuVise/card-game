package cardCache;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.cardAbilities.CardAbility;
import cards.cardEntities.VasalCard;

public class VasalPrototype extends CardPrototype
{
	public Card getCard()
	{
		VasalCard card = new VasalCard();
		card.setName(this.name);
		for(CardAbility ability : cardAbilities)
		{
			card.addAbility(ability);
		}
		return (Card)card;
	}
}
