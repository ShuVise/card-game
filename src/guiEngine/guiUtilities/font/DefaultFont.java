package guiEngine.guiUtilities.font;

import java.awt.Font;

public class DefaultFont
{
	protected Font font = null;
	private static Font defaultFont = new Font("Courier New", Font.ITALIC, 12);
	DefaultFont()
	{
		font = defaultFont;
	}
	public Font getFont()
	{
		return font;
	}
}
