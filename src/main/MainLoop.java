package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cardCache.CardCache;
import cards.cardEntities.CardBuilder;
import gameState.GameState;
import gameState.actions.*;
import player.Player;

public class MainLoop implements Runnable
{
	private GameState gameState;
	private CardCache cardCache;
	private CardBuilder cardBuilder;
	private boolean isOpen = true;
	private List <Action> actionList;
	public MainLoop()
	{
		gameState = GameState.getGameState();
		actionList = new ArrayList <Action>();
		cardCache = new CardCache();
		cardBuilder = new CardBuilder();
		loadCards();
		prepareGameState();
		Action action = new ShowGameState(gameState);
		actionList.add(action);
		new Thread(this).start();
	}
	
	private void prepareGameState()
	{
		Player lowerHero,upperHero;
		lowerHero = new Player();
		upperHero = new Player();
		lowerHero.setName("Valerian");
		lowerHero.setHp(30);
		upperHero.setName("Ronen");
		upperHero.setHp(30);
		actionList.add(new PrepareGame(lowerHero,upperHero));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Ram")));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Rem")));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Ram")));
		actionList.add(new ShuffleCardToDeck(upperHero,cardCache.getCard("Archer")));
		actionList.add(new ShuffleCardToDeck(upperHero,cardCache.getCard("Archer")));
		actionList.add(new DrawCard(lowerHero));
		actionList.add(new DrawCard(upperHero));
		actionList.add(new DrawCard(lowerHero));
		actionList.add(new PlayCardFromHand(lowerHero,0));
		actionList.add(new PlayCardFromHand(lowerHero,0));
		actionList.add(new PlayCardFromHand(upperHero,0));
		actionList.add(new DrawCard(lowerHero));
	}
	
	private void loadCards()
	{
		List <String> properties = new ArrayList<String>();
		properties.addAll(Arrays.asList("Rem","minion","3","4","3"));
		cardCache.addToCache(cardBuilder.buildCard(properties));
		properties.clear();
		properties.addAll(Arrays.asList("Ram","minion","3","5","3"));
		cardCache.addToCache(cardBuilder.buildCard(properties));
		properties.clear();
		properties.addAll(Arrays.asList("Izaro","minion","8","12","8"));
		cardCache.addToCache(cardBuilder.buildCard(properties));
		properties.clear();
		properties.addAll(Arrays.asList("Archer","minion","1","1","1","DealDamage#3|On play"));
		cardCache.addToCache(cardBuilder.buildCard(properties));
		properties.clear();
		System.out.println(cardCache);
	}

	@Override
	public void run() 
	{
		Action action = null;
		while(isOpen)
		{
			if(actionList.size()==0)
			{
				isOpen = false;
			}
			else
			{
				action = actionList.get(0);
				actionList.remove(0);
				action.execute();
				action = null;
			}
		}
	}
}
