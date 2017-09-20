package cards;

import cards.cardAbilities.CardAbility;
import player.Player;

public interface Card extends Cloneable
{
	public String getName();
	public void play();
	public void select();
	public void registerAbilities();
	public void setOwner(Player player);
	public Player getOwner();
	public void registerOnPlayEffect(CardAbility ability);
	public Card getCard();
	public Card clone();
}
