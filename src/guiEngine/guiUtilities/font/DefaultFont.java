package guiEngine.guiUtilities.font;

import java.awt.Font;

import guiEngine.GamePanel;

public class DefaultFont
{
	protected Font font = null;
	private static Font defaultFont = new Font("Courier New", Font.ITALIC, (int) (12*GamePanel.scale/1.5));
	DefaultFont()
	{
		font = defaultFont;
	}
	public Font getFont()
	{
		return font;
	}
}
