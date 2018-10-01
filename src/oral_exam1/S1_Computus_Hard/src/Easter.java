import java.util.Scanner;
/**
 * @author David Hausken <david-hausken@uiowa.edu>
 * @version 1.0
 * @since 1.0
 *
 * Handles behaviors for Computus calculations.
 */
public class Easter
{
    /**
     * doubles a-m are all variables used in the Anonymous Gregorian algorithm.
     */
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i;
    private double k;
    private double l;
    private double m;
    /**
     * The year inputted
     */
    private int year;

    /**
     * The month of the year for Easter.
     */
    private int month;

    /**
     * The day of the year for Easter.
     */
    private int day;

    /**
     * A 2D array corresponding to dates of the year.
     */
    private int dates[][] = new int[11][30];

    /**
     * The year to end after an Easter cycle.
     */
    private int endYear;

    /**
     * Months of the year used for printing out to the user.
     */
    private static final String monthsArray[] = {"January","February","March","April","May","June",
            "July","August","September","October","November","December"};

    /**
     * Constructor. Able to calculate the date of Easter for the year.
     * @param year The desired year to calculate Easter.
     */
    public Easter(int year)
    {
        this.year = year;
        endYear = year + 5700000;
        a = year%19;
        b = Math.floor(year/100);
        c = year%100;
        d = Math.floor((b/4));
        e = b%4;
        f = Math.floor((b+8)/25);
        g = Math.floor((b-f+1)/3);
        h = (19*a+b-d-g+15)%30;
        i = Math.floor(c/4);
        k = c%4;
        l = (32 + 2* e + 2 * i - h - k)%7;
        m = Math.floor((a+11*h+22*l)/451);
        month = (int) Math.floor((h+l-7*m+114)/31);
        day = (int) (((h+l-7*m+114)%31)+1);
    }

    /**
     * Converts an integer to a month, where 0 is January and 11 is December.
     *
     * @param m month in number form.
     * @return month from monthsArray corresponding to correct int
     */
    public String numToMonth(int m)
    {
        return monthsArray[m-1];
    }

    /**
     * Getter for month
     *
     * @return The month in numeric form.
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Getter for day
     *
     * @return The day in numeric form.
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Recalculates the date for Easter based on the year. Useful for calculating the number
     * of days in an Easter cycle.
     *
     * @param year The year from which to calculate Easter
     */
    public void EasterMath(int year)
    {
        a = year%19;
        b = Math.floor(year/100);
        c = year%100;
        d = Math.floor((b/4));
        e = b%4;
        f = Math.floor((b+8)/25);
        g = Math.floor((b-f+1)/3);
        h = (19*a+b-d-g+15)%30;
        i = Math.floor(c/4);
        k = c%4;
        l = (32 + 2* e + 2 * i - h - k)%7;
        m = Math.floor((a+11*h+22*l)/451);
        month = (int) Math.floor((h+l-7*m+114)/31);
        day = (int) (((h+l-7*m+114)%31)+1);
    }

    /**
     * Finds the number of times a date has Easter in an Easter cycle.
     * Increments a 2D array corresponding to the date on the calendar.
     */
    public void findEasterDay()
    {
        while(year <= endYear)
        {
            EasterMath(year);
            for(int j = 0; j < 11; j++)
            {
                for(int k = 0; k < 30; k++)
                {
                    if(month == j && day == k)
                    {
                        dates[j][k]++;
                    }
                }
            }
            year++;
        }
    }

    /**
     * Prints out the dates in order in which a date has at least one Easter.
     */
    public void daysInCycle()
    {
        for(int j = 0; j < 11; j++)
        {
            for(int k = 0; k < 30; k++)
            {
                if(dates[j][k] > 0)
                {
                    System.out.println(monthsArray[j-1] + " " + k + " - " + dates[j][k]);
                }
            }
        }
    }
}

