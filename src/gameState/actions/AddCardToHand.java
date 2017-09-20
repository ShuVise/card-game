package gameState.actions;

import cards.Card;
import gameState.GameState;
import player.Player;

public class AddCardToHand implements Action
{
	private Player player;
	private Card card;
	public AddCardToHand(Player player, Card card)
	{
		this.player = player;
		this.card  = card;
	}
	public void execute() 
	{
		System.out.println("Adding card " + card + " to " + player.getName() + "'s hand\n");
		GameState.getGameState().addCardToHand(player, card);
	}

}
