package cards.cardsBodies;

public class Vasal implements CardBodyInterface
{
	private int hp;
	private String name;
	private int myId;
	public Vasal(String name, int hp)
	{
		this.name = name;
		this.hp = hp;
		this.myId = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getMyId()
	{
		return myId;
	}
	
	public void setMyId(int id)
	{
		myId = id;
	}
	
	public void select() 
	{
		
	}

	public String toString()
	{
		String output = new String();
		output = name + " " + hp;
		return output;
	}
}
