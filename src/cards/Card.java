package cards;

import cards.cardAbilities.CardAbility;
import guiEngine.BodyGUI;
import guiEngine.guiUtilities.CardGUI;
import player.Player;

public interface Card extends Cloneable
{
	public String getName();
	public void play();
	public void select();;
	public void registerOnPlayEffect(CardAbility ability);
	public Card getCard();
	public Card clone();
	public void setGUICenter(BodyGUI gui);
	public BodyGUI getGUICenter();
}
