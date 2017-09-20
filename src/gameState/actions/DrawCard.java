package gameState.actions;

import cards.Card;
import gameState.GameState;
import player.Player;

public class DrawCard implements Action
{
	
	private Player player;
	
	public DrawCard(Player player)
	{
		this.player = player;
	}
	
	public void execute() 
	{
		Card card = GameState.getGameState().getTopCardFromDeck(player);
		System.out.println(player.getName() + " draws: " + card + '\n');
		new AddCardToHand(player,card).execute();
	}

}