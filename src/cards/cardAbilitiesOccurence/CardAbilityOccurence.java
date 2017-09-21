package cards.cardAbilitiesOccurence;

import cards.cardAbilities.CardAbility;

public abstract class CardAbilityOccurence implements CardAbilityOccurenceInterface
{
	protected CardAbility cardAbility = null;

	public void setAbility(CardAbility cardAbility)
	{
		this.cardAbility = cardAbility;
	}
	
	public String toStrng()
	{
		return cardAbility.toString();
	}
	
	public CardAbilityOccurence clone()
	{
		return null;
	}
}
