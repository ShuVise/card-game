package cards.cardAbilitiesOccurence;

import cards.Card;
import cards.cardAbilities.CardAbility;
import player.Player;

public class CardAbilityOnPlay extends CardAbilityOccurence
{
	public void registerAbility(Card card) 
	{
	}

	public void setParameters(String parameters) 
	{
		
	}

	@Override
	public void addAbilityToCard(Card card) 
	{
		card.registerOnPlayEffect(cardAbility);
		cardAbility.setCard(card);
	}
}
