package main;

import java.util.ArrayList;
import java.util.List;

import cardCache.CardCache;
import cards.cardAbilities.CardAbility;
import cards.cardAbilities.CardAbilityInterface;
import cards.cardAbilities.CardAbilityOnPlay;
import cards.cardAbilities.CardAbilitySummonMinion;
import cards.cardEntities.CardBuilder;
import cards.cardsBodies.Minion;
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
		upperHero.setName("Ronen");
		actionList.add(new PrepareGame(lowerHero,upperHero));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Ram")));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Rem")));
		actionList.add(new ShuffleCardToDeck(lowerHero,cardCache.getCard("Ram")));
		actionList.add(new ShuffleCardToDeck(upperHero,cardCache.getCard("Izaro")));
		actionList.add(new ShuffleCardToDeck(upperHero,cardCache.getCard("Izaro")));
		actionList.add(new DrawCard(lowerHero));
		actionList.add(new DrawCard(upperHero));
		actionList.add(new DrawCard(lowerHero));
	}
	
	private void addMinionToCardCache(String cardName, int minionHp)
	{
		List<CardAbility> cardAbilities = new ArrayList<CardAbility>();
		Minion minion = new Minion(cardName,minionHp);
		CardAbility summonMinion = new CardAbilitySummonMinion(minion);
		CardAbilityOnPlay onPlay = new CardAbilityOnPlay(summonMinion);
		cardAbilities.add(onPlay);
		cardCache.addToCache(cardBuilder.buildCard(cardName,cardAbilities,"minion"));
	}
	
	private void loadCards()
	{
		addMinionToCardCache("Ram",4);
		addMinionToCardCache("Rem",5);
		addMinionToCardCache("Izaro",12);
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
