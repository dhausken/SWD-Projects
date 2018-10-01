import java.util.Scanner;

public class CheckWriterDriver
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter money amount to be converted into a check:");
        float amount = scanner.nextFloat();
        CheckWriter checkWriter = new CheckWriter(amount);
        System.out.println(checkWriter.moneyToWords());
    }
}
