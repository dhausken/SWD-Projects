import java.util.Scanner;


/**
 * Driver for the encrypter and the decrypter. Handles only the user input
 * and object construction.
 */
public class OneTimePad
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String userInput;
        System.out.println("Enter a message to encrypt");
        userInput = sc.nextLine();
        Encrypter e = new Encrypter(userInput.toUpperCase());
        System.out.println("Encrypted message: ");
        e.encryptMessage();
        e.printMessage();
        Decrypter d = new Decrypter(e.getMessage(),e.getLetterCount());
        System.out.println("Decrypted message: ");
        d.decryptMessage();
        d.printMessage();
    }
}
