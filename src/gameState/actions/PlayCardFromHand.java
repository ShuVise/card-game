package gameState.actions;

import cards.Card;
import player.Player;

public class PlayCardFromHand implements Action
{

	private Card card;
	private Player player;
	
	public PlayCardFromHand(Player player, Card card)
	{
		this.card = card;
		this.player = player;
	}
	public void execute() 
	{
		card.play(player);
	}

}
