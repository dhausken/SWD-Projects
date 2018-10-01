import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Handles behaviors for the game.
 */
public class Hangman extends JFrame{
    /**
     * Word inputted in the password field at the beginning of execution.
     */
    private char[] word;

    /**
     * Same length as word. What the user sees in the wordTextField.
     * Initialized to have '*' in all elements at the beginning.
     */
    private char[] hiddenWord;

    /**
     * Number of tries the user has to guess the word.
     */
    private int tries = 6;

    /**
     * Letters guessed by the user.
     */
    private String guessedLetters = "";

    /**
     * Text field where the user inputs guesses.
     */
    private final JTextField guessTextField;

    /**
     * Text field where the user sees the hidden word.
     */
    private final JTextField wordTextField;

    /**
     * Label where the user sees the letters already guessed.
     */
    private final JLabel usedLettersLabel;

    /**
     * Label where the user sees the amount of tries they have left.
     */
    private final JLabel attemptsRemainingLabel;

    /**
     * Constructor. Handles GUI implementation.
     * @param word Word that is entered in the password text field.
     */
    Hangman(char[] word)
    {
        this.word = new char[word.length];
        this.hiddenWord = new char[word.length];
        String hiddenWordString = "";
        for (int i = 0; i < word.length; i++)
        {
            this.hiddenWord[i] = '*';
            hiddenWordString += hiddenWord[i];
        }
        System.arraycopy(word, 0, this.word, 0, word.length);
        setLayout(new FlowLayout());

        guessTextField = new JTextField("Enter letter here",12);
        add(guessTextField);

        wordTextField = new JTextField(hiddenWordString,12);
        wordTextField.setEditable(false);
        add(wordTextField);

        usedLettersLabel = new JLabel("Guessed Letters: ");
        add(usedLettersLabel);

        attemptsRemainingLabel = new JLabel("Attempts Remaining: " + tries);
        add(attemptsRemainingLabel);

        GuessTextFieldHandler handler = new GuessTextFieldHandler();
        guessTextField.addActionListener(handler);
    }

    /**
     * Stickfigure drawing. Draws stick man based on the number of tries the user has left. repaint() is called in
     * GuessTextFieldHandler.
     * @param g Graphic where the drawing is.
     */
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(50,400,90,55);
        g.drawLine(90,400,90,300);
        g.drawLine(90,300, 200,300);
        g.drawLine(200,300,200,350);
        if(tries <= 5)
        {
            g.fillOval(175,350,50,50);
        }
        if(tries <= 4)
        {
            g.drawLine(200,350,200,450);
        }
        if(tries <= 3)
        {
            g.drawLine(200,425,230,425);
        }
        if(tries <= 2)
        {
            g.drawLine(200,425,170,425);
        }
        if(tries <= 1)
        {
            g.drawLine(200,450,230,475);
        }
        if(tries == 0)
        {
            g.drawLine(200,450,170,475);
        }

    }

    /**
     * Handles almost all of the game behaviors. char array hiddenText copies the size of the word and fills it in with '*'.
     * guessTextField acquires the first letter in the field. The program checks if the input is in the word and if it
     * is, hiddenText will have visible letters at the correct locations. If not, the user loses a try. When the hidden
     * word is equal to the word, then the user will win.
     *
     */
    private class GuessTextFieldHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            StringBuilder hiddenWordString = new StringBuilder();
            StringBuilder wordString = new StringBuilder();
            if(e.getSource() == guessTextField && guessTextField.isEditable())
            {
                char userInput = guessTextField.getText().toLowerCase().charAt(0);
                boolean letterFound = false;
                for(int i = 0; i < word.length; i++)
                {
                    if(userInput == word[i])
                    {
                        hiddenWord[i] = userInput;
                        letterFound = true;
                    }
                }
                guessedLetters = guessedLetters + userInput + ", ";
                if(!letterFound)
                {
                    tries--;
                    repaint();
                }
                for (int i = 0; i < word.length; i++)
                {
                    hiddenWordString.append(hiddenWord[i]);
                }
                for (char aWord : word) {
                    wordString.append(aWord);
                }
                wordTextField.setText(hiddenWordString.toString());
                usedLettersLabel.setText("Guessed Letters: " + guessedLetters);
                attemptsRemainingLabel.setText("Attempts Remaining: " + tries);
                if(tries == 0)
                {
                    guessTextField.setEditable(false);
                    attemptsRemainingLabel.setText("You Lose!");
                }
                if(hiddenWordString.toString().equals(wordString.toString()))
                {
                    guessTextField.setEditable(false);
                    attemptsRemainingLabel.setText("You Win!");
                }
            }
        }
    }

    /**
     * Getter for word.
     * @return word in char array form.
     */
    public char[] getWord()
    {
        return word;
    }

    /**
     * Getter for tries.
     * @return int tries
     */
    public int getTries()
    {
        return tries;
    }
}
