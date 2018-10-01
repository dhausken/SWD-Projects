/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 */


public class Decrypter
{
    /**
     * Alphabet character array used for setting char values
     * after a shift.
     */
    private final static char alphabet[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * Char array representing the message after encryption.
     */
    private char[] message;

    /**
     * Char array representing the amount to shift
     * each individual letter in the message.
     */
    private int[] letterShift;

    /**
     * Constructor
     * @param word The word to decrypt.
     * @param letterShift Array of integers for shifting each letter in the message.
     */
    public Decrypter(char[] word, int[] letterShift)
    {
        this.message = new char[word.length];
        System.arraycopy(word, 0, this.message, 0, word.length);

        this.letterShift = new int[letterShift.length];
        System.arraycopy(letterShift, 0, this.letterShift, 0, word.length);
    }

    /**
     * Returns the message in char array form.
     *
     * @return String message
     */
    public char[] getMessage()
    {
        return message;
    }

    /**
     * Prints out the message
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
     * Shifts a letter backwards based on an integer obtained from an encrypter.
     * If the shift would loop the letter around in the alphabet, creates a sub
     * variable which will take in the negative value and the letter would
     * then be equal the sub plus the total amount of letters in the alphabet.
     */
    public void decryptMessage()
    {
        for (int aLetterShift : letterShift) {
            System.out.print(aLetterShift + ", ");
        }
        System.out.println();
        for(int i = 0; i < message.length; i++)
        {
            if(message[i] != ' ')
            {
                int j = 0;
                while(message[i] != alphabet[j])
                {
                    j++;
                }

                if(j - letterShift[i] < 0)
                {
                    int sub = j - letterShift[i];
                    message[i] = alphabet[26+sub];
                } else {
                    message[i] = alphabet[j-letterShift[i]];
                }
            }
        }

    }
}




