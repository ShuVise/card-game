package guiEngine.gameWindowStates;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import gameState.GameState;
import gameState.GameStateView;
import gameState.actions.DrawCard;
import gameState.actions.LowerHeroDrawCard;
import gameUtilities.boardPcg.Board;
import guiEngine.BodyGUI;
import guiEngine.GamePanel;
import guiEngine.guiUtilities.Button;
import guiEngine.guiUtilities.CardGUI;
import guiEngine.guiUtilities.GUIUtility;
import guiEngine.guiUtilities.HandLowerGUI;
import guiEngine.guiUtilities.Targeting;
import main.MainLoop;

public class PlayState extends WindowState
{
	private static GameState gameState = MainLoop.gameState;
	private static GameStateView gsv = new GameStateView(gameState);
	private final static int menuButton = 0;
	private final static int drawCard = 1;
	private Map <Integer,Button> buttons = new HashMap<Integer,Button>();
	private Semaphore targetingOnSem = new Semaphore(1);
	private boolean targetingOn = false;
	private Targeting targeting = null;
	public static GUIUtility onMouse = null;
	private Board board = Board.getInstance();
	private static PlayState Instance = new PlayState();
	
	public static PlayState getInstance()
	{
		return Instance;
	}
	
	private PlayState()
	{
		super();
	}
	
	public void init(WindowStateManager wsm)
	{
		this.setSize(GamePanel.getMyWidth(),GamePanel.getMyHeight());
		this.wsm = wsm;
		setLayout(null);
		this.wsm = wsm;
		Button menu = new Button("go to menu!", this, menuButton);
		buttons.put(new Integer(menuButton),menu);
		menu.setPosition((int)(GamePanel.getMyWidth()*0.9), (int)(GamePanel.getMyHeight()*0.98));
		//buttons = new ArrayList<Button>();
		//buttons.add(play);
		add(menu);
		Button getCard = new Button("draw a card!", this, drawCard);
		buttons.put(new Integer(drawCard), getCard);
		getCard.setPosition((int)(GamePanel.getMyWidth()*0.9), (int)(GamePanel.getMyHeight()*0.93));
		add(getCard);
		add(HandLowerGUI.getInstance());
		add(board);
	}
	public void startTargeting(Targeting targeting2)
	{
		try {
			targetingOnSem.acquire();
			targetingOn = true;
			targeting = targeting2;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		targetingOnSem.release();
	}
	
	public void endTargeting()
	{
		targetingOn = false;
		targeting = null;
	}
	
	public BodyGUI getTargetAt(MouseEvent e)
	{
		 return board.getBodyAt(e);
	}
	
	@Override
	public void update() 
	{
		gsv.update();
	}

	@Override
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0, (int)(GamePanel.WIDTH*GamePanel.scale), (int)(GamePanel.HEIGHT*GamePanel.scale));
		g.setColor(Color.BLACK);
		board.draw(g);
		for(Component c : getComponents())
		{
			if(c instanceof Button)
			{
				((Button) c).draw(g);
			}
		}
		gsv.draw(g);
		if(onMouse!=null)
		{
			if(onMouse instanceof CardGUI)
			((CardGUI) onMouse).drawOnMouse(g);
		}
		try {
			targetingOnSem.acquire();
			if(targetingOn)
			{
				targeting.draw(g);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			targetingOnSem.release();
		}
	}

	@Override
	public void keyPressed(int k) 
	{
		if(k == KeyEvent.VK_ENTER)
		{
			wsm.setState(WindowStateManager.menuState);
		}
	}

	@Override
	public void keyReleased(int k) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) 
	{
		Component c = getComponentAt(e.getPoint());
		if(c instanceof GUIUtility)
		{
			((GUIUtility) c).mousePressed(e);
		}
		try {
			targetingOnSem.acquire();
			if(targetingOn)
			{
				targeting.mousePressed(e);
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		targetingOnSem.release();
	}
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if(onMouse instanceof CardGUI)
		{
			((CardGUI) onMouse).mouseReleased(e);
		}
		try {
			targetingOnSem.acquire();
			if(targetingOn)
			{
				targeting.mouseReleased(e);
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		targetingOnSem.release();
		onMouse = null;
	}
	
	@Override
	public void buttonPressed(int ID) 
	{
		if(ID == menuButton)
		{
			wsm.setState(WindowStateManager.menuState);
		}
		else if(ID == drawCard )
		{
			MainLoop.addAction(new LowerHeroDrawCard());
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		try {
			targetingOnSem.acquire();
			if(targetingOn)
			{
				targeting.mouseMoved(e);
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		targetingOnSem.release();
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		if(onMouse instanceof CardGUI)
		{
			((CardGUI) onMouse).mouseDragged(e);
		}
		
	}
}
