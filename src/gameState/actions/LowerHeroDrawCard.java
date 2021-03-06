package gameState.actions;

import cards.Card;
import cards.abilities.Ability;
import cards.abilities.cardAbilities.CardAbility;
import gameState.GameState;
import gameState.actions.actionExceptions.NoCardsInDeckException;
import guiEngine.guiUtilities.HandLowerGUI;
import player.Player;

public class LowerHeroDrawCard extends Action
{
	
	public LowerHeroDrawCard()
	{
		
	}
	
	@Override
	public void execute() 
	{
		GameState gState = GameState.getGameState();
		Player player = gState.getLowerHero();
		if(!gState.hasCardsInDeck(player)) throw new NoCardsInDeckException();
		Card card = GameState.getGameState().getTopCardFromDeck(player);
		new AddCardToHand(player,card).execute();
		HandLowerGUI.getInstance().addCardToHand(card);
	}
}
