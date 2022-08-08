//Timothy Walker tpw32

package pieces;

/**
 * King class, extends Piece
 * @author Timothy Walker
 *
 */
public class King extends Piece {

	/**
	 * King constructor with character parameter to indicate color
	 * @param c color character
	 */
	public King(char c) {
		super(c);

	}
	
	/**
	 * Returns char 'K' to indicate this Piece is a King
	 * @return char 'K'
	 */
	public char getType() {
    	return 'K';
    }
	
	/**
	 * Fills King's move list with all potential coordinates
	 * @param board game board
	 * @param position coordinates of the King you want to move
	 */
	public void getMoves(Piece[][] board, String position) {
    	moves.clear();
    	int i = numToIndex(position.charAt(1));
    	int j = letterToIndex(position.charAt(0));
    	//White King
    	if(board[i][j].getColor()=='w') {
    		//Up 1
    		if(i-1 >= 0) {if(board[i-1][j]==null || board[i-1][j].getColor()=='b') {moves.add(indexToLetter(j)+indexToNum(i-1));}}
    		//Down 1
    		if(i+1 <= 7) {if(board[i+1][j]==null || board[i+1][j].getColor()=='b') {moves.add(indexToLetter(j)+indexToNum(i+1));}}
    		//Right 1
    		if(j+1 <= 7) {if(board[i][j+1]==null || board[i][j+1].getColor()=='b') {moves.add(indexToLetter(j+1)+indexToNum(i));}}
    		//Left 1
    		if(j-1 >= 0) {if(board[i][j-1]==null || board[i][j-1].getColor()=='b') {moves.add(indexToLetter(j-1)+indexToNum(i));}}
    		//Diagonal UR
    		if(i-1 >= 0 && j+1 <=7) {if(board[i-1][j+1]==null || board[i-1][j+1].getColor()=='b') {moves.add(indexToLetter(j+1)+indexToNum(i-1));}}
    		//Diagonal UL
    		if(i-1 >=0 && j-1 >=0) {if(board[i-1][j-1]==null || board[i-1][j-1].getColor()=='b') {moves.add(indexToLetter(j-1)+indexToNum(i-1));}}
    		//Diagonal DR
    		if(i+1 <= 7 && j+1 <=7) {if(board[i+1][j+1]==null || board[i+1][j+1].getColor()=='b') {moves.add(indexToLetter(j+1)+indexToNum(i+1));}}
    		//Diagonal DL
    		if(i+1 <= 7 && j-1 >=0) {if(board[i+1][j-1]==null || board[i+1][j-1].getColor()=='b') {moves.add(indexToLetter(j-1)+indexToNum(i+1));}}
    	}else {//Black King
    		//Up 1
    		if(i-1 >= 0) {if(board[i-1][j]==null || board[i-1][j].getColor()=='w') {moves.add(indexToLetter(j)+indexToNum(i-1));}}
    		//Down 1
    		if(i+1 <= 7) {if(board[i+1][j]==null || board[i+1][j].getColor()=='w') {moves.add(indexToLetter(j)+indexToNum(i+1));}}
    		//Right 1
    		if(j+1 <= 7) {if(board[i][j+1]==null || board[i][j+1].getColor()=='w') {moves.add(indexToLetter(j+1)+indexToNum(i));}}
    		//Left 1
    		if(j-1 >= 0) {if(board[i][j-1]==null || board[i][j-1].getColor()=='w') {moves.add(indexToLetter(j-1)+indexToNum(i));}}
    		//Diagonal UR
    		if(i-1 >= 0 && j+1 <=7) {if(board[i-1][j+1]==null || board[i-1][j+1].getColor()=='w') {moves.add(indexToLetter(j+1)+indexToNum(i-1));}}
    		//Diagonal UL
    		if(i-1 >=0 && j-1 >=0) {if(board[i-1][j-1]==null || board[i-1][j-1].getColor()=='w') {moves.add(indexToLetter(j-1)+indexToNum(i-1));}}
    		//Diagonal DR
    		if(i-1 <= 7 && j+1 <=7) {if(board[i+1][j+1]==null || board[i+1][j+1].getColor()=='w') {moves.add(indexToLetter(j+1)+indexToNum(i+1));}}
    		//Diagonal DL
    		if(i+1 <= 7 && j-1 >=0) {if(board[i+1][j-1]==null || board[i+1][j-1].getColor()=='w') {moves.add(indexToLetter(j-1)+indexToNum(i+1));}}
    	}
    }

}
