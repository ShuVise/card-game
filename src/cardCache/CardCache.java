package cardCache;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import cards.Card;

public class CardCache 
{
	private Hashtable<String, CardPrototype> cardCache  = new Hashtable<String, CardPrototype>();
	
	public Card getCard(String name)
	{
		Card card = cardCache.get(name).getCard();
		return card;
	}
	
	public void addToCache(CardPrototype card)
	{
		cardCache.put(card.getName(), card);
		System.out.println("Adding: " + card);
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