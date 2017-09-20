package gameState.actions;

import cards.Card;
import gameState.GameState;
import player.Player;

public class PlayCardFromHand implements Action
{

	private int cardIndex;
	private Player player;
	
	public PlayCardFromHand(Player player, int cardIndex)
	{
		this.cardIndex = cardIndex;
		this.player = player;
	}
	public void execute() 
	{
		Card card = GameState.getGameState().getCardFromHand(cardIndex, player);
		GameState.getGameState().removeCardFromHand(player,card);
		card.play();
	}

}
