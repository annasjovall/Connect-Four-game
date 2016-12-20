package player;

public class Player {
	private int ID;
	private String name;
	
	public Player(String name, int id){
		ID = id;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getID(){
		return ID;
	}
}
