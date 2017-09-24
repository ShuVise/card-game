package guiEngine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import guiEngine.gameWindowStates.WindowStateManager;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener 
{
	public static final int HEIGHT = 300;
	public static final int WIDTH = 300;
	public static final int scale = 2;
	public static final int cardInHandWidth = 45;
	public static final int cardInHandHeight = 65;
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private WindowStateManager wsm = null;
	
	GamePanel()
	{
		super();
		init();
		setPreferredSize(new Dimension(WIDTH*scale,HEIGHT*scale));
		setFocusable(true);
		requestFocus();
	}

	
	public static int getMyWidth()
	{
		return WIDTH*scale;
	}
	
	public static int getMyHeight()
	{
		return HEIGHT*scale;
	}
	
	private void init()
	{
		image = new BufferedImage(WIDTH*scale,HEIGHT*scale,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D)image.getGraphics();
		running = true;
		wsm = new WindowStateManager();
	}
	
	public void addNotify()
	{
		super.addNotify();
		if(thread == null)
		{
			thread = new Thread(this);
			addKeyListener(this);
			addMouseListener(this);
			thread.start();
		}
	}
	public void keyPressed(KeyEvent e) 
	{
		wsm.keyPressed(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) 
	{
		wsm.keyReleased(e.getKeyCode());
	}

	public void keyTyped(KeyEvent arg0) 
	{
		
	}

	@Override
	public void run() 
	{
		init();
		long start, elapsed, wait;
		while(running)
		{
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed/1000000;
			try
			{
				if(wait>0)
				{
					Thread.sleep(wait);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void update()
	{
		wsm.update();
	}
	
	private void draw()
	{
		wsm.draw(g);
	}
	
	private void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image,0,0,null);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(SwingUtilities.isLeftMouseButton(e))
		{
			wsm.mousePressed(e);
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) 
	{
		wsm.mouseReleased(e);
	}
}
