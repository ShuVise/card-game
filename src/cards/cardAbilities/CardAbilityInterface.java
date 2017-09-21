package cards.cardAbilities;

import cards.Card;
import player.Player;

public interface CardAbilityInterface extends Cloneable
{
	public void setCard(Card card);
	public void setOwner(Player player);
	public void setParameters(String parameters);
	public void registerAbility(Card card);
	public void execute();
	public String toString();
	public CardAbility clone();
}
