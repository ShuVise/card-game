package guiEngine.guiUtilities;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import cards.cardsBodies.Minion;
import guiEngine.GamePanel;

public class MinionGUI extends GUIUtility
{

	private Minion minion = null;
	private int x,y,width,height;
	private int stringX, stringY;
	private Font minionNameFont = new Font("Ariel",Font.ITALIC,(int) (11*GamePanel.scale/1.5));
	public MinionGUI(Minion minion)
	{
		this.minion = minion;
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}
	
	public void setXY(int x, int y)
	{
		width = GamePanel.minionOnBoardWidth;
		height = GamePanel.minionOnBoardHeight;
		this.x = x;
		this.y = y;
		setBounds(x,y,width,height);		
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);    
		stringX = (int) (x+width/2.0 - (minionNameFont.getStringBounds(minion.getName(), frc).getWidth()/2.0)); 
		stringY = (int) (y+height/2.0 + (minionNameFont.getStringBounds(minion.getName(), frc).getHeight())/4.0); 
	}
	
	public void draw(Graphics2D g)
	{
		g.drawArc(x, y, width, height, 0, 360);
		g.setFont(minionNameFont);
		g.drawString(minion.getName(), stringX, stringY);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
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
	
	
	
}
