package cards.abilities.cardAbilities;

import gameState.actions.InflictDamage;
import guiEngine.BodyGUI;
import guiEngine.guiUtilities.Targeting;
import main.MainLoop;

public class CardAbilityDealDamage extends CardAbility 
{

	private int damage;
	@Override
	public void execute() 
	{
		Targeting selectedTarget = new Targeting(card.getGUICenter().getCenter());
		BodyGUI targetGUI = selectedTarget.getTarget();
		if(targetGUI!=null)MainLoop.addAction(new InflictDamage(targetGUI.getBody(),damage));
	}
	
	@Override
	public void setParameters(String parameters) 
	{
		this.damage = Integer.parseInt(parameters);
	}


	private void setParametersCloning(int damage)
	{
		this.damage = damage;
	}
	@Override
	protected CardAbility cloneProtect() 
	{
		CardAbilityDealDamage cloned = new CardAbilityDealDamage();
		cloned.setParametersCloning(damage);
		return cloned;
	}

	@Override
	public CardAbility clone() {
		CardAbilityDealDamage cloned = new CardAbilityDealDamage();
		return cloned;
	}


}
