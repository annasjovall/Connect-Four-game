package player;

public class EndGame{
	private Board board;
	private boolean won = false;
	
	public EndGame(Board board){
		this.board = board;
	}
	
	private boolean checkRows(int row, int col){
		int playerID = board.get(row, col); 
		int count = 0;
		for(int cols = col - 3; cols <= col + 3; cols++){
			if(count == 4) return true;
			if(board.isWithinBounds(row, cols) && board.get(row, cols) == playerID) count++;
			else count = 0;
		}
		return false;
	}
	
	private boolean checkColumns(int row, int col){
		int playerID = board.get(row, col);
		int count = 0;
		for(int rows = row - 3; rows <= row + 3; rows++){
			if(count == 4) return true;
			if(board.isWithinBounds(rows, col) && board.get(rows, col) == playerID) count++;
			else count = 0;
		}
		return count == 4;
	}
	
	private boolean checkDiagonals(int row, int col){
		int playerID = board.get(row, col);
		int countleft = 0;
		int countright = 0;
		for(int i = -3; i <= 3; i++){
			if(countleft == 4 || countright == 4) return true;
			if(board.isWithinBounds(row + i, col + i) && board.get(row + i, col + i) == playerID) countleft++;
			if(board.isWithinBounds(row - i, col - i) && board.get(row - i, col - i) == playerID) countright++;
			else countleft = 0; countright = 0;
		}
		return countleft == 4 || countright == 4;
	}
	
	public boolean checkIfWon(int row, int col){
		if(checkColumns(row, col) || checkRows(row, col) || checkDiagonals(row, col)){
			won = true;
		}
		return won;
	}
	
	private boolean checkIfTie(){
		for(int row = 0; row < board.getRowSize(); row++){
			for(int col = 0; col < board.getColSize(); col++){
				if(board.get(row, col) == 0) return false;
			}
		}
		return true;
	}
	
	public boolean endGame(){
		return won || checkIfTie();
	}
	
}
