package player;

public class EndGame{
	private Board board;
	
	public EndGame(Board board){
		this.board = board;
	}
	
	private boolean checkRows(int row, int col){
		Player player = board.get(row, col).get(); //kan ge exception
		int count = 0;
		for(int cols = col - 3; cols <= col + 3; cols++){
			if(count == 4) return true;
			if(board.get(row, cols).isPresent() 
					&& board.get(row, cols).get().equals(player)) count++;
			else count = 0;
		}
		return count == 4;
	}
	
	private boolean checkColumns(int row, int col){
		Player player = board.get(row, col).get();//kan ge exception
		int count = 0;
		for(int rows = row - 3; rows <= row + 3; rows++){
			if(count == 4) return true;
			if(board.get(rows, col).isPresent() 
					&& board.get(rows, col).get().equals(player)) count++;
			else count = 0;
		}
		return count == 4;
	}
	
	private boolean checkDiagonals(int row, int col){
		Player player = board.get(row, col).get();//kan ge exception
		int countleft = 0;
		int countright = 0;
		for(int i = -3; i <= 3; i++){
			if(countleft == 4 || countright == 4) return true;
			if(board.get(row + i, col + i).isPresent() && board.get(row + i, col + i).get().equals(player)) countleft++;
			if(board.get(row - i, col - i).isPresent() && board.get(row - i, col - i).get().equals(player)) countright++;
			else{
				countleft = 0; 
				countright = 0;
			}
		}
		return countleft == 4 || countright == 4;
	}
	
	public boolean win(int row, int col){
		return checkColumns(row, col) || checkRows(row, col) || checkDiagonals(row, col);
	}
	
	public boolean filledBoard(){
		for(int row = 0; row < board.getRowSize(); row++){
			for(int col = 0; col < board.getColSize(); col++){
				if(!board.get(row, col).isPresent()) return false;
			}
		}
		return true;
	}
}
