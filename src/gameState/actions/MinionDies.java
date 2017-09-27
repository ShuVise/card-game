package gameState.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import cards.abilities.Ability;
import cards.abilities.cardAbilities.CardAbility;
import cards.cardsBodies.Minion;

public class MinionDies extends Action
{

	private static Semaphore abilitySem = new Semaphore(1);
	private static List<Ability> abilities = new ArrayList<Ability>();
	private Minion minion = null;
	
	public static void addAbility(Ability ability)
	{
		System.out.println("Added");
		try {
			abilitySem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		abilities.add(ability);
		abilitySem.release();
	}
	
	public MinionDies(Minion minion)
	{
		this.minion = minion;
	}
	
	@Override
	public void execute() 
	{
		minion.dies();
		try {
			abilitySem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Ability ability : abilities)
		{
			ability.execute();
		}
		abilitySem.release();
	}

}
