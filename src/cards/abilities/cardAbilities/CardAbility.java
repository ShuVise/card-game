package cards.abilities.cardAbilities;

import cards.Card;
import cards.abilities.Ability;
import cards.abilitiesOccurence.cardAbilitiesOccurence.CardAbilityOccurence;
import player.Player;

public abstract class CardAbility extends Ability
{
	protected Card card;
	protected Player owner;
	public void setCard(Card card)
	{
		this.card = card;
	}
	
	public Card getCard()
	{
		return card;
	}
	
	
	public void setOwner(Player player)
	{
		owner = player;
	}
	
	public void cloneToCard(Card card)
	{
		CardAbilityOccurence clonedOccurence = (CardAbilityOccurence) occurence.clone();
		CardAbility cloned = (CardAbility) cloneProtect();
		cloned.setOccurence(clonedOccurence);
		cloned.setCard(card);
		clonedOccurence.registerAbility(cloned, card);
	}
	
}
