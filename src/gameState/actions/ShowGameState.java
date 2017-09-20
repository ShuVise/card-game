package gameState.actions;

import gameState.GameState;

public class ShowGameState implements Action
{
	private GameState gameState;
	public ShowGameState(GameState gameState)
	{
		this.gameState = gameState;
	}
	@Override
	public void execute() 
	{
		System.out.println(gameState);
	}
	
}
