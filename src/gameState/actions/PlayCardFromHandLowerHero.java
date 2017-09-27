package gameState.actions;

import cards.Card;
import cards.abilities.cardAbilities.CardAbility;
import gameState.GameState;
import guiEngine.guiUtilities.HandLowerGUI;
import player.Player;

public class PlayCardFromHandLowerHero extends Action
{
	private Player player = GameState.getGameState().getLowerHero();
	private Card card = null;
	public PlayCardFromHandLowerHero(Card card)
	{
		this.card = card;
	}
	
	public void execute() 
	{
		GameState.getGameState().removeCardFromHand(player,card);
		HandLowerGUI.getInstance().removeCardFromHand(card);
		card.play();
	}
}
