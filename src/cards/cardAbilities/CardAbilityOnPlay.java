package cards.cardAbilities;

import cards.Card;
import player.Player;

public class CardAbilityOnPlay extends CardAbility
{
	private CardAbility cardAbility = null;
	public CardAbilityOnPlay(CardAbility cardAbility)
	{
		this.cardAbility = cardAbility;
	}

	@Override
	public void registerAbility(Card card) 
	{
		card.registerOnPlayEffect(cardAbility);
		cardAbility.setCard(card);
	}

	@Override
	public void execute() 
	{
		
	}
	
	public String toStrng()
	{
		return cardAbility.toString();
	}
}
