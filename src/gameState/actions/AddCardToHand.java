package gameState.actions;

import cards.Card;
import cards.abilities.Ability;
import cards.abilities.cardAbilities.CardAbility;
import gameState.GameState;
import player.Player;

public class AddCardToHand extends Action
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
		GameState.getGameState().addCardToHand(player, card);
	}

}
