package gameState.actions;

import cards.Card;
import cards.abilities.cardAbilities.CardAbility;
import gameState.GameState;
import player.Player;

public class ShuffleCardToDeck extends Action
{
	private Player player;
	private Card card;
	public ShuffleCardToDeck(Player player, Card card)
	{
		this.player = player;
		this.card = card;
	}
	public void execute() 
	{
		GameState.getGameState().addCardToDeck(player, card);
	}

}
