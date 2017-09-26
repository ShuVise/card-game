package guiEngine;

import cards.cardsBodies.CardBodyInterface;
import guiEngine.guiUtilities.GUIUtility;

public abstract class BodyGUI extends GUIUtility
{
	public abstract CardBodyInterface getBody();
}
