import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.*;

/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Driver for the Hangman class. Handles object construction and password
 * text field for entering the word.
 */
public class HangmanTest
{
    public static void main(String[] args)
    {
        boolean continueGame = true;
        JPasswordField enterWord = new JPasswordField();
        JOptionPane.showConfirmDialog(null, enterWord,"Enter Word",JOptionPane.OK_CANCEL_OPTION);
        char[] word = enterWord.getPassword();

        Hangman hangmanGame = new Hangman(word);
        hangmanGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hangmanGame.setSize(350,500);
        hangmanGame.setVisible(true);
    }
}
