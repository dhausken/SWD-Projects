/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Handles behvaiors for both kinds of players. Used in polymorphism.
 */

public abstract class Player
{
    /**
     * Variable that determines whether a player uses X's or O's.
     */
    private boolean isX;

    /**
     * Abstract method for making a move on the board.
     * @param b Board that the move will be made on.
     * @param i Integer that determines which tile a move will be made on.
     */
    public abstract void makeMove(Board b, int i);

    /**
     * Getter for isX
     * @return boolean for if a player is using X.
     */
    public boolean getIsX() {
        return isX;
    }

    /**
     * Setter for isX
     * @param x New value for isX
     */
    public void setIsX(boolean x) {
        isX = x;
    }
}


