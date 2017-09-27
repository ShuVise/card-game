package cards.abilities.minionAbilities;

import cards.abilities.Ability;
import cards.abilities.cardAbilities.CardAbility;
import gameState.actions.MinionDies;
import gameState.actions.MinionGainsStats;
import main.MainLoop;

public class MinionAbilityGainStats extends MinionAbility
{
	private int attackGain,hpGain;
	@Override
	public void execute() 
	{
		System.out.println("Working");
		MainLoop.addAction(new MinionGainsStats(minion,attackGain,hpGain));
	}

	@Override
	public void registerAbility() 
	{
		MinionDies.addAbility(this);
	}
	
	public MinionAbilityGainStats()
	{
		
	}
	
	private MinionAbilityGainStats(int attackGain, int hpGain)
	{
		this.attackGain = attackGain;
		this.hpGain = hpGain;
	}
	public void setParameters(String parameters)
	{
		System.out.println(parameters);
		String attack = parameters.substring(0, parameters.indexOf('/'));
		String hp = parameters.substring(parameters.indexOf('/')+1,parameters.length());
		int attackSign = 1;
		if(attack.charAt(0)=='-') attackSign =-1;
		int hpSign = 1;
		if(hp.charAt(0)=='-') attackSign =-1;
		attackGain = Integer.parseInt(attack.substring(1, attack.length()))*attackSign;
		hpGain = Integer.parseInt(hp.substring(1, hp.length()))*hpSign;
		
	}
	@Override
	protected MinionAbility cloneProtect() {
		return new MinionAbilityGainStats(attackGain,hpGain);
	}

	@Override
	public MinionAbility clone() {
		return new MinionAbilityGainStats();
	}


}
