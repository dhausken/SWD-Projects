import java.util.Scanner;
    /**
     * @author David Hausken
     * @version 1.0
     * @since 1.0
     *
     * Driver class for the Easter class. Handles Scanner implementation too.
     */
    public class Computus
    {
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            int year;
            String  month;
            System.out.println("Welcome to Computus\nEnter a year for the date of Easter in that year");
            year = sc.nextInt();
            Easter e = new Easter(year);
            month = e.numToMonth(e.getMonth());
            System.out.println("Easter will occur on: ");
            System.out.println(month + " " + e.getDay() + ", " + year);
            e.findEasterDay();
            e.daysInCycle();
        }
    }