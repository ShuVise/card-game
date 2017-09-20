package cards.cardAbilities;

import cards.Card;

public abstract class CardAbility implements CardAbilityInterface
{
	protected Card card;
	
	public void setCard(Card card)
	{
		this.card = card;
	}
	
	public Card getCard()
	{
		return card;
	}
	
	public void registerAbility(Card card)
	{
		
	}
	
}
