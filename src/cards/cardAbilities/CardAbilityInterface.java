package cards.cardAbilities;

import cards.Card;

public interface CardAbilityInterface
{
	public void setCard(Card card);
	public void registerAbility(Card card);
	public void execute();
	public String toString();
}
