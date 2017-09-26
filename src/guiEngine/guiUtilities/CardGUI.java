package guiEngine.guiUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.concurrent.Semaphore;

import javax.swing.JPanel;

import cards.Card;
import gameState.actions.PlayCardFromHand;
import guiEngine.GamePanel;
import guiEngine.gameWindowStates.PlayState;
import main.MainLoop;

public class CardGUI extends GUIUtility
{
	private Card card = null;
	private static Font cardNameFont = new Font("Ariel",Font.PLAIN,(int) (11*GamePanel.scale/1.5));
	private int x,y, stringY, stringX;
	private String name = null;
	private int dx,dy, lastX, lastY;
	private int stringWidth, stringHeight;
	private Semaphore boolLock = new Semaphore(1);
	private boolean onMouse = false;
	public CardGUI(Card card)
	{
		super();
		this.card = card;
		name = card.getName();
		x = 0;
		y = 0;
		stringY = 0;
		stringX = 0;
	}
	
	public void setXY(int x, int y)
	{
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);    
		stringWidth = (int)(cardNameFont.getStringBounds(name, frc).getWidth());   
		stringHeight = (int)(cardNameFont.getStringBounds(name, frc).getHeight());
		this.x = x;
		this.y = y;
		stringY = (int) (y + GamePanel.cardInHandHeight/2.0  + stringHeight/4.0);
		stringX = (int) (x + GamePanel.cardInHandWidth/2.0 - stringWidth/2.0);
	}
	
	public void setMyBounds(int x, int y)
	{
		setBounds(x,y,GamePanel.cardInHandWidth, GamePanel.cardInHandHeight);
	}
	
	public void draw(Graphics2D g)
	{
		boolean isOnMouse = false;
		try {
			boolLock.acquire();
			isOnMouse = onMouse;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolLock.release();
		if(!isOnMouse)
		{
			g.setFont(cardNameFont);
			g.drawRect(x,y,GamePanel.cardInHandWidth,GamePanel.cardInHandHeight);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(x+1,y+1,GamePanel.cardInHandWidth-1,GamePanel.cardInHandHeight-1);
			g.setColor(Color.BLACK);
			g.drawString(name, stringX, stringY);
		}
	}
	
	public void drawOnMouse(Graphics2D g)
	{
		int thisx = x+dx;
		int thisy = y+dy;
		g.setFont(cardNameFont);
		g.drawRect(thisx,thisy,GamePanel.cardInHandWidth,GamePanel.cardInHandHeight);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(thisx+1,thisy+1,GamePanel.cardInHandWidth-1,GamePanel.cardInHandHeight-1);
		g.setColor(Color.BLACK);
		g.drawString(name, stringX+dx, stringY+dy);
	}
	
	public void mousePressed(MouseEvent e)
	{
		System.out.println("Selected card: " + name);
		try
		{
			boolLock.acquire();
			onMouse = true;
			PlayState.onMouse = this;
		} catch (InterruptedException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		boolLock.release();
		lastX = e.getX();
		lastY = e.getY();
	}
	
	public void mouseDragged(MouseEvent e)
	{
		int dx = e.getX() - lastX;
		int dy = e.getY() - lastY;
		this.dx += dx;
		this.dy += dy;
		lastX = e.getX();
		lastY = e.getY();
	}
	
	public void mouseReleased(MouseEvent e)
	{
		try {
			boolLock.acquire();
			onMouse = false;
			if(dy<-GamePanel.cardInHandHeight*1.7)
			{
				System.out.println("Hi");
				MainLoop.addAction(new PlayCardFromHand(card));
			}
			dx = 0;
			dy = 0;
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolLock.release();
	}
	
	public String toString()
	{
		String output = new String();
		output+=name;
		return output;
	}
	
	public Card getCard()
	{
		return card;
	}
}
