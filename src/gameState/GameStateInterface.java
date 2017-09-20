package gameState;

import player.Player;

public interface GameStateInterface 
{
	public void reset();
	public void addLowerHero(Player hero);
	public void addUpperHero(Player hero);
}
