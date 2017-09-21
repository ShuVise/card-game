package guiEngine.guiUtilities.font;

import java.awt.Font;

public class CustomFont extends DefaultFont
{
	private String fontName;
	private int fontType;
	private int fontSize;
	
	public CustomFont()
	{
		super();
	}
	
	public CustomFont(String fontName,int fontType, int fontSize)
	{
		this.fontName = fontName;
		this.fontType = fontType;
		this.fontSize = fontSize;
		updateFont();
	}
	 
	public void setFont(String fontName, int fontType, int fontSize)
	{
		this.fontName = fontName;
		this.fontType = fontType;
		this.fontSize = fontSize;
	}
	
	public void updateFont()
	{
		this.font = new Font(fontName,fontType,fontSize);
	}
}
