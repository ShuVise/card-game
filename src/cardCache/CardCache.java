package cardCache;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import cards.Card;

public class CardCache 
{
	private Hashtable<String, Card> cardCache  = new Hashtable<String, Card>();
	
	public Card getCard(String name)
	{
		Card card = cardCache.get(name).getCard().clone();
		return card;
	}
	
	public void addToCache(Card card)
	{
		cardCache.put(card.getName(), card);
	}
	
	public String toString()
	{
		String output = new String();
		Set <String> keys = cardCache.keySet();
		Iterator<String> iterator = keys.iterator();
		output += "Cache cointains: \n";
		while(iterator.hasNext())
		{
			output+=cardCache.get(iterator.next()) + "\n";
		}
		return output;
	}
}
