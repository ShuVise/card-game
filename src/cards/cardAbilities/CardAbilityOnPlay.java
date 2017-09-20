package cards.cardAbilities;

import cards.Card;

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
		System.out.println("Registering on play effect");
		card.registerOnPlayEffect(cardAbility);
	}

	@Override
	public void execute() 
	{
		cardAbility.execute();
		
	}
	
	public String toStrng()
	{
		return cardAbility.toString();
	}
}
