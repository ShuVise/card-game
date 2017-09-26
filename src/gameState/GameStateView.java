package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

import cards.Card;
import gameUtilities.Hand;
import guiEngine.GamePanel;
import guiEngine.guiUtilities.HandLowerGUI;

public class GameStateView 
{
	private GameState gameState = null;
	private int noCards;
	private int middle;
	private int leftSide;
	private List<Card> cards = null;
	private HandLowerGUI hand = HandLowerGUI.getInstance();
	
	public GameStateView(GameState gameState)
	{
		this.gameState = gameState;
	}
	
	public void update()
	{
		
	}
	
	public void draw(Graphics2D g)
	{
		Font saveFont = g.getFont();
		int iterator = 0;
		hand.draw(g);
		g.setFont(saveFont);
	}
}
