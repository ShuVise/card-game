package cards.cardAbilitiesOccurence;

import cards.Card;
import cards.cardAbilities.CardAbility;

public interface CardAbilityOccurenceInterface extends Cloneable
{
	public void setAbility(CardAbility ability);
	public void setParameters(String parameters);
	public CardAbilityOccurence clone();
	public void addAbilityToCard(Card card);
}
