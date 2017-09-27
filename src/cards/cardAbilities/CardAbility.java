package cards.cardAbilities;

import java.lang.reflect.InvocationTargetException;

import cards.Card;
import cards.cardAbilitiesOccurence.CardAbilityOccurence;
import player.Player;

public abstract class CardAbility
{
	protected Card card;
	protected Player owner;
	protected CardAbilityOccurence occurence = null;
	public abstract void execute();
	public abstract void setParameters(String parameters);
	protected abstract CardAbility cloneProtect();
	public abstract CardAbility clone();
	public void setOccurence(CardAbilityOccurence occurence)
	{
		this.occurence = occurence;
	}
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
		CardAbilityOccurence clonedOccurence = occurence.clone();
		CardAbility cloned = cloneProtect();
		cloned.setOccurence(clonedOccurence);
		cloned.setCard(card);
		clonedOccurence.registerAbility(cloned, card);
	}
	
}
