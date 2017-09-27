package cards.abilitiesOccurence.minionAbilitiesOccurence;

import cards.Card;
import cards.abilities.cardAbilities.CardAbility;
import cards.abilities.minionAbilities.MinionAbility;
import cards.abilitiesOccurence.AbilityOccurence;
import cards.cardsBodies.Minion;

public abstract class MinionAbilityOccurence extends AbilityOccurence 
{
	protected MinionAbility ability = null;
	public abstract void registerAbility(MinionAbility ability, Minion minion);
	public abstract void minionPlayed();
}
