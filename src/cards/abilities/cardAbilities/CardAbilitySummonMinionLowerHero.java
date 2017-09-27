package cards.abilities.cardAbilities;

import cards.cardsBodies.Minion;
import gameState.GameState;
import guiEngine.guiUtilities.BoardGUI;

public class CardAbilitySummonMinionLowerHero extends CardAbility
{
	private Minion minion;
	
	public void setMinionSummoned(Minion minion)
	{
		this.minion = minion;
	}
	
	public void execute() 
	{
		minion.summoned();
		GameState.getGameState().addVasalToField(minion);
		BoardGUI.getInstance().addMinionToBoardLowerHero(card,minion);
	}
	
	public String toString()
	{
		String output = new String();
		output+= minion;
		return output;
	}

	@Override
	public void setParameters(String parameters) 
	{
		
	}

	@Override
	protected CardAbility cloneProtect() {
		CardAbilitySummonMinionLowerHero cloned = new CardAbilitySummonMinionLowerHero();
		if(minion!=null)
		{
			cloned.setMinionSummoned(minion.clone());
		}
		return cloned;
	}

	@Override
	public CardAbility clone() {
		CardAbilitySummonMinionLowerHero cloned = new CardAbilitySummonMinionLowerHero();
		return cloned;
	}
}
