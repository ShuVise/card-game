package gameUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cards.Card;

public class Deck 
{
	private List <Card> deck = new ArrayList<Card>();
	Random random = new Random();
	public void shuffleCardToDeck(Card card)
	{
		int order = 0;
		if(deck.size()>0) order = random.nextInt(deck.size());
		deck.add(order, card);
	}
	
	public Card drawCard()
	{
		if(deck.size() == 0)
		{
			return null;
		}
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}
	
	public String toString()
	{
		String output = new String();
		output += '\n';
		for(Card card : deck)
		{
			output+= card + "\n";
		}
		return output;
	}
}
