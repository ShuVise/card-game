package gameState.actions;

import cards.Card;
import cards.cardAbilities.CardAbility;
import gameState.GameState;
import gameState.actions.actionExceptions.NoCardsInDeckException;
import player.Player;

public class DrawCard implements Action
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
		System.out.println(player.getName() + " draws: " + card + '\n');
		new AddCardToHand(player,card).execute();
	}

	@Override
	public void registerAbility(CardAbility ability) {
		// TODO Auto-generated method stub
		
	}
}
