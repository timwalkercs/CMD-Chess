//Timothy Walker tpw32

package pieces;

/**
 * Rook class, extends Piece
 * @author Timothy Walker
 *
 */
public class Rook extends Piece {
	
	/**
	 * Rook constructor with character parameter to indicate color
	 * @param c color character
	 */
	public Rook(char c) {
		super(c);

	}
	
	/**
	 * Returns char 'R' to indicate this Piece is a Rook
	 * @return char 'R'
	 */
	public char getType() {
    	return 'R';
    }
	
	/**
	 * Fills Rook's move list with all potential coordinates
	 * @param board game board
	 * @param position coordinates of the Rook you want to move
	 */
	public void getMoves(Piece[][] board, String position) {
    	moves.clear();
    	
    	//Indexes of the piece you want to move
    	int pieceI = numToIndex(position.charAt(1));
    	int pieceJ = letterToIndex(position.charAt(0));
    	
    	//Indexes used to search along the board
    	int i = pieceI;
    	int j = pieceJ;
    	
    	//Up and Down
    	for(i = pieceI - 1; i >= 0; i--){
    		//White Rooks
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}
    			
        	}else { //Black Rooks
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    	}
    	for(i = pieceI + 1; i <= 7; i++){
    		//White Rooks
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece

        	}else { //Black Rooks
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    	} i = pieceI; //reset i to index of piece you're trying to move
    	
    	
    	//Left and Right
    	for(j = pieceJ - 1; j >= 0; j--){
    		//White Rooks
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}
    			
        	}else { //Black Rooks
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    	}
    	for(j = pieceJ + 1; j <= 7; j++){
    		//White Rooks
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece

        	}else { //Black Rooks
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    	} j = pieceJ; //reset not needed, just doing so for consistency
    }
}
