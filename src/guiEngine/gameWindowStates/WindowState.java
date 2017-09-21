package guiEngine.gameWindowStates;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import guiEngine.guiUtilities.Button;

public abstract class WindowState extends JPanel
{
	protected List<Button> buttons = null;
	protected WindowStateManager wsm = null;
	
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	public abstract void init();
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	public abstract void buttonPressed(int ID);
}
