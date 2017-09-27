package gameState.actions;

import cards.cardAbilities.CardAbility;
import cards.cardsBodies.Minion;

public class MinionDies implements Action
{

	private Minion minion = null;
	
	public MinionDies(Minion minion)
	{
		this.minion = minion;
	}
	
	@Override
	public void execute() 
	{
		minion.dies();
	}

}
