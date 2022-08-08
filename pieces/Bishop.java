//Timothy Walker tpw32

package pieces;

/**
 * Bishop class, extends Piece
 * @author Timothy Walker
 *
 */
public class Bishop extends Piece {

	/**
	 * Bishop constructor with character parameter to indicate color
	 * @param c color character
	 */
	public Bishop(char c) {
		super(c);

	}

	/**
	 * Returns char 'B' to indicate this Piece is a Bishop
	 * @return char 'B'
	 */
	public char getType() {
    	return 'B';
    }
	
	/**
	 * Fills Bishop's move list with all potential coordinates
	 * @param board game board
	 * @param position coordinates of the Bishop on the board
	 */
	public void getMoves(Piece[][] board, String position) {
    	moves.clear();
    	
    	//Indexes of the piece you want to move
    	int pieceI = numToIndex(position.charAt(1));
    	int pieceJ = letterToIndex(position.charAt(0));
    	
    	//Indexes used to search along the board
    	int i = pieceI;
    	int j = pieceJ;
    	
    	//Up and Right
    	i = i-1;
    	j = j+1;
    	while(i>=0 && j<=7) {
    		//White Bishops
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
    			
        	}else { //Black Bishops
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    		i--; j++;
    	}i = pieceI; j = pieceJ; //reset i and j
    	
    	//Up and Left
    	i = i-1;
    	j = j-1;
    	while(i>=0 && j>=0) {
    		//White Bishops
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
    			
        	}else { //Black Bishops
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    		i--; j--;
    	}i = pieceI; j = pieceJ; //reset i and j
    	
    	//Down and Left
    	i = i+1;
    	j = j-1;
    	while(i<=7 && j>=0) {
    		//White Bishops
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
    			
        	}else { //Black Bishops
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    		i++; j--;
    	}i = pieceI; j = pieceJ; //reset i and j
    	
    	//Down and Right
    	i = i+1;
    	j = j+1;
    	while(i<=7 && j<=7) {
    		//White Bishops
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
    			
        	}else { //Black Bishops
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    		i++; j++;
    	}i = pieceI; j = pieceJ; //reset i and j
    }
}
