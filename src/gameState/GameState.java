package gameState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cards.Card;
import cards.cardEntities.VasalCard;
import cards.cardsBodies.Vasal;
import gameUtilities.Deck;
import gameUtilities.Hand;
import player.Player;

public class GameState implements GameStateInterface
{
	public static int lowerHero = 0;
	public static int upperHero = 1;
	private Player[] hero = new Player[2];
	private List<Vasal> heroesVasals = new ArrayList<Vasal>();
	private Map<Player,Hand> heroHand = new HashMap<Player,Hand>();
	private Map<Player,Deck> heroDeck = new HashMap<Player,Deck>();
	private int whosTurn = lowerHero;
	private static GameState gameState = new GameState();
	private int vasalIdNumer = 0;
	public static GameState getGameState()
	{
		return gameState;
	}
	
	public void reset()
	{
		hero[lowerHero] = null;
		hero[upperHero] = null;
		heroesVasals.clear();
	}
	
	public void addLowerHero(Player hero)
	{
		this.hero[lowerHero] = hero;
		heroHand.put(hero, new Hand());
		heroDeck.put(hero, new Deck());
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
	
	public void addVasalToField(Vasal vasal)
	{
		heroesVasals.add(vasal);
		vasal.setMyId(vasalIdNumer++);
	}
	
	public void addCardToHand(Player player, Card card)
	{
		heroHand.get(player).addCardToHand(card);
	}
	
	public void addCardToDeck(Player player, Card card)
	{
		heroDeck.get(player).shuffleCardToDeck(card);
	}
	
	public Card getTopCardFromDeck(Player player)
	{
		System.out.println(heroDeck);
		return heroDeck.get(player).drawCard();
	}
	
	public Vasal getVasal(int vasalId)
	{
		for(Vasal vasal : heroesVasals)
		{
			if(vasal.getMyId() == vasalId) return vasal;
		}
		return null;
	}
	
	public String toString()
	{
		String output = new String();
		//output += "It's " + hero[whosTurn].getName() + "'s turn";
		for(int i = 0; i<hero.length;i++)
		{
			output+= hero[i].getName() + " has in hand: " + heroHand.get(hero[i]) + '\n';
			output+= hero[i].getName() + " has in deck: " + heroDeck.get(hero[i]) + '\n';
		}
		return output;
	}
}
