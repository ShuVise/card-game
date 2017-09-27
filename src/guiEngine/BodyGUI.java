package guiEngine;

import java.awt.Point;

import cards.cardsBodies.CardBodyInterface;
import guiEngine.guiUtilities.GUIUtility;

public abstract class BodyGUI extends GUIUtility
{
	public abstract CardBodyInterface getBody();
	public abstract Point getCenter();
}