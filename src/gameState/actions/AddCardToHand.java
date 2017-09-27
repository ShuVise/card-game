package gameState.actions;

import cards.Card;
import cards.cardAbilities.CardAbility;
import gameState.GameState;
import player.Player;

public class AddCardToHand implements Action
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
	@Override
	public void registerAbility(CardAbility ability) {
		// TODO Auto-generated method stub
		
	}

}
