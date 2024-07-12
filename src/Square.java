import java.io.Serializable;

/**
 * This class represents one square of the board
 * 
 * @author edoar
 */
public class Square implements Serializable{
    
    /**
     * The state of the square
     */
    private SquareState squareState;

    /**
     * Constructor of the square
     * @param squareState state of the square
     */
    public Square(SquareState squareState) {
            this.squareState = squareState;
    }

    /**
     * Getter of the square state
     * @return the state of the square
     */
    public SquareState getSquareState() {
        return squareState;
    }

    /**
     * Setter of the square state
     * @param squareState the new state of the square
     */
    public void setSquareState(SquareState squareState) {
        this.squareState = squareState;
    }

    /**
     * Converts the square into a string
     * @return the string of the square state
     */
    @Override
    public String toString() {
        return squareState.symbol;
    }
}
