package cards.cardAbilities;

import cards.Card;
import player.Player;

public interface CardAbilityInterface
{
	public void setCard(Card card);
	public void setOwner(Player player);
	public void registerAbility(Card card);
	public void execute();
	public String toString();
}
