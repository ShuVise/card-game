package cards.cardAbilities;

import cards.cardsBodies.Minion;
import gameState.GameState;
import gameUtilities.boardPcg.Board;

public class CardAbilitySummonMinion extends CardAbility
{
	private Minion minion;
	public CardAbilitySummonMinion(Minion minion)
	{
		this.minion = minion;
	}
	
	public void execute() 
	{
		System.out.println("Summoned minion: " + minion + " for " + owner.getName() + "\n");
		minion.setOwner(owner);
		GameState.getGameState().addVasalToField(minion);
		Board.getInstance().addMinionToBoard(minion);
	}
	
	public String toString()
	{
		String output = new String();
		output+= minion;
		return output;
	}

	@Override
	public void setParameters(String parameters) 
	{
		
	}
}
