package gameState.actions;

import cards.Card;
import cards.abilities.Ability;
import cards.abilities.cardAbilities.CardAbility;
import gameState.GameState;
import gameState.actions.actionExceptions.NoCardsInDeckException;
import player.Player;

public class DrawCard extends Action
{
	private Player player;
	
	public DrawCard(Player player)
	{
		this.player = player;
	}
	
	public void execute() 
	{
		if(!GameState.getGameState().hasCardsInDeck(player)) throw new NoCardsInDeckException();
		Card card = GameState.getGameState().getTopCardFromDeck(player);
		new AddCardToHand(player,card).execute();
	}
}
