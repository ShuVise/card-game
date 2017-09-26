package gameState.actions;

import cards.Card;
import cards.cardAbilities.CardAbility;
import gameState.GameState;
import player.Player;

public class ShuffleCardToDeck implements Action 
{
	private Player player;
	private Card card;
	public ShuffleCardToDeck(Player player, Card card)
	{
		this.player = player;
		this.card = card;
		card.setOwner(player);
		card.registerAbilities();
	}
	public void execute() 
	{
		System.out.println("Shuffling card " + card + " to " + player.getName() + "'s deck\n");
		GameState.getGameState().addCardToDeck(player, card);
	}
	@Override
	public void registerAbility(CardAbility ability) {
		// TODO Auto-generated method stub
		
	}

}
