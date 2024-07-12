import java.io.Serializable;

/**
 * This enum represents the state of one square of the board
 * 
 * @author edoar
 */

public enum SquareState implements Serializable{
    
    
    /**
     * Value for an empty square
     */
    EMPTY("-"),
    /**
     * Value for a white checker
     */
    WHITE("w"),
    /**
     * Value for a black checker
     */
    BLACK("b"),
    /**
     * Value for a white king
     */
    WHITE_KING("W"),
    /**
     * Value for a black king
     */
    BLACK_KING("B"),
    /**
     * Value for a marked square
     */
    MARKED("*");

    /**
     * String to print the value of the enum
     */
    public final String symbol;
    

    /**
     * Constructor of the enum
     * @param symbol symbol to print the value of the enum
     */
    SquareState(String symbol){
        this.symbol = symbol;
    }

    /**
     * Checks if the piece is white
     * @return true if the piece is a white checker or a white king
     */
    public boolean isWhite() {
        if(this.equals(WHITE) || this.equals(WHITE_KING))
            return true;
        else
            return false;
    }

     /**
     * Checks if the piece is black
     * @return true if the piece is a black checker or a black king
     */
    public boolean isBlack() {
        if(this.equals(BLACK) || this.equals(BLACK_KING))
            return true;
        else
            return false;
    }

    /**
     * Checks if the piece is a king
     * @return true if the piece is a king
     */
    public boolean isKing() {
        if(this.equals(WHITE_KING) || this.equals(BLACK_KING))
            return true;
        else
            return false;
    }

    /**
     * Checks if the piece is empty
     * @return true if the square is empty
     */
    public boolean isEmpty() {
        if(this.equals(EMPTY))
            return true;
        else
            return false;
    }

    /**
     * Checks if the piece is marked
     * @return true if the square is marked
     */
    public boolean isMarked() {
        if(this.equals(MARKED))
            return true;
        else
            return false;
    }

    /**
     * Compares two pieces by their color
     * @param square2 represents the square to compare with this square
     * @return true if this enum has an oppisite color campared to square2
     */
    public boolean isOppositeTo(SquareState square2) {
        if(this.isWhite() && square2.isBlack() || this.isBlack() && square2.isWhite())
            return true;
        else
            return false;
    }
}
