package guiEngine.guiUtilities;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import guiEngine.gameWindowStates.WindowState;
import guiEngine.guiUtilities.font.CustomFont;

public class Button extends JPanel
{
	private WindowState ws = null;
	private String text = null;
	private CustomFont font;
	private int x=0, y=0;
	private int height = 20;
	private int myId;
	public Button(WindowState ws, int buttonId)
	{
		super();
		text = new String("Text hasnt been added yet");
		init(ws, buttonId);
	}
	
	public Button(String text, WindowState ws, int buttonId)
	{
		super();
		this.text = text;
		init(ws, buttonId);
	}
	
	private void init(WindowState ws, int buttonId)
	{
		font = new CustomFont();
		this.ws = ws;
		myId = buttonId;
	}
	
	public void setPosition(int x, int y)
	{
		FontMetrics fm = getFontMetrics(font.getFont());
		int width = fm.stringWidth(text);
		this.x = x-((int)width/2);
		this.y = y-height;
		this.setBounds(this.x, this.y, width, height);
		System.out.println(this.x + " " + this.y);
	}
	
	public void draw(Graphics2D g)
	{
		Font saveFont = g.getFont();
		g.setFont(font.getFont());
		height = g.getFontMetrics().getHeight();
		g.drawString(text, x, y+height);
		g.setFont(saveFont);
	}
	
	public void pressed()
	{
		ws.buttonPressed(myId);
	}
}
