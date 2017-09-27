package cards.cardUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import cards.Card;
import cards.cardAbilities.CardAbility;
import cards.cardAbilities.CardAbilityDealDamage;
import cards.cardAbilities.CardAbilitySummonMinionLowerHero;
import cards.cardAbilitiesOccurence.CardAbilityOccurence;
import cards.cardAbilitiesOccurence.CardAbilityOnPlay;
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
 * Ability structure: Name of ability # parameters devided by ,| when proced
 * Example:
 * Arrays.asList("Archer","minion","1","1","1","DealDamageTwoTimes#3,1|On play")
 * name: Archer
 * type: minion
 * attack: 1
 * hp: 1
 * mana cost: 1
 * Ability: On play: dead 3 damage to target and then 1 damage to target //DealDamageTwoTimes is not implemented yet
 */
public class CardBuilder 
{
	static private Hashtable<String, CardAbility> abilityHash = new Hashtable<String, CardAbility>();
	static private Hashtable<String, CardAbilityOccurence> occurenceHash  = new Hashtable<String, CardAbilityOccurence>();
	public CardBuilder()
	{
		abilityHash.put("SummonMinion",new CardAbilitySummonMinionLowerHero());
		abilityHash.put("DealDamage", new CardAbilityDealDamage());
		occurenceHash.put("On play", new CardAbilityOnPlay());
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
				CardAbility abilityObject = abilityHash.get("SummonMinion").clone();
				((CardAbilitySummonMinionLowerHero)abilityObject).setMinionSummoned(minion);
				CardAbilityOccurence occurenceObject = new CardAbilityOnPlay();
				abilityObject.setOccurence(occurenceObject);
				occurenceObject.registerAbility(abilityObject, minionCard);
			}
			for(int i=5;i<properties.size();i++)
			{
				String ability,parameters,occurence,abilityString;
				abilityString = properties.get(i);
				ability = abilityString.substring(0, abilityString.indexOf('#'));
				parameters = abilityString.substring(abilityString.indexOf('#')+1, abilityString.indexOf('|'));
				occurence = abilityString.substring(abilityString.indexOf('|')+1, abilityString.length());
				CardAbilityOccurence occurenceObject = (CardAbilityOccurence) occurenceHash.get(occurence).clone();
				CardAbility abilityObject = abilityHash.get(ability).clone();
				abilityObject .setParameters(parameters);
				abilityObject.setOccurence(occurenceObject);
				occurenceObject.registerAbility(abilityObject, minionCard);
			}
			minionCard.setName(name);
			card = minionCard;
		}
		return card;
	}
}
