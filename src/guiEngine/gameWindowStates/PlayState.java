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

import gameState.GameState;
import gameState.GameStateView;
import gameState.actions.DrawCard;
import guiEngine.GamePanel;
import guiEngine.guiUtilities.Button;
import main.MainLoop;

public class PlayState extends WindowState
{
	private static GameState gameState = MainLoop.gameState;
	private static GameStateView gsv = new GameStateView(gameState);
	private final static int menuButton = 0;
	private final static int drawCard = 1;
	private Map <Integer,Button> buttons = new HashMap<Integer,Button>();
	public PlayState(WindowStateManager wsm)
	{
		super();
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
		getCard.setPosition((int)(GamePanel.getMyWidth()*0.9), (int)(GamePanel.getMyHeight()*0.9));
		add(getCard);
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
		g.fillRect(0,0, GamePanel.WIDTH*GamePanel.scale, GamePanel.HEIGHT*GamePanel.scale);
		g.setColor(Color.BLACK);
		for(Component c : getComponents())
		{
			if(c instanceof Button)
			{
				((Button) c).draw(g);
			}
		}
		gsv.draw(g);
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
		if(c instanceof Button)
		{
			((Button) c).pressed();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
			MainLoop.addAction(new DrawCard(gameState.getLowerHero()));
		}
	}
}
