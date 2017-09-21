package guiEngine.gameWindowStates;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import gameState.GameState;

public class WindowStateManager 
{
	private List<WindowState> gameStates = null;
	private int currentState;
	
	public static final int menuState = 0;
	public static final int gameState = 1;
	
	public WindowStateManager()
	{
		gameStates = new ArrayList<WindowState>();
		currentState = menuState;
		gameStates.add(new MenuState(this));
		gameStates.add(new PlayState(this));
		
	}
	
	public void setState(int state)
	{
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public void update()
	{
		gameStates.get(currentState).update();
	}
	
	public void draw(Graphics2D g)
	{
		gameStates.get(currentState).draw(g);
	}
	
	public void keyPressed(int k)
	{
		gameStates.get(currentState).keyPressed(k);
	}
	
	public void keyReleased(int k)
	{
		gameStates.get(currentState).keyReleased(k);
	}
	
	public void mousePressed(MouseEvent e)
	{
		gameStates.get(currentState).mousePressed(e);
	}
	
	public void mouseReleased(MouseEvent e) 
	{
		gameStates.get(currentState).mouseReleased(e);
	}
}
