package cards;

import cards.cardAbilities.CardAbility;
import player.Player;

public interface Card 
{
	public String getName();
	public void play(Player player);
	public void select();
	public Player getOwner();
	public void registerOnPlayEffect(CardAbility ability);
	public Card getCard();
}
