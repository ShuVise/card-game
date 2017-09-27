package cards.abilities.minionAbilities;

import cards.abilities.Ability;
import cards.abilitiesOccurence.minionAbilitiesOccurence.MinionAbilityOccurence;
import cards.cardsBodies.Minion;

public abstract class MinionAbility extends Ability
{
	protected Minion minion;
	
	public abstract void registerAbility();
	public abstract MinionAbility clone();
	protected abstract MinionAbility cloneProtect();
	
	public void minionPlayed()
	{
		MinionAbilityOccurence occurence2 = (MinionAbilityOccurence) occurence;
		occurence2.minionPlayed();
	}
	
	public void setTargetMinion(Minion minion)
	{
		this.minion = minion;
	}

	public MinionAbility cloneToMinion(Minion minion) {
		MinionAbility cloned = cloneProtect();
		MinionAbilityOccurence occurenceCloned = (MinionAbilityOccurence) occurence.clone();
		cloned.setOccurence(occurenceCloned);
		cloned.setTargetMinion(minion);
		occurenceCloned.registerAbility(cloned, minion);
		return cloned;
	}
	
}
