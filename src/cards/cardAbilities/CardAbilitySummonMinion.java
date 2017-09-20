package cards.cardAbilities;

import cards.cardsBodies.Vasal;
import gameState.GameState;

public class CardAbilitySummonMinion implements CardAbility
{
	private Vasal minion;
	public CardAbilitySummonMinion(Vasal minion)
	{
		this.minion = minion;
	}
	
	public void execute() 
	{
		GameState.getGameState().addVasalToField(minion);
	}
	
	public String toString()
	{
		String output = new String();
		output+= minion;
		return output;
	}
}
