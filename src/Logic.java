import java.io.Serializable;

/**
 * This class represents the logic of the checkers game
 * 
 * @author edoar
 */

public class Logic implements Serializable{

    /**
     * Constant for the max number of rows in the square
     */
    private static final int MAX_ROW = 8;
     /**
     * Constant for the max number of columns in the square
     */
    private static final int MAX_COL = 8;
    /**
     * Variable that represents the turn of the players
     * true if is white turn | false if is black turn
     */
    private boolean turn = true;
    
    /**
     * y_cordinates of the piece selected previously
     */
    private int i_selectedPiece;
    /**
     * x_cordinates of the piece selected previously
     */
    private int j_selectedPiece;
    
    /**
     * flags that block the board when the player can't do anything on it
     */
    public boolean lock = false;
    
    /**
     * flag that is true if the game is ended | false otherwise
     */
    public boolean endGame = true;
    
    /**
     * Matrix the represents the board
     */
    private Square[][] board = new Square[MAX_ROW][MAX_COL];// [0][0] bottom left
    
    /**
     * The client of that send the board
     */
    Client client = new Client();


    /**
     * Constructor of the logic
     */
    public Logic() {
        initBoard();
    }
    
    
    /**
     * Lock the board
     */
    public void lockTurn(){
        
        lock = true;
    }
    
    /**
     * Unlock the board
     */
    public void unlockTurn(){
        
        lock = false;
    }
    
    /**
     * Send the board to the other player
     */
    public void sendBoard(){
        
        client.send(this);
    }
    
    /**
     * Initialize the board
     */
    private void initBoard() {
    	for(int i=0; i < MAX_ROW; i++){
            if(i == 3 || i == 4) 
            	initRow(SquareState.EMPTY, i);
            else if(i < 3)
            	initRow(SquareState.WHITE, i);
            else
            	initRow(SquareState.BLACK, i);
    	}
    }
    
    /**
     * Initialize the row
     * @param squareState the state of the square
     * @param i the index of the row
     */
    private void initRow(SquareState squareState, int i) {
        for(int j=0; j < MAX_COL; j++){
            if(i % 2 == 0)
                if(j % 2 == 0)
                    board[i][j] = new Square(squareState);
                else 
                    board[i][j] = new Square(SquareState.EMPTY);
            else
                if(j % 2 != 0)
                    board[i][j] = new Square(squareState);
                else
                    board[i][j] = new Square(SquareState.EMPTY);
        }
    }
    
    /**
     * Getter of the board
     * @return the board
     */
    public Square[][] getBoard(){
        return board;
    }
    
    /**
     * Getter of the turn
     * @return the turn of the player
     */
    public boolean getTurn(){
        return turn;
    }
    
    /**
     * Getter of the square, if the square is not valid it throws an exception
     * @param i the y_coordinate of the square to get
     * @param j the x_coordinate of the square to get
     * @return the square which has cordinates i and j
     * @throws Exception if the cordinates are not valid
     */
    public Square getSquare(int i, int j) throws Exception {
    	if(i<0 || i>MAX_ROW-1 || j<0 || j>MAX_COL-1)
            throw new Exception("Square not valid!");
    	else
            return board[i][j];
    }
    
