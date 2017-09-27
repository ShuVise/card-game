package gameState.actions;

import cards.abilities.cardAbilities.CardAbility;
import cards.cardsBodies.Minion;

public class MinionGainsStats extends Action
{

	private Minion minion = null;
	private int attackGain = 0;
	private int hpGain = 0;
	public MinionGainsStats(Minion minion, int attackGain, int hpGain)
	{
		this.minion = minion;
		this.attackGain = attackGain;
		this.hpGain = hpGain;
	}
	@Override
	public void execute() 
	{
		minion.setAttack(minion.getAttack()+attackGain);
		minion.setHP(minion.getHP()+hpGain);
	}

}
