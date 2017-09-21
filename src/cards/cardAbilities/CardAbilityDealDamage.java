package cards.cardAbilities;

import cards.cardsBodies.CardBodyInterface;
import gameState.GameState;

public class CardAbilityDealDamage extends CardAbility 
{

	private int damage;
	private CardBodyInterface target;
	
	private void setTarget()
	{
		CardBodyInterface target = null;
		target = GameState.getGameState().getLowerHero();
		this.target = target;
	}
	
	@Override
	public void execute() 
	{
		setTarget();
		target.inflictDamage(damage);
	}

	@Override
	public void setParameters(String parameters) 
	{
		this.damage = Integer.parseInt(parameters);
	}

}
