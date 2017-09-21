package cards.cardAbilities;

import java.lang.reflect.InvocationTargetException;

import cards.Card;
import player.Player;

public abstract class CardAbility implements CardAbilityInterface
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
	
	public void registerAbility(Card card)
	{
		
	}
	
	public CardAbility clone()
	{
		try {
			return getClass().getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}
