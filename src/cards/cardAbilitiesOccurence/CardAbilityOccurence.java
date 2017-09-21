package cards.cardAbilitiesOccurence;

import java.lang.reflect.InvocationTargetException;

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
		try {
			return getClass().getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}
