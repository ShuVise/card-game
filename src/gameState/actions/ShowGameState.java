package gameState.actions;

import cards.abilities.cardAbilities.CardAbility;
import gameState.GameState;

public class ShowGameState extends Action
{
	private GameState gameState;
	public ShowGameState(GameState gameState)
	{
		this.gameState = gameState;
	}
	@Override
	public void execute() 
	{

	}
	
}
