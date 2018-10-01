import java.util.Random;
/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Handles behaviors for a computer player.
 */
public class ComputerPlayer extends Player
{
    @Override
    public void makeMove(Board b, int i)
    {
        if(getIsX())
        {
            b.setSpaceHasX(true, validMove(b));
        }
        else
        {
            b.setSpaceHasO(true, validMove(b));
        }
    }

    /**
     * Method that allows computer to make a move. It ensures that the move is legal too.
     * @param b Board that move will be made on.
     * @return Integer representing the final move of the computer player.
     */
    public int validMove(Board b)
    {
        Random rand = new Random();
        boolean moveFound = false;
        int selectedMove = 0;
        while(!moveFound)
        {
            selectedMove = rand.nextInt(8);
            if(!b.getSpaceHasO(selectedMove) && !b.getSpaceHasX(selectedMove))
            {
                moveFound = true;
            }
        }
        return selectedMove;
    }
}


