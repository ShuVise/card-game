package cards.abilitiesOccurence.minionAbilitiesOccurence;

import cards.Card;
import cards.abilities.cardAbilities.CardAbility;
import cards.abilities.minionAbilities.MinionAbility;
import cards.abilitiesOccurence.cardAbilitiesOccurence.CardAbilityOccurence;
import cards.cardsBodies.Minion;
import gameState.actions.MinionDies;

public class MinionAbilityOccurenceMinionDies extends MinionAbilityOccurence
{

	@Override
	public MinionAbilityOccurence clone() {
		return new MinionAbilityOccurenceMinionDies();
	}

	@Override
	public void registerAbility(MinionAbility ability, Minion minion)
	{
		this.ability = ability;
		minion.addAbility(ability);
		ability.setTargetMinion(minion);
	}

	@Override
	public void minionPlayed() 
	{
		MinionDies.addAbility(ability);
	}
	
	

}
