/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Handles behaviors for the CheckWriter
 */
public class CheckWriter
{
    /**
     * Float representing the amount inputted by the user.
     */
    private float amount;
    /**
     * Int representing the amount with the decimal. Used to get the decimal.
     */
    private int wholeNumber;
    /**
     * The decimal of the amount after being multiplied by 100, used for the fraction.
     */
    private float decimal;

    /**
     * Constructor for the check writer. Due to an unknown bug, it adjusts the decimal if it's odd.
     * @param amount Specified amount of money to be converted into an appropriate check translation.
     */
    public CheckWriter(float amount) {
        this.amount = amount;
        wholeNumber = (int) amount;
        if((this.amount - wholeNumber)%2 == 1)
        {
            decimal = Math.round((this.amount - wholeNumber)*100)+1;
        }
        else
        {
            decimal = Math.round((this.amount - wholeNumber)*100);
        }
        if(decimal > 100 || amount > 1000)
        {
            throw new IllegalArgumentException("Not a valid money amount.");
        }
    }

    /**
     * Converts the amount defined in the constructor and converts it to check form.
     * @return String representing the value of the money in check form.
     */
    public String moneyToWords()
    {
        String temp = "";
        temp += hundredsDigit((wholeNumber/100)%10);
        temp += tensDigit((wholeNumber/10)%10);
        temp += onesDigit((wholeNumber/10)%10,wholeNumber%10);
        temp += " and ";
        temp += (int) decimal + "/" + "100";
        return temp;
    }

    /**
     * Handles String behaviors for numbers with a hundreds digit.
     * @param i Integer representing the value in the hundreds place.
     * @return String of the converted hundreds place digit.
     */
    private String hundredsDigit(int i)
    {
        String temp = "";
        if(i == 9)
        {
            temp = "NINE hundred ";
        }
        else if(i == 8)
        {
            temp = "EIGHT hundred ";
        }
        else if(i == 7)
        {
            temp = "SEVEN hundred ";
        }
        else if(i == 6)
        {
            temp = "SIX hundred ";
        }
        else if(i == 5)
        {
            temp = "FIVE hundred ";
        }
        else if(i == 4)
        {
            temp = "FOUR hundred ";
        }
        else if(i == 3)
        {
            temp = "THREE hundred ";
        }
        else if(i == 2)
        {
            temp = "TWO hundred ";
        }
        else if(i == 1)
        {
            temp = "ONE hundred ";
        }
        return temp;
    }

    /**
     * Handles String behaviors for numbers with a tens digit.
     * @param i Integer representing the value in the tens place.
     * @return String of the converted tens place digit.
     */
    private String tensDigit(int i)
    {
        String temp = "";
        if(i == 9)
        {
            temp += "NINETY";
        }
        else if(i == 8)
        {
            temp += "EIGHTY";
        }
        else if(i == 7)
        {
            temp += "SEVENTY";
        }
        else if(i == 6)
        {
            temp += "SIXTY";
        }
        else if(i == 5)
        {
            temp += "FIFTY";
        }
        else if(i == 4)
        {
            temp += "FORTY";
        }
        else if(i == 3)
        {
            temp += "THIRTY";
        }
        else if(i == 2)
        {
            temp += "TWENTY";
        }
        return temp;
    }

    /**
     * Handles String behaviors for numbers with a ones digit and special tens digit cases.
     * @param tens Int representing tens digit of a number.
     * @param ones Int representing ones ed
     * @return String of the converted ones place digit.
     */
    private String onesDigit(int tens, int ones)
    {
        String temp = "";
        if(tens == 1)
        {
            if(ones == 9)
            {
                temp += "NINETEEN";
            }
            else if(ones== 8)
            {
                temp += "EIGHTEEN";
            }
            else if(ones== 7)
            {
                temp += "SEVENTEEN";
            }
            else if(ones== 6)
            {
                temp += "SIXTEEN";
            }
            else if(ones== 5)
            {
                temp += "FIFTEEN";
            }
            else if(ones == 4)
            {
                temp += "FOURTEEN";
            }
            else if(ones == 3)
            {
                temp += "THIRTEEN";
            }
            else if(ones == 2)
            {
                temp += "TWELVE";
            }
            else if(ones == 1)
            {
                temp += "ELEVEN";
            }
        }
        if(ones == 9)
        {
            temp += "-NINE";
        }
        else if(ones== 8)
        {
            temp += "-EIGHT";
        }
        else if(ones== 7)
        {
            temp += "-SEVEN";
        }
        else if(ones== 6)
        {
            temp += "-SIX";
        }
        else if(ones== 5)
        {
            temp += "-FIVE";
        }
        else if(ones == 4)
        {
            temp += "-FOUR";
        }
        else if(ones == 3)
        {
            temp += "-THREE";
        }
        else if(ones == 2)
        {
            temp += "-TWO";
        }
        else if(ones == 1)
        {
            temp += "-ONE";
        }
        return temp;
    }

    /**
     * Getter for amount
     * @return float of the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Setter for amount. Also adjusts wholeNumber and decimal.
     * @param amount Specified value for amount
     */
    public void setAmount(float amount) {
        this.amount = amount;
        wholeNumber = (int) amount;
        if((this.amount - wholeNumber)%2 == 1)
        {
            decimal = Math.round((this.amount - wholeNumber)*100)+1;
        }
        else
        {
            decimal = Math.round((this.amount - wholeNumber)*100);
        }
        if(decimal > 100 || amount > 1000)
        {
            throw new IllegalArgumentException("Not a valid money amount.");
        }
    }



}
