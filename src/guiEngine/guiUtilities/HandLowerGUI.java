package guiEngine.guiUtilities;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import cards.Card;
import guiEngine.GamePanel;

public class HandLowerGUI extends GUIUtility
{
	private List <CardGUI> hand = null;
	private static HandLowerGUI thisInstance = new HandLowerGUI();
	private HandLowerGUI()
	{
		super();
		hand = new ArrayList<CardGUI>();
		setBounds(0,0,1,1);
	}
	
	public static HandLowerGUI getInstance()
	{
		return thisInstance;
	}
	
	private void setCardBounds()
	{
		int noCards = hand.size();
		int y = GamePanel.getMyHeight() - GamePanel.cardInHandHeight - GamePanel.cardInHandGapHeight;
		int leftSide = (int) (-(noCards/2.0)*GamePanel.cardInHandWidth - ((noCards-1)/2.0)*GamePanel.cardInHandGapWidth) + GamePanel.getMyWidth()/2;
		int handWidth = GamePanel.cardInHandWidth*noCards + GamePanel.cardInHandGapWidth*(noCards-1);
		setBounds(leftSide, y, handWidth, GamePanel.cardInHandHeight);
		int iterator = 0;
		int spaceBetween = GamePanel.cardInHandWidth + GamePanel.cardInHandGapWidth;
		for(CardGUI cardX : hand)
		{
			cardX.setXY(leftSide + spaceBetween*iterator, y);
			cardX.setMyBounds(0+spaceBetween*iterator++, 0);
		}
	}
	
	public void addCardToHand(Card card)
	{
		CardGUI newCard = new CardGUI(card);
		hand.add(newCard);
		setCardBounds();
		add(newCard);
	}
	
	public void removeCardFromHand(Card card)
	{
		CardGUI cardGUI = null;
		for(CardGUI cardInHand : hand)
		{
			if(cardInHand.getCard()==card)
			{
				cardGUI = cardInHand;
				break;
			}
		}
		if(cardGUI!=null)
		{
			remove(cardGUI);
			hand.remove(cardGUI);
			setCardBounds();
		}
	}
	
	public void draw(Graphics2D g)
	{
		for(CardGUI card : hand)
		{
			card.draw(g);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		Point point = e.getPoint();
		point.translate(-getX(), -getY());
		Component c = getComponentAt(point);;
		if(c instanceof CardGUI)
		{
			CardGUI card = null;
			card = (CardGUI) c;
			card.mousePressed(e);
		}
	}
}
