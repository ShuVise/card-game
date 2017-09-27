package cards.cardAbilitiesOccurence;

import java.lang.reflect.InvocationTargetException;

import cards.Card;
import cards.cardAbilities.CardAbility;

public abstract class CardAbilityOccurence implements Cloneable
{
	public abstract CardAbilityOccurence clone();
	public abstract void registerAbility(CardAbility ability, Card card);
}
