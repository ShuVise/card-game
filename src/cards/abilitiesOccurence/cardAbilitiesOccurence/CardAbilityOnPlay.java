package cards.abilitiesOccurence.cardAbilitiesOccurence;

import cards.Card;
import cards.abilities.cardAbilities.CardAbility;
import player.Player;

public class CardAbilityOnPlay extends CardAbilityOccurence
{
	public void registerAbility(CardAbility ability, Card card)
	{
		card.registerOnPlayEffect(ability);
	}
	
	@Override
	public CardAbilityOccurence clone() {
		// TODO Auto-generated method stub
		return new CardAbilityOnPlay();
	}
}
