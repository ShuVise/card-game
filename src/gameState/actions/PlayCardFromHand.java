package gameState.actions;

import cards.Card;
import gameState.GameState;
import guiEngine.guiUtilities.HandLowerGUI;
import player.Player;

public class PlayCardFromHand implements Action
{

	private int cardIndex;
	private Player player;
	private Card card = null;
	
	
	public PlayCardFromHand(Player player, int cardIndex)
	{
		this.cardIndex = cardIndex;
		this.player = player;
	}
	
	public PlayCardFromHand(Card card)
	{
		this.player = card.getOwner();
		this.card = card;
	}
	
	public void execute() 
	{
		if(card==null)
		{
		Card card = GameState.getGameState().getCardFromHand(cardIndex, player);
		GameState.getGameState().removeCardFromHand(player,card);
		card.play();
		}
		else
		{
			GameState.getGameState().removeCardFromHand(player,card);
			HandLowerGUI.getInstance().removeCardFromHand(card);
			card.play();
		}
	}

}
