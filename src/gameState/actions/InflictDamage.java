package gameState.actions;

import cards.abilities.Ability;
import cards.abilities.cardAbilities.CardAbility;
import cards.cardsBodies.CardBodyInterface;

public class InflictDamage extends Action {

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
