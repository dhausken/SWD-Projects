import java.util.Scanner;

public class TicTacToeDriver
{
    public static void main(String args[])
    {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose the number corresponding to the correct player configuration: ");
        System.out.println("1. Two Humans\n2. One Human; One Computer\n3. Two Computers");
        int selection = scanner.nextInt();
        if(selection == 1)
        {
            HumanPlayer player1 = new HumanPlayer();
            HumanPlayer player2 = new HumanPlayer();
            player1.setIsX(true);
            System.out.println(board.spaceBooleanToString() + "\n");
            while(!board.gameOver())
            {
                player1.playerTurn(board);
                System.out.println(board.spaceBooleanToString()+"\n");
                if(board.gameOver())
                {
                    break;
                }
                player2.playerTurn(board);
                System.out.println(board.spaceBooleanToString()+"\n");
            }
        }
        else if(selection == 2)
        {
            HumanPlayer player1 = new HumanPlayer();
            ComputerPlayer computer1 = new ComputerPlayer();
            player1.setIsX(true);
            System.out.println(board.spaceBooleanToString()  + "\n");
            while(!board.gameOver())
            {
                player1.playerTurn(board);
                if(board.gameOver())
                {
                    break;
                }
                computer1.makeMove(board,computer1.validMove(board));
                System.out.println(board.spaceBooleanToString() + "\n");
            }
        }
        else if(selection == 3)
        {
            ComputerPlayer computer1 = new ComputerPlayer();
            ComputerPlayer computer2 = new ComputerPlayer();
            computer1.setIsX(true);
            System.out.println(board.spaceBooleanToString() + "\n");
            while(!board.gameOver())
            {
                computer1.makeMove(board,computer1.validMove(board));
                if(board.gameOver())
                {
                    break;
                }
                computer2.makeMove(board,computer2.validMove(board));
                System.out.println(board.spaceBooleanToString() + "\n");
            }
        }
    }
}
