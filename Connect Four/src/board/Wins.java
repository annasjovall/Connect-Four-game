package board;

public class Wins implements Comparable<Wins>{
	private int winCount;

	public Wins() {
		winCount = 1;
	}

	public int increase(){
		return winCount += 1;
	}
	
	public String toString(){
		return winCount + "";
	}
	//behöver jag equals
	@Override
	public boolean equals(Object object){
		if(object instanceof Wins){
			return ((Wins)object).winCount == winCount;
		}
		return false;
	}

	@Override
	public int compareTo(Wins o) {
		int comp = o.winCount;
		return winCount > comp ? 1 : winCount < comp ? -1 : 0;
	}
}
