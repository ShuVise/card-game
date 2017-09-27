package cards.cardUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import cards.Card;
import cards.abilities.Ability;
import cards.abilities.cardAbilities.CardAbility;
import cards.abilities.cardAbilities.CardAbilityDealDamage;
import cards.abilities.cardAbilities.CardAbilitySummonMinionLowerHero;
import cards.abilities.minionAbilities.MinionAbility;
import cards.abilities.minionAbilities.MinionAbilityGainStats;
import cards.abilitiesOccurence.AbilityOccurence;
import cards.abilitiesOccurence.cardAbilitiesOccurence.CardAbilityOccurence;
import cards.abilitiesOccurence.cardAbilitiesOccurence.CardAbilityOnPlay;
import cards.abilitiesOccurence.minionAbilitiesOccurence.MinionAbilityOccurenceMinionDies;
import cards.abilitiesOccurence.minionAbilitiesOccurence.MinionAbilityOccurence;
import cards.cardEntities.MinionCard;
import cards.cardsBodies.Minion;


/*
 * String in order for minion cards:
 * 0 - name
 * 1 - type
 * 2 - attack
 * 3 - hp
 * 4 - mana cost
 * 5 and lower - abilities 
 * Ability structure: Name of ability &Card/Minion # parameters devided by ,| when proced
 * Example:
 * Arrays.asList("Archer","minion","1","1","1","Card","DealDamageTwoTimes#3,1|On play")
 * name: Archer
 * type: minion
 * attack: 1
 * hp: 1
 * mana cost: 1
 * Ability: On play: dead 3 damage to target and then 1 damage to target //DealDamageTwoTimes is not implemented yet
 */
public class CardBuilder 
{
	static private Hashtable<String, CardAbility> cardAbilityHash = new Hashtable<String, CardAbility>();
	static private Hashtable<String, CardAbilityOccurence> cardOccurenceHash  = new Hashtable<String, CardAbilityOccurence>();
	static private Hashtable<String, MinionAbilityOccurence> minionOccurenceHash  = new Hashtable<String, MinionAbilityOccurence>();
	static private Hashtable<String, MinionAbility> minionAbilityHash  = new Hashtable<String, MinionAbility>();
	public CardBuilder()
	{
		cardAbilityHash.put("SummonMinion",new CardAbilitySummonMinionLowerHero());
		cardAbilityHash.put("DealDamage", new CardAbilityDealDamage());
		cardOccurenceHash.put("On play", new CardAbilityOnPlay());
		minionOccurenceHash.put("MinionDies",new MinionAbilityOccurenceMinionDies());
		minionAbilityHash.put("GainStats",new MinionAbilityGainStats());
	}
	
	public Card buildCard(List<String> properties)
	{
		/*
		Minion minion = new Minion(cardName,minionHp,minionAttack);
		cardCache.addToCache(cardBuilder.buildCard(cardName,cardAbilities,"minion"));
		Card card = null;
		*/
		Card card = null;
		String name = properties.get(0);
		String type = properties.get(1);
		if(type.equalsIgnoreCase("minion"))
		{
			MinionCard minionCard = new MinionCard();
			int minionHp = Integer.parseInt(properties.get(2));
			int minionAttack = Integer.parseInt(properties.get(3));
			int manaCost = Integer.parseInt(properties.get(4));
			Minion minion = new Minion(name,minionHp,minionAttack);
			{
				CardAbility abilityObject = (CardAbility) cardAbilityHash.get("SummonMinion").clone();
				((CardAbilitySummonMinionLowerHero)abilityObject).setMinionSummoned(minion);
				CardAbilityOccurence occurenceObject = new CardAbilityOnPlay();
				abilityObject.setOccurence(occurenceObject);
				occurenceObject.registerAbility(abilityObject, minionCard);
			}
			for(int i=5;i<properties.size();i++)
			{
				String ability,parameters,occurence,abilityString,abilityType;
				abilityString = properties.get(i);
				ability = abilityString.substring(0, abilityString.indexOf('$'));
				abilityType = abilityString.substring(abilityString.indexOf('$')+1, abilityString.indexOf('#'));
				parameters = abilityString.substring(abilityString.indexOf('#')+1, abilityString.indexOf('|'));
				occurence = abilityString.substring(abilityString.indexOf('|')+1, abilityString.length());
				if(abilityType.equalsIgnoreCase("card"))
				{
					CardAbilityOccurence occurenceObject = (CardAbilityOccurence) cardOccurenceHash.get(occurence).clone();
					CardAbility abilityObject = (CardAbility) cardAbilityHash.get(ability).clone();
					abilityObject .setParameters(parameters);
					abilityObject.setOccurence(occurenceObject);
					occurenceObject.registerAbility(abilityObject, minionCard);
				}
				else if(abilityType.equalsIgnoreCase("minion"))
				{
					MinionAbilityOccurence occurenceObject = (MinionAbilityOccurence) minionOccurenceHash.get(occurence).clone();
					MinionAbility abilityObject = (MinionAbility) minionAbilityHash.get(ability).clone();
					abilityObject .setParameters(parameters);
					abilityObject.setOccurence(occurenceObject);
					occurenceObject.registerAbility(abilityObject, minion);
				}
			}
			minionCard.setName(name);
			card = minionCard;
		}
		return card;
	}
}
