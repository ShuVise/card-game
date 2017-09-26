package guiEngine.guiUtilities;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public abstract class GUIUtility extends JPanel
{

	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseDragged(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
}
