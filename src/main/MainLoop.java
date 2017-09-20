package main;

import java.util.ArrayList;
import java.util.List;

import cardCache.CardCache;
import cards.cardAbilities.CardAbility;
import cards.cardAbilities.CardAbilitySummonMinion;
import cards.cardEntities.CardBuilder;
import cards.cardsBodies.Vasal;
import gameState.GameState;
import gameState.actions.*;
import player.Player;
import player.PlayerInterface;

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
		upperHero.setName("Ronen");
		actionList.add(new PrepareGame(lowerHero,upperHero));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Ram")));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Rem")));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Ram")));
		actionList.add(new ShuffleCardToDeck(upperHero,cardCache.getCard("Izaro")));
		actionList.add(new ShuffleCardToDeck(upperHero,cardCache.getCard("Izaro")));
		actionList.add(new DrawCard(lowerHero));
		actionList.add(new DrawCard(upperHero));
	}
	
	private void loadCards()
	{
		{
			String cardName = "Ram";
			int minionHp = 4;
			List<CardAbility> cardAbilities = new ArrayList<CardAbility>();
			Vasal vasal = new Vasal(cardName,minionHp);
			CardAbility summonMinion = new CardAbilitySummonMinion(vasal);
			cardAbilities.add(summonMinion);
			cardCache.addToCache(cardBuilder.buildCard(cardName,cardAbilities,"minion"));
		}
		{
			String cardName = "Rem";
			int minionHp = 6;
			List<CardAbility> cardAbilities = new ArrayList<CardAbility>();
			Vasal vasal = new Vasal(cardName,minionHp);
			CardAbility summonMinion = new CardAbilitySummonMinion(vasal);
			cardAbilities.add(summonMinion);
			cardCache.addToCache(cardBuilder.buildCard(cardName,cardAbilities,"minion"));
		}
		{
			String cardName = "Izaro";
			int minionHp = 12;
			List<CardAbility> cardAbilities = new ArrayList<CardAbility>();
			Vasal vasal = new Vasal(cardName,minionHp);
			CardAbility summonMinion = new CardAbilitySummonMinion(vasal);
			cardAbilities.add(summonMinion);
			cardCache.addToCache(cardBuilder.buildCard(cardName,cardAbilities,"minion"));
		}
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
