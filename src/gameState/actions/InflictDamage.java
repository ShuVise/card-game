package gameState.actions;

import cards.cardAbilities.CardAbility;
import cards.cardsBodies.CardBodyInterface;

public class InflictDamage implements Action {

	private int damage;
	private CardBodyInterface target = null;
	
	public InflictDamage(CardBodyInterface target, int damage)
	{
		this.target = target;
		this.damage = damage;
	}
	
	@Override
	public void execute() 
	{
		target.inflictDamage(damage);
	}

}
