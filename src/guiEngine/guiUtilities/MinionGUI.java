package guiEngine.guiUtilities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import cards.cardsBodies.CardBodyInterface;
import cards.cardsBodies.Minion;
import gameState.actions.InflictDamage;
import guiEngine.BodyGUI;
import guiEngine.GamePanel;
import main.MainLoop;

public class MinionGUI extends BodyGUI
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
	
	public CardBodyInterface getBody()
	{
		return minion;
	}
	
	public String getName()
	{
		return minion.getName();
	}
	
	public Point getCenter()
	{
		return new Point((int)(x+width*0.5),(int)(y+height*0.5));
	}
	
	public void draw(Graphics2D g)
	{
		Stroke saveStroke = g.getStroke();
        g.setStroke ( new BasicStroke ( 3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER ) );
		g.setColor(Color.LIGHT_GRAY);
		g.fillArc(x, y, width, height, 0, 360);
		g.setColor(Color.black);
		g.drawArc(x, y, width, height, 0, 360);
		g.setFont(minionNameFont);
		g.drawString(minion.getName(), stringX, stringY);
		int hp = minion.getHP();
		int attack = minion.getAttack();
		g.drawString(new String("Hp: " + Integer.toString(hp)), (int) (x+width*0.3), (int)(y+height*0.9));
		g.setStroke(saveStroke);
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
