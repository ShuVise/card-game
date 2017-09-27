package gameState.actions;

import cards.Card;
import cards.cardAbilities.CardAbility;
import gameState.GameState;
import guiEngine.guiUtilities.HandLowerGUI;
import player.Player;

public class PlayCardFromHandLowerHero implements Action
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

	@Override
	public void registerAbility(CardAbility ability) {
		// TODO Auto-generated method stub
		
	}

}
