package guiEngine.gameWindowStates;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import guiEngine.GamePanel;
import guiEngine.guiUtilities.Button;
import guiEngine.guiUtilities.GUIUtility;

public class MenuState extends WindowState
{
	public static final int playButton = 0;
	public MenuState(WindowStateManager wsm)
	{
		super();
		this.setSize(GamePanel.getMyWidth(),GamePanel.getMyHeight());
		setLayout(null);
		this.wsm = wsm;
		Button play = new Button("Play!", this, playButton);
		play.setPosition((int)(GamePanel.getMyWidth()/2), (int)(GamePanel.getMyHeight()/2));
		buttons = new ArrayList<Button>();
		buttons.add(play);
		add(play);
	}
	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0, (int)(GamePanel.WIDTH*GamePanel.scale), (int)(GamePanel.HEIGHT*GamePanel.scale));
		g.setColor(Color.BLACK);
		for(Component c : getComponents())
		{
			if(c instanceof Button)
			{
				((Button) c).draw(g);
			}
		}
	}
	
	@Override
	public void keyPressed(int k) 
	{
		if(k == KeyEvent.VK_ENTER)
		{
			wsm.setState(WindowStateManager.gameState);
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
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void buttonPressed(int ID) 
	{
		if(ID == playButton)
		{
			wsm.setState(WindowStateManager.gameState);
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
