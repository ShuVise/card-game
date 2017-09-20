package gameUtilities;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class Hand 
{
	private List<Card>hand = new ArrayList<Card>();
	
	public Hand()
	{
		
	}
	
	public void addCardToHand(Card card)
	{
		hand.add(card);
	}
	
	public Card getCard(int index)
	{
		return hand.get(index);
	}
	
	public void removeCardFromHand(Card card)
	{
		hand.remove(card);
	}
	
	public String toString()
	{
		String output = new String();
		output += '\n';
		for(Card card : hand)
		{
			output += card + "\n";
		}
		return output;
	}
}
