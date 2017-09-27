package gameState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cards.Card;
import cards.cardsBodies.Minion;
import gameUtilities.Deck;
import gameUtilities.Hand;
import player.Player;

public class GameState implements GameStateInterface
{
	public static int lowerHero = 0;
	public static int upperHero = 1;
	private Player[] hero = new Player[2];
	private List<Minion> minionsOnBoard = new ArrayList<Minion>();
	private Map<Player,Hand> heroHand = new HashMap<Player,Hand>();
	private Map<Player,Deck> heroDeck = new HashMap<Player,Deck>();
	private int whosTurn = lowerHero;
	private static GameState gameState = new GameState();
	public static GameState getGameState()
	{
		return gameState;
	}
	
	public void reset()
	{
		hero[lowerHero] = null;
		hero[upperHero] = null;
		minionsOnBoard.clear();
	}
	
	public void addLowerHero(Player hero)
	{
		this.hero[lowerHero] = hero;
		heroHand.put(hero, new Hand());
		heroDeck.put(hero, new Deck());
	}
	
	public Player getLowerHero()
	{
		return hero[lowerHero];
	}
	
	public Player getUpperHero()
	{
		return hero[upperHero];
	}
	public void addUpperHero(Player hero)
	{
		this.hero[upperHero] = hero;
		heroHand.put(hero, new Hand());
		heroDeck.put(hero, new Deck());
	}
	
	public int getWhosTurn()
	{
		return whosTurn;
	}
	
	public void removeMinionFromField(Minion minion)
	{
		minionsOnBoard.remove(minion);
	}
	
	public void addVasalToField(Minion minion)
	{
		minionsOnBoard.add(minion);
	}
	
	public void addCardToHand(Player player, Card card)
	{
		heroHand.get(player).addCardToHand(card);
	}
	
	public void removeCardFromHand(Player player, Card card)
	{
		heroHand.get(player).removeCardFromHand(card);
	}
	
	public void addCardToDeck(Player player, Card card)
	{
		heroDeck.get(player).shuffleCardToDeck(card);
	}
	
	public Card getTopCardFromDeck(Player player)
	{
		return heroDeck.get(player).drawCard();
	}
	
	public Card getCardFromHand(int index, Player player)
	{
		return heroHand.get(player).getCard(index);
	}
	
	public boolean hasCardsInDeck(Player player)
	{
		return heroDeck.get(player).hasCardsInDeck();
	}
	
	public Hand getLowerHand()
	{
		return heroHand.get(hero[lowerHero]);
	}
	
	public String toString()
	{
		String output = new String();
		//output += "It's " + hero[whosTurn].getName() + "'s turn";
		for(Player player : hero)
		{
			output+= player + "\n\n";
			output+= player.getName() + " has in hand: " + heroHand.get(player) + '\n';
			output+= player.getName() + " has in deck: " + heroDeck.get(player) + '\n';
			output+= player.getName() + " has on board:\n";
			output += '\n';
		}
		return output;
	}
}
