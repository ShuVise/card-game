package cards.cardAbilities;

import cards.cardsBodies.CardBodyInterface;
import gameState.GameState;
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
		Targeting selectedTarget = new Targeting(0,0);
		BodyGUI targetGUI = selectedTarget.getTarget();
		System.out.println(targetGUI.getName());
		if(targetGUI!=null)MainLoop.addAction(new InflictDamage(targetGUI.getBody(),damage));
	}
	
	@Override
	public void setParameters(String parameters) 
	{
		this.damage = Integer.parseInt(parameters);
	}

}