    /**
     * Marks the square where the selected piece can move 
     * @param i the y_coordinate of the selected piece
     * @param j the x_coordinate of the selected piece
     */
    private void markSquares(int i, int j) {
    	try {	
            if(canEatAny()) {
                if(canEat(i, j, i+1, j+1, i+2, j+2)) {
                    getSquare(i+2, j+2).setSquareState(SquareState.MARKED);
                }

                if(canEat(i, j, i+1, j-1, i+2, j-2)) {
                    getSquare(i+2, j-2).setSquareState(SquareState.MARKED);
                }
                
                if(canEat(i, j, i-1, j+1, i-2, j+2)) {
                    getSquare(i-2, j+2).setSquareState(SquareState.MARKED);
                }

                if(canEat(i, j, i-1, j-1, i-2, j-2)) {
                    getSquare(i-2, j-2).setSquareState(SquareState.MARKED);
                }
            }
            else if(canMoveAny()) {
                if(canMove(i, j, i+1, j+1)) {
                    getSquare(i+1, j+1).setSquareState(SquareState.MARKED);
                }

                if(canMove(i, j, i+1, j-1)) {
                    getSquare(i+1, j-1).setSquareState(SquareState.MARKED);
                }
                
                if(canMove(i, j, i-1, j+1)) {
                    getSquare(i-1, j+1).setSquareState(SquareState.MARKED);
                }

                if(canMove(i, j, i-1, j-1)) {
                    getSquare(i-1, j-1).setSquareState(SquareState.MARKED);
                }
            }
            else {

            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Select a square on the board
     * @param i the y_coordinate of the square to select
     * @param j the x_coordinate of the square to select
     */
    public void selectSquare(int i, int j) {
    	Square selectedSquare;
    	
    	try {
            selectedSquare = getSquare(i, j);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
    	if (lock) { // Check if lock is true
            return; // Do not make the move
        }
        
    	if(isOwnPiece(i, j)) { //piece to move selected
            clearMarks();
            i_selectedPiece = i;
            j_selectedPiece = j;
            markSquares(i, j);
    	}
    	else if(selectedSquare.getSquareState().isEmpty() || turn && selectedSquare.getSquareState().isBlack() || !turn && selectedSquare.getSquareState().isWhite()) { //empty square or opponent square selected
            clearMarks();			
    	}
    	else if(selectedSquare.getSquareState().isMarked()) {//marked square selected
            move(i, j);
            clearMarks();
    	}
    }
    
    /**
     * Move the selected piece to the selected marked square
     * @param i the y_coordinate of the square where to move the selected piece
     * @param j the x_coordinate of the square where to move the selected piece
     */
    private void move(int i, int j) {
    	try {
            //parte per il damone
            
            getSquare(i, j).setSquareState(getSquare(i_selectedPiece, j_selectedPiece).getSquareState());
            getSquare(i_selectedPiece, j_selectedPiece).setSquareState(SquareState.EMPTY);      
            
            if(i == MAX_ROW-1 && getSquare(i, j).getSquareState().isWhite())
                getSquare(i, j).setSquareState(SquareState.WHITE_KING);
            else if(i == MAX_ROW-1 && getSquare(i, j).getSquareState().isBlack())
                getSquare(i, j).setSquareState(SquareState.BLACK_KING);

            if(i - i_selectedPiece == 2 || i - i_selectedPiece == -2) {//the player has ate a piece
                getSquare((i+i_selectedPiece)/2, (j + j_selectedPiece)/2).setSquareState(SquareState.EMPTY);
                if(!canEat(i, j, i+1, j+1, i+2, j+2) && !canEat(i, j, i+1, j-1, i+2, j-2) &&
                   !canEat(i, j, i-1, j+1, i-2, j+2) && !canEat(i, j, i-1, j-1, i-2, j-2)) {
                   //switchTurn();
                   lock = true;
                   sendBoard();
                }
            }
            else {//the player hasn't eat a piece
                //switchTurn();
                lock = true;
                sendBoard();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Removes the marked squares of the board
     */
    public void clearMarks() {
    	for(int i=0; i < MAX_ROW; i++)
            for(int j=0; j < MAX_COL; j++)
                if(board[i][j].getSquareState().equals(SquareState.MARKED))
                    board[i][j].setSquareState(SquareState.EMPTY);
    }
    
    /**
     * Switch the turn and flips the board
     */
    public void switchTurn() {
    	turn = !turn;
    	
    	Square[] tempRow = new Square[MAX_ROW];
    	
    	for(int i=0; i < MAX_ROW/2; i++) {
            tempRow = board[i];
            board[i] = board[MAX_ROW-1-i];
            board[MAX_ROW-1-i] = tempRow;
    	}
    }
    
    /**
     * Checks if the current player can eat any piece
     * @return true if the player can eat any piece | false if the palyer can't eat any piece
     */
    private boolean canEatAny() {
    	for(int i=0; i < MAX_ROW; i++)
            for(int j=0; j < MAX_COL; j++) {
                if(canEat(i, j, i+1, j+1, i+2, j+2))
                    return true;
                if(canEat(i, j, i+1, j-1, i+2, j-2))
                    return true;
                if(canEat(i, j, i-1, j+1, i-2, j+2))
                    return true;
                if(canEat(i, j, i-1, j-1, i-2, j-2))
                    return true;
            }
    	return false;
    }
    
    /**
     * Checks if a piece can eat another piece
     * @param start_i the y_coordinate of the eater piece
     * @param start_j the x_coordinate of the eater piece
     * @param toEat_i the y_coordinate of the piece to eat
     * @param toEat_j the x_coordinate of the piece to eat
     * @param end_i the y_coordinate of the square where the piece should go after it has eaten the piece
     * @param end_j the x_coordinate of the square where the piece should go after it has eaten the piece
     * @return true if the piece can it | false if the piece can't eat
     */
    private boolean canEat(int start_i, int start_j, int toEat_i, int toEat_j, int end_i, int end_j) {
    	Square startSquare;
    	Square toEatSquare;
    	Square endSquare;
    	
        try {
            startSquare = getSquare(start_i, start_j);
            toEatSquare = getSquare(toEat_i, toEat_j);
            endSquare = getSquare(end_i, end_j);
            
            if(isOwnPiece(start_i, start_j)){
                if(!startSquare.getSquareState().isKing() && start_i > end_i){
                    return false;
                }
                
                if(startSquare.getSquareState().isOppositeTo(toEatSquare.getSquareState()) && endSquare.getSquareState().isEmpty() ) { 
                    if(!startSquare.getSquareState().isKing() && toEatSquare.getSquareState().isKing()){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
                else {
                    return false;
                }
            }
            else{
                return false;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Checks if the current player can move any piece
     * @return true if the player can move any piece | false if the palyer can't move any piece
     */
    private boolean canMoveAny() {
    	for(int i=0; i < MAX_ROW; i++)
            for(int j=0; j < MAX_COL; j++) {
                if(canMove(i, j, i+1, j+1))
                        return true;
                if(canMove(i, j, i+1, j-1))
                        return true;
                if(canMove(i, j, i-1, j+1))
                        return true;
                if(canMove(i, j, i-1, j-1))
                        return true;
            }
    	return false;
    }
    
    /**
     * Checks if a piece can eat another piece
     * @param start_i the y_coordinate of the moving piece
     * @param start_j the x_coordinate of the moving piece
     * @param end_i the y_coordinate of the square where the piece move
     * @param end_j the x_coordinate of the square where the piece move
     * @return true if the piece can it | false if the piece can't eat
     */
    private boolean canMove(int start_i, int start_j, int end_i, int end_j) {
    	Square startSquare;
        Square endSquare;
    	
    	try {
            startSquare = getSquare(start_i, start_j);
            endSquare = getSquare(end_i, end_j);
            
            if(isOwnPiece(start_i, start_j)){
                 if(!startSquare.getSquareState().isKing() && start_i > end_i){
                    return false;
                }
                 
                if(endSquare.getSquareState().isEmpty())
                    return true;
                else
                    return false;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Checks if the player has selected his own piece
     * @param i the y_coordinate of the piece
     * @param j the x_coordinate of the piece
     * @return true if the piece belongs to the player | false if the piece doesn't belong to the player
     */
    private boolean isOwnPiece(int i, int j){
        try {
            if((turn && getSquare(i, j).getSquareState().isWhite()) || (!turn && getSquare(i, j).getSquareState().isBlack()))
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Checks if the player has lost the game
     * @return 1 if the no one has lost | 1 if white has lost | 2 if black has lost
     */
    public int checkLooser(){
        
        boolean looseCondition;
        
        this.switchTurn();
        looseCondition = !canMoveAny() && !canEatAny() && !isAnyMarked();
        if(turn && looseCondition)
            return 1;
        else if(!turn && looseCondition)
            return 2;
        
        this.switchTurn();
        looseCondition = !canMoveAny() && !canEatAny() && !isAnyMarked();
        if(turn && looseCondition)
            return 1;
        else if(!turn && looseCondition)
            return 2;
        
        return 0; 
            
    }
    
    /**
     * Checks if there is any marked square on the board
     * @return true if there is any marked square on the board | false otherwise
     */
    private boolean isAnyMarked(){
        for(int i=0; i < MAX_ROW; i++)
            for(int j=0; j < MAX_COL; j++)
                if(board[i][j].getSquareState().isMarked())
                    return true;
        return false;
    }
    
    /**
     * Converts the board into a string
     * @return the string of the board
     */
    @Override
    public String toString() {
        String text = "";
        
        for(int i=MAX_ROW-1; i >= 0; i--){
            for(int j=0; j < MAX_COL; j++)
                text += board[i][j] + "\t";
            text += "\n";
        }
        
        return text;
    }
}