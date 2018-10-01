import java.util.Random;
import java.util.Scanner;
/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 */


public class Encrypter {
    /**
     * Char array representing the alphabet. Used for changing letters
     * in the message during the encryption process.
     */
    private final static char alphabet[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * Char array representing the inputted message from the user.
     */
    private char[] message;

    /**
     * Integer array storing the randomly generated values for decryption use.
     */
    private int letterCount[];
    private Random rand = new Random();

    /**
     *
     * Constructor
     * @param m message that the user enters
     */
    public Encrypter(String m)
    {
        message = m.toCharArray();
        letterCount = new int[message.length];
    }

    /**
     * Getter for message
     *
     * @return The message in the form of a char array
     */
    public char[] getMessage()
    {
        return message;
    }

    /**
     * Getter for letter count.
     *
     * @return letter count for each individual letter
     */
    public int[] getLetterCount()
    {
        return letterCount;
    }

    /**
     * Prints the char array out.
     */
    public void printMessage()
    {
        for(int i = 0; i < message.length; i++)
        {
            System.out.print(message[i]);
        }
        System.out.println();
    }

    /**
     * Loops through each char in the message (ignoring spaces) and finds
     * the correct letter in the alphabet. It generates a random integer value
     * and shifts the letter that amount.
     */
    public void encryptMessage()
    {
        for(int i = 0; i < message.length; i++) //Loops through each character in message
        {
            if(message[i] != ' ') //Ignore spaces
            {
                int j = 0;
                while(message[i] != alphabet[j]) {
                    j++;
                }
                    if(message[i] == alphabet[j])
                    {
                        int nValue = rand.nextInt(25)+1;
                        message[i] = alphabet[(j + nValue) % 26];
                        letterCount[i] = nValue;
                        System.out.print(letterCount[i] + ", ");
                    }
            }
        }
        System.out.println();
    }
}
