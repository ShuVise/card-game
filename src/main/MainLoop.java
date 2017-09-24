package main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cardCache.CardCache;
import cards.cardEntities.CardBuilder;
import gameState.GameState;
import gameState.actions.*;
import guiEngine.GameMainWindow;
import player.Player;



public class MainLoop implements Runnable
{
	private GameMainWindow gameWindow = null;
	public static GameState gameState;
	private CardCache cardCache;
	private CardBuilder cardBuilder;
	private boolean isOpen = true;
	private static List <Action> actionList;
	private static Semaphore actionListLock = new Semaphore(1);
	private static Semaphore runningLock = new Semaphore(1);
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
		gameWindow = new GameMainWindow();
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
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Archer")));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Izaro")));
		actionList.add(new ShuffleCardToDeck(upperHero,cardCache.getCard("Archer")));
		actionList.add(new ShuffleCardToDeck(upperHero,cardCache.getCard("Archer")));
		actionList.add(new DrawCard(lowerHero));
		actionList.add(new DrawCard(upperHero));
		actionList.add(new DrawCard(lowerHero));
		actionList.add(new PlayCardFromHand(lowerHero,0));
		actionList.add(new PlayCardFromHand(lowerHero,0));
		actionList.add(new PlayCardFromHand(upperHero,0));
		//actionList.add(new DrawCard(upperHero));
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

	public static void addAction(Action action)
	{
		try {
			actionListLock.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Added action");
		actionList.add(action);
		actionListLock.release();
		runningLock.release();
		
	}
	
	@Override
	public void run() 
	{	
		Action action = null;
		while(isOpen)
		{
			try {
				runningLock.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				actionListLock.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(actionList.size()>0)
			{
				action = actionList.get(0);
				actionList.remove(0);
				actionListLock.release();
				action.execute();
				action = null;
				runningLock.release();
			}
			else
			{
				actionListLock.release();
			}
		}
	}
}
