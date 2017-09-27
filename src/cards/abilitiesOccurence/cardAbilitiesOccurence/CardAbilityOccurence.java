package cards.abilitiesOccurence.cardAbilitiesOccurence;

import java.lang.reflect.InvocationTargetException;

import cards.Card;
import cards.abilities.cardAbilities.CardAbility;
import cards.abilitiesOccurence.AbilityOccurence;

public abstract class CardAbilityOccurence extends AbilityOccurence
{
	public abstract void registerAbility(CardAbility ability, Card card);
}
