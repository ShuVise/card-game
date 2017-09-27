package guiEngine.guiUtilities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import cards.Card;
import cards.cardsBodies.Minion;
import gameState.GameState;
import guiEngine.BodyGUI;
import guiEngine.GamePanel;
import player.Player;

import java.awt.Color;
import java.awt.Component;

public class BoardGUI extends GUIUtility
{
	
	private static BoardGUI board = new BoardGUI();
	private Semaphore minionSem = new Semaphore(1);
	private List<Minion> minions = new ArrayList<Minion>();
	private List<MinionGUI> lowerMinions = new ArrayList<MinionGUI>();
	private int cords[][];
	private int noOfRows = 4;
	private double middleYIn = GamePanel.getMyHeight()*0.46;
	private double middleXIn = GamePanel.getMyWidth()*0.99/2;
	private BoardGUI()
	{
		middleYIn = 0.46;
		double upDownWidth = 0.71;
		double upDownHeight = 0.045;
		double leftRightWidth = 0.27;
		double leftRightHeight = 0.84; //Srodek w 0.45
		cords = new int[noOfRows][6];
		int arcNo = 0;
		double newX = 0.99 - leftRightWidth;
		double newY = middleYIn-leftRightHeight/2;
		double newWidth = leftRightWidth; //0.195
		double newHeight = leftRightHeight*2;
		cords[arcNo][0] = (int)(GamePanel.getMyWidth()*newX);
		cords[arcNo][1] = (int)(GamePanel.getMyHeight()*(newY));
		cords[arcNo][2] = (int)(GamePanel.getMyWidth()*newWidth); //0.6 do 0.99 roznica 0.39, srodek = 19.5, 0.6+0.196 = 0.796
		cords[arcNo][3] = (int)(GamePanel.getMyHeight()*newHeight/2);
		cords[arcNo][4] = -90;
		cords[arcNo][5] = 180;	
		arcNo = 1;
		double width = upDownWidth; // 0.6 + 0.195 = 0.795
		double height = upDownHeight;
		newY = newY - height;
		newX = newX + newWidth/2.0 - width;
		newWidth = width;
		newHeight = height;
		cords[arcNo][0] = (int)(GamePanel.getMyWidth()*newX); //Koniec - 0.745
		cords[arcNo][1] = (int)(GamePanel.getMyHeight()*newY);
		cords[arcNo][2] = (int)(GamePanel.getMyWidth()*(newWidth));// Szrokosc - 0.55, polowa - 0.2775 
		cords[arcNo][3] = (int)(GamePanel.getMyHeight()*(newHeight*2.0));// Wysokosc - 0.1, calosc 0.27, polowa 0.135 0.17 - 0.135 = 0.135
		cords[arcNo][4] = -180;
		cords[arcNo][5] = 180;	
		arcNo = 2;
		width = leftRightWidth; // 0.795 + 0.195 = 0.99
		height = leftRightHeight;
		newY = newY + newHeight;
		newX = newX - width/2;
		newWidth = width;
		newHeight = height;
		cords[arcNo][0] = (int)(GamePanel.getMyWidth()*newX); //Koniec - 0.745
		cords[arcNo][1] = (int)(GamePanel.getMyHeight()*newY);
		cords[arcNo][2] = (int)(GamePanel.getMyWidth()*(newWidth));// Szrokosc - 0.55, polowa - 0.2775 
		cords[arcNo][3] = (int)(GamePanel.getMyHeight()*(newHeight));// Wysokosc - 0.1, calosc 0.27, polowa 0.135 0.17 - 0.135 = 0.135
		cords[arcNo][4] = 90;
		cords[arcNo][5] = 180;	
		arcNo = 3;
		width = upDownWidth;
		height = upDownHeight;
		newY = newY + newHeight - height;
		newX = newX + newWidth/2;
		newWidth = width;
		newHeight = height;
		cords[arcNo][0] = (int)(GamePanel.getMyWidth()*newX); //Koniec - 0.745
		cords[arcNo][1] = (int)(GamePanel.getMyHeight()*newY);
		cords[arcNo][2] = (int)(GamePanel.getMyWidth()*(newWidth));// Szrokosc - 0.55, polowa - 0.2775 
		cords[arcNo][3] = (int)(GamePanel.getMyHeight()*(newHeight*2));// Wysokosc - 0.1, calosc 0.27, polowa 0.135 0.17 - 0.135 = 0.135
		cords[arcNo][4] = 0;
		cords[arcNo][5] = 180;	
		setBounds(0,0,GamePanel.getMyWidth(),GamePanel.getMyHeight());
	}
	
	public static BoardGUI getInstance()
	{
		return board;
	}
	
	private void adjustBoard()
	{
		int noMinions = lowerMinions.size();
		int mostLeft = (int) (middleXIn - (noMinions/2.0*GamePanel.minionOnBoardWidth) - ((noMinions-1)/2.0*GamePanel.minionOnBoardGapWidth));
		int mostTop = (int) (GamePanel.getMyHeight()*0.3 + GamePanel.minionOnBoardHeight);
		int iterator = 0;
		for(MinionGUI minionGUI : lowerMinions)
		{
			minionGUI.setXY(mostLeft+(iterator++)*GamePanel.minionOnBoardWidth + (iterator)*GamePanel.minionOnBoardGapWidth, mostTop);
		}
	}
	
	public void addMinionToBoardLowerHero(Card card, Minion minion)
	{
		try {
			minionSem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		minions.add(minion);
		MinionGUI newMinion = new MinionGUI(minion);
		card.setGUICenter(newMinion);
		minion.setGUI(newMinion);
		lowerMinions.add(newMinion);
		adjustBoard();
		add(newMinion);
		minionSem.release();
	}
	
	public void removeBodyFromField(BodyGUI gui)
	{
		try {
			minionSem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lowerMinions.remove(gui);
		adjustBoard();
		minionSem.release();
	}
	
	public BodyGUI getBodyAt(MouseEvent e)
	{
		Component c = getComponentAt(e.getPoint());
		BodyGUI body = null;
		if(c instanceof BodyGUI)
		{
			body = (BodyGUI) c;
		}
		return body;
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void draw(Graphics2D g)
	{
		Color darkSalmon = new Color(233,96,122);
		for(int i=0;i<noOfRows;i++)
		{
			g.drawArc(cords[i][0], cords[i][1], cords[i][2], cords[i][3], cords[i][4],cords[i][5]);
		}
		try {
			minionSem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(MinionGUI minion : lowerMinions)
		{
			minion.draw(g);
		}
		minionSem.release();
	}
}
