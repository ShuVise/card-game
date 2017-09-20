package gameState.actions;

import player.Player;
import gameState.GameState;

public class PrepareGame implements Action
{
	private Player playerOne = null, playerTwo = null;
	public PrepareGame(Player playerOne, Player playerTwo)
	{
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	public void execute() 
	{
		GameState gameState = GameState.getGameState();
		gameState.addLowerHero(playerOne);
		gameState.addUpperHero(playerTwo);
	}

}
