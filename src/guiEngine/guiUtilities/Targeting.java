package guiEngine.guiUtilities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.Semaphore;

import javax.swing.SwingUtilities;

import gameState.GameState;
import guiEngine.gameWindowStates.PlayState;

public class Targeting extends GUIUtility implements MouseMotionListener
{

	private Point start, dest;
	private Semaphore coordSemaphore = new Semaphore(0);
	private Semaphore endSemaphore = new Semaphore(0);
	private guiEngine.BodyGUI target = null;
	
	public Targeting(Point center) 
	{
		start = dest = center;
		PlayState.getInstance().startTargeting(this);
		coordSemaphore.release();
	}

	public void draw(Graphics2D g)
	{
		try {
			coordSemaphore.acquire();
			g.drawLine((int)start.getX(), (int)start.getY(), (int)dest.getX(), (int)dest.getY());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		coordSemaphore.release();
	}
	
	public void mousePressed(MouseEvent e) 
	{
		if(SwingUtilities.isLeftMouseButton(e))
		{
			System.out.println("Hi");
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if(SwingUtilities.isLeftMouseButton(e))
		{
			PlayState.getInstance().endTargeting();
			target = PlayState.getInstance().getTargetAt(e);
			endSemaphore.release();
		}
		
		if(SwingUtilities.isRightMouseButton(e))
		{
			PlayState.getInstance().endTargeting();
			endSemaphore.release();
		}
	}

	public guiEngine.BodyGUI getTarget()
	{
		try {
			endSemaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return target;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		try {
			coordSemaphore.acquire();
			dest = e.getPoint();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally
		{
			coordSemaphore.release();
		}
		
	}

}
