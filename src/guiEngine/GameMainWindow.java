package guiEngine;

import javax.swing.JFrame;

public class GameMainWindow 
{
	JFrame window = null;
	public GameMainWindow()
	{
		window = new JFrame("Card Game");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}
