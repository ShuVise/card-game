package cards.abilities;

import cards.abilities.cardAbilities.CardAbility;
import cards.abilitiesOccurence.AbilityOccurence;

public abstract class Ability 
{

	public abstract void execute();
	public abstract void setParameters(String parameters);
	protected abstract Ability cloneProtect();
	protected AbilityOccurence occurence = null;
	public void setOccurence(AbilityOccurence occurence)
	{
		this.occurence = occurence;
	}
	public abstract Ability clone();
}
