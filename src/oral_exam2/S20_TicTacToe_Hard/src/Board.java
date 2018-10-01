/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Handles behaviors for a Tic-Tac-Toe game board.
 */
public class Board
{
    /**
     * Boolean array that keeps track of spaces with an X
     */
    private boolean[] spaceHasX = new boolean[9];
    /**
     * Boolean array that keeps track of spaces with an O
     */
    private boolean[] spaceHasO = new boolean[9];
    /**
     * Boolean array that keeps track of spaces that are used.
     */
    private boolean[] spaceUsed = new boolean[9];

    /**
     * Getter for spaceHasX
     * @param i Integer for index value of the array
     * @return Value at the index
     */
    public boolean getSpaceHasX(int i)
    {
        return spaceHasX[i];
    }

    /**
     * Setter for spaceHasX
     * @param b New desired boolean value
     * @param i Index to change value of.
     */
    public void setSpaceHasX(boolean b, int i)
    {
        this.spaceHasX[i] = b;
    }

    /**
     * Getter for spaceHasO
     * @param i Integer for index value of the array
     * @return Value at the index
     */
    public boolean getSpaceHasO(int i)
    {
        return spaceHasO[i];
    }

    /**
     * Setter for spaceHasO
     * @param i Integer for index value of the array
     */
    public void setSpaceHasO(boolean b, int i)
    {
        this.spaceHasO[i] = b;
    }

    /**
     * Getter for spaceUsed
     * @param i Integer for index value of the array
     * @return Value at the index
     */
    public boolean getSpaceUsed(int i)
    {
        return spaceUsed[i];
    }

    /**
     * Setter for spaceUsed
     * @param i Integer for index value of the array
     */
    public void setSpaceUsed(boolean b, int i)
    {
        this.spaceUsed[i] = b;
    }

    /**
     * Reads the values of the boolean arrays and creates a Tic-Tac-Toe grid
     * based on the values.
     * @return A string representing the grid.
     */
    public String spaceBooleanToString()
    {
        String temp = "";
        for(int i = 0; i < 9; i++)
        {
            if(i == 3 || i == 6)
            {
                temp += "\n";
            }
            if(spaceHasX[i])
            {
                temp += "[X]";
            }
            else if(spaceHasO[i])
            {
                temp += "[O]";
            }
            else
            {
                temp += "[" + (i+1) + "]";
            }
        }
        return temp;
    }

    /**
     * Checks if X wins.
     * @return boolean representing X satisfying victory conditions.
     */
    private boolean xWins()
    {
        return  spaceHasX[0] && spaceHasX[1] && spaceHasX[2]
                || spaceHasX[3] && spaceHasX[4] && spaceHasX[5]
                || spaceHasX[6] && spaceHasX[7] && spaceHasX[8]
                || spaceHasX[0] && spaceHasX[3] && spaceHasX[6]
                || spaceHasX[1] && spaceHasX[4] && spaceHasX[7]
                || spaceHasX[2] && spaceHasX[5] && spaceHasX[8]
                || spaceHasX[0] && spaceHasX[4] && spaceHasX[8]
                || spaceHasX[2] && spaceHasX[4] && spaceHasX[6];
    }

    /**
     * Checks if O wins.
     * @return boolean representing O satisfying victory conditions.
     */
    private boolean oWins()
    {
        return  spaceHasO[0] && spaceHasO[1] && spaceHasO[2]
                || spaceHasO[3] && spaceHasO[4] && spaceHasO[5]
                || spaceHasO[6] && spaceHasO[7] && spaceHasO[8]
                || spaceHasO[0] && spaceHasO[3] && spaceHasO[6]
                || spaceHasO[1] && spaceHasO[4] && spaceHasO[7]
                || spaceHasO[2] && spaceHasO[5] && spaceHasO[8]
                || spaceHasO[0] && spaceHasO[4] && spaceHasO[8]
                || spaceHasO[2] && spaceHasO[4] && spaceHasO[6];
    }

    /**
     * Checks if the board is filled.
     * @return Boolean representing a tie.
     */
    private boolean boardFilled()
    {
        for(int i = 0; i < spaceUsed.length-1;i++)
        {
            if(!spaceUsed[i])
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks each of the possible endings to the game.
     * Prints a message corresponding to the correct
     * victory condition.
     * @return boolean that determines whether the game is over or not.
     */
    public boolean gameOver()
    {
        if(xWins())
        {
            System.out.println("X wins!");
            return true;
        }
        else if(oWins())
        {
            System.out.println("O wins!");
            return true;
        }
        else if(boardFilled())
        {
            System.out.println("Tie!");
            return true;
        }
        return false;
    }
}


