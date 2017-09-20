package cards.cardAbilities;

import cards.Card;
import cards.cardsBodies.Minion;
import gameState.GameState;

public class CardAbilitySummonMinion extends CardAbility
{
	private Minion minion;
	public CardAbilitySummonMinion(Minion minion)
	{
		this.minion = minion;
	}
	
	public void execute() 
	{
		minion.setOwner(card.getOwner());
		GameState.getGameState().addVasalToField(minion);
	}
	
	public String toString()
	{
		String output = new String();
		output+= minion;
		return output;
	}
}
