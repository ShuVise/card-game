package guiEngine.guiUtilities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
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
			Stroke saveStroke = g.getStroke();
	        g.setStroke ( new BasicStroke ( 6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER ) );
			g.drawLine((int)start.getX(), (int)start.getY(), (int)dest.getX(), (int)dest.getY());
			float angle = (float) Math.toDegrees(Math.atan2(dest.x - start.x,dest.y - start.y));
			int endx = (int) (dest.x +20*Math.sin((135+angle)*Math.PI/180));
			int endy = (int) (dest.y +20*Math.cos((135+angle)*Math.PI/180));
			g.drawLine(dest.x, dest.y, endx, endy);
			endx = (int) (dest.x +20*Math.sin((angle-135)*Math.PI/180));
			endy = (int) (dest.y +20*Math.cos((angle-135)*Math.PI/180));
			g.drawLine(dest.x, dest.y, endx, endy);
			g.setStroke(saveStroke);
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
