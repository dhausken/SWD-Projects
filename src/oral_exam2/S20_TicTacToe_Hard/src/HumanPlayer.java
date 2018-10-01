import java.util.Scanner;

/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Handles behaviors for a human player.
 */
public class HumanPlayer extends Player
{
    /**
     *
     * @param b Board that the move will be made on.
     * @param s Number corresponding to the space that the move will be made on.
     */
    @Override
    public void makeMove(Board b, int s)
    {
        if(getIsX())
        {
            b.setSpaceHasX(true, s);
        }
        else
        {
            b.setSpaceHasO(true, s);
        }
    }

    /**
     * Behaviors for when it is a player turn. Asks for a valid move until it receives one.
     * Also handles information given to the user.
     * @param b Board used to check if a space is used.
     */
    public void playerTurn(Board b)
    {
        Scanner scanner = new Scanner(System.in);
        boolean legalMove = false;
        int selectedMove = 0;
        if(getIsX())
        {
            System.out.println("X's Turn:");
        }
        else
        {
            System.out.println("O's Turn:");
        }
        System.out.println("Select a space corresponding to the number.");
        while(!legalMove)
        {
            selectedMove = scanner.nextInt();
            if(selectedMove > 9 || b.getSpaceUsed(selectedMove-1))
            {
                System.out.println("Not a valid move, please try again.");
            }
            else
            {
                legalMove = true;
                b.setSpaceUsed(true,selectedMove-1);
            }
        }
        makeMove(b,selectedMove-1);
    }
}


