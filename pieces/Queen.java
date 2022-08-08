//Timothy Walker tpw32

package pieces;

/**
 * Queen class, extends Piece
 * @author Timothy Walker
 *
 */
public class Queen extends Piece {

	/**
	 * Queen constructor with character parameter to indicate color
	 * @param c color character
	 */
	public Queen(char c) {
		super(c);

	}
	
	/**
	 * Returns char 'Q' to indicate this Piece is a Queen
	 * @return char 'Q'
	 */
	public char getType() {
    	return 'Q';
    }

	/**
	 * Fills Queen's move list with all potential coordinates
	 * @param board game board
	 * @param position coordinates of the Queen you want to move
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
    		//White Queen
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}
    			
        	}else { //Black Queen
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    	}
    	for(i = pieceI + 1; i <= 7; i++){
    		//White Queen
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece

        	}else { //Black Queen
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
    		//White Queen
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}
    			
        	}else { //Black Queen
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    	}
    	for(j = pieceJ + 1; j <= 7; j++){
    		//White Queen
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece

        	}else { //Black Queen
        		if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='w') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
        	}
    	} 
    	
    	//reset indexes and move on to diagonals
    	i = pieceI;
    	j = pieceJ;

    	//Up and Right
    	i = i-1;
    	j = j+1;
    	while(i>=0 && j<=7) {
    		//White Queens
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
    			
        	}else { //Black Queens
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
    		//White Queens
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
    			
        	}else { //Black Queens
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
    		//White Queens
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
    			
        	}else { //Black Queens
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
    		//White Queens
    		if(board[pieceI][pieceJ].getColor()=='w') {
    			if(board[i][j]==null) {//if empty space
    				moves.add(indexToLetter(j)+indexToNum(i));
    			}else if(board[i][j].getColor()=='b') {//if enemy piece
    				moves.add(indexToLetter(j)+indexToNum(i));
    				break;
    			}else {break;}//if allied piece
    			
        	}else { //Black Queens
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
