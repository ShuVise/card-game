package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

import cards.Card;
import gameUtilities.Hand;
import guiEngine.GamePanel;

public class GameStateView 
{
	private GameState gameState = null;
	private static Font cardNameFont = new Font("Ariel",Font.PLAIN,11);
	private int noCards;
	private int middle;
	private int leftSide;
	private List<Card> cards = null;
	
	
	public GameStateView(GameState gameState)
	{
		this.gameState = gameState;
	}
	
	public void update()
	{
		cards = gameState.getLowerHand().getCards();
		noCards = cards.size();
		middle = GamePanel.getMyWidth()/2;
		leftSide = -(noCards/2)*GamePanel.cardInHandWidth;
	}
	
	public void draw(Graphics2D g)
	{
		Font saveFont = g.getFont();
		g.setFont(cardNameFont);
		int iterator = 0;
		for(Card card : cards)
		{
			g.setColor(Color.BLACK);
			int x = middle+leftSide + iterator*GamePanel.cardInHandWidth;
			int y = GamePanel.getMyHeight()-GamePanel.cardInHandHeight;
			g.drawRect(x, y, GamePanel.cardInHandWidth, GamePanel.cardInHandHeight - 10);
			int stringWidth = g.getFontMetrics(cardNameFont).stringWidth(card.getName());
			g.drawString(card.getName(), x + GamePanel.cardInHandWidth/2 - stringWidth/2, y + GamePanel.cardInHandHeight/2);
			iterator++;
		}
		g.setFont(saveFont);
	}
}
