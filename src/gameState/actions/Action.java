package gameState.actions;

import cards.cardAbilities.CardAbility;

public interface Action
{
	public void execute();
	public void registerAbility(CardAbility ability);
}
