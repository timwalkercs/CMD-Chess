//Timothy Walker tpw32

package pieces;

/**
 * Knight class, extends Piece
 * @author Timothy Walker
 *
 */
public class Knight extends Piece {
	
	/**
	 * Knight constructor with character parameter to indicate color
	 * @param c color character
	 */
	public Knight(char c) {
		super(c);

	}

	/**
	 * Returns char 'N' to indicate this Piece is a Knight
	 * @return char 'N'
	 */
	public char getType() {
    	return 'N';
    }
	
	/**
	 * Fills Knight's move list with all potential coordinates
	 * @param board game board
	 * @param position coordinates of the Knight you want to move
	 */
	public void getMoves(Piece[][] board, String position) {
    	this.moves.clear();
    	int i = numToIndex(position.charAt(1));
    	int j = letterToIndex(position.charAt(0));
    	//White Knight
    	if(board[i][j].getColor()=='w') {
    		//Up 2 right 1?
    		if(i-2 >= 0 && j+1 <=7) {if(board[i-2][j+1]==null || board[i-2][j+1].getColor()=='b') {moves.add(indexToLetter(j+1)+indexToNum(i-2));}}
    		//Up 2 left 1?
    		if(i-2 >= 0 && j-1 >=0) {if(board[i-2][j-1]==null || board[i-2][j-1].getColor()=='b') {moves.add(indexToLetter(j-1)+indexToNum(i-2));}}
    		//Back 2 right 1?
    		if(i+2 <= 7 && j+1 <=7) {if(board[i+2][j+1]==null || board[i+2][j+1].getColor()=='b') {moves.add(indexToLetter(j+1)+indexToNum(i+2));}}
    		//Back 2 left 1?
    		if(i+2 <= 7 && j-1 >=0) {if(board[i+2][j-1]==null || board[i+2][j-1].getColor()=='b') {moves.add(indexToLetter(j-1)+indexToNum(i+2));}}
    		//Up 1 right 2?
    		if(i+1 <= 7 && j+2 <=7) {if(board[i+1][j+2]==null || board[i+1][j+2].getColor()=='b') {moves.add(indexToLetter(j+2)+indexToNum(i+1));}}
    		//Up 1 left 2?
    		if(i+1 <= 7 && j-2 >=0) {if(board[i+1][j-2]==null || board[i+1][j-2].getColor()=='b') {moves.add(indexToLetter(j-2)+indexToNum(i+1));}}
    		//Back 1 right 2?
    		if(i-1 >= 0 && j+2 <=7) {if(board[i-1][j+2]==null || board[i-1][j+2].getColor()=='b') {moves.add(indexToLetter(j+2)+indexToNum(i-1));}}
    		//Back 1 left 2?
    		if(i-1 >= 0 && j-2 >=0) {if(board[i-1][j-2]==null || board[i-1][j-2].getColor()=='b') {moves.add(indexToLetter(j-2)+indexToNum(i-1));}}
    	}else {//Black Knight
    		if(i-2 >= 0 && j+1 <=7) {if(board[i-2][j+1]==null || board[i-2][j+1].getColor()=='w') {moves.add(indexToLetter(j+1)+indexToNum(i-2));}}
    		if(i-2 >= 0 && j-1 >=0) {if(board[i-2][j-1]==null || board[i-2][j-1].getColor()=='w') {moves.add(indexToLetter(j-1)+indexToNum(i-2));}}
    		if(i+2 <= 7 && j+1 <=7) {if(board[i+2][j+1]==null || board[i+2][j+1].getColor()=='w') {moves.add(indexToLetter(j+1)+indexToNum(i+2));}}
    		if(i+2 <= 7 && j-1 >=0) {if(board[i+2][j-1]==null || board[i+2][j-1].getColor()=='w') {moves.add(indexToLetter(j-1)+indexToNum(i+2));}}
    		if(i+1 <= 7 && j+2 <=7) {if(board[i+1][j+2]==null || board[i+1][j+2].getColor()=='w') {moves.add(indexToLetter(j+2)+indexToNum(i+1));}}
    		if(i+1 <= 7 && j-2 >=0) {if(board[i+1][j-2]==null || board[i+1][j-2].getColor()=='w') {moves.add(indexToLetter(j-2)+indexToNum(i+1));}}
    		if(i-1 >= 0 && j+2 <=7) {if(board[i-1][j+2]==null || board[i-1][j+2].getColor()=='w') {moves.add(indexToLetter(j+2)+indexToNum(i-1));}}
    		if(i-1 >= 0 && j-2 >=0) {if(board[i-1][j-2]==null || board[i-1][j-2].getColor()=='w') {moves.add(indexToLetter(j-2)+indexToNum(i-1));}}
    	}
    }
}
