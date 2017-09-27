package cards.cardsBodies;

import guiEngine.BodyGUI;
import guiEngine.guiUtilities.CardGUI;

public interface CardBodyInterface 
{
	public void select();
	public void inflictDamage(int damage);
	public void setGUI(BodyGUI gui);
	public BodyGUI getGU();
	public void dies();
}
