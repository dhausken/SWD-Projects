import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for the characteristics of the GUI that handles Arabic to Roman
 * and Roman to Arabic conversion.
 */
public class ArabicRomanConversion extends JFrame {
    /**
     * Text field where user enters number.
     */
    private final JTextField arabicTextField;

    /**
     * Text field where user enters Roman numerals.
     */
    private final JTextField romanTextField;

    /**
     * Boolean that determines if the user is currently typing
     * in the Arabic text field.
     */
    private boolean arabicTextFieldFocus = false;

    /**
     * Boolean that determines if the user is currently
     * typing in the Roman text field.
     */
    private boolean romanTextFieldFocus = false;

    /**
     * Constructor. Handles GUI implementation, focus listeners,
     * and document listeners.
     */
    public ArabicRomanConversion() {
        setLayout(new FlowLayout());
        arabicTextField = new JTextField("", 10);
        add(arabicTextField);

        romanTextField = new JTextField("", 10);
        add(romanTextField);
        arabicTextField.setToolTipText("Arabic numbers go here.");
        romanTextField.setToolTipText("Roman numerals go here.");

        /**
         * Checks if the user is currently typing in the arabic text field.
         */
        arabicTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                arabicTextFieldFocus = true;
            }

            @Override
            public void focusLost(FocusEvent focusEvent)
            {
                arabicTextFieldFocus = false;

            }
        });

        /**
         * Checks if the user is currently typing in the Roman text field.
         */
        romanTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                romanTextFieldFocus = true;
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                romanTextFieldFocus = false;
            }
        });

        /**
         * Dynamically updates arabic text field through document listener.
         * Checks if the user is typing in the arabic text field and it isn't blank
         * before executing.
         */
        arabicTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent d)
            {
                String text = arabicTextField.getText();
                if(!text.equals("") && arabicTextFieldFocus)
                {
                    int arabicNumber = Integer.parseInt(arabicTextField.getText());
                    romanTextField.setText(ArabicToRoman(arabicNumber));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent d)
            {
                String text = arabicTextField.getText();
                if(!text.equals("") && arabicTextFieldFocus)
                {
                    int arabicNumber = Integer.parseInt(arabicTextField.getText());
                    romanTextField.setText(ArabicToRoman(arabicNumber));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent d)
            {
                String text = arabicTextField.getText();
                if(!text.equals("") && arabicTextFieldFocus)
                {
                    int arabicNumber = Integer.parseInt(arabicTextField.getText());
                    romanTextField.setText(ArabicToRoman(arabicNumber));
                }
            }
        });

        /**
         * Dynamically updates roman text field through document listener.
         * Checks if the user is typing in the arabic text field and it isn't blank
         * before executing.
         */
        romanTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent d)
            {
                String text = romanTextField.getText();
                if(!text.equals("") && romanTextFieldFocus)
                {
                    arabicTextField.setText(String.valueOf(RomanToArabic(romanTextField.getText())));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent d)
            {
                String text = romanTextField.getText();
                if(!text.equals("") && romanTextFieldFocus)
                {
                    arabicTextField.setText(String.valueOf(RomanToArabic(romanTextField.getText())));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent d)
            {
                String text = romanTextField.getText();
                if(!text.equals("") && romanTextFieldFocus)
                {
                    arabicTextField.setText(String.valueOf(RomanToArabic(romanTextField.getText())));
                }
            }
        });

    }

    /**
     * Converts an Arabic number to a Roman numeral.
     * Uses an inputted integer and subtracting until the number reaches 0.
     * Special cases use modulo arithmetic. The corresponding Roman numerals
     * after the calculations are then added to a final string to be returned.
     * @param n Integer to be converted to a Roman numeral.
     * @return String of the converted Roman numeral.
     */
        public String ArabicToRoman(int n) {
            String total = "";
            String specialOneDigit = "";
            String specialTenDigit = "";
            String specialHundredDigit = "";
            while (n > 0) {
                if(n%10 == 4)
                {
                    specialOneDigit += "IV";
                    n -= 4;
                }
                else if(n%10 == 9)
                {
                    specialOneDigit += "IX";
                    n -= 9;
                }
                if((n/10)%10 == 4)
                {
                    specialTenDigit += "XL";
                    n -= 40;
                }
                else if((n/10)%10 == 9)
                {
                    specialTenDigit += "XC";
                    n -= 90;
                }
                if((n/100)%10 == 4)
                {
                    specialHundredDigit += "CD";
                    System.out.println("Inside mod 400!");
                    n -= 400;
                    System.out.println("N is now: " + n);
                }
                else if((n/100)%10 == 9)
                {
                    specialHundredDigit += "CM";
                    n -= 900;
                }
                if (n - 1000 >= 0) {
                    total += "M";
                    n -= 1000;
                }
                else if (n - 500 >= 0) {
                    total += "D";
                    n -= 500;
                } else if (n - 100 >= 0) {
                    total += "C";
                    n -= 100;
                } else if (n - 50 >= 0) {
                    total += "L";
                    n -= 50;
                } else if (n - 10 >= 0) {
                    total += "X";
                    n -= 10;
                }
                else if (n - 5 >= 0) {
                    total += "V";
                    n -= 5;
                }
                else if (n - 1 >= 0) {
                    total += "I";
                    n -= 1;
                } else {
                    return specialHundredDigit + total + specialTenDigit + specialOneDigit;
                }
            }
            return specialHundredDigit + total +specialTenDigit + specialOneDigit;
        }

    /**
     * Converts a Roman numeral to an Arabic number.
     * It reads in each correct Roman numeral and adds to a final value to be returned.
     * Special cases like 'IV' are also taken into account.
     * @param s String in the form of a Roman numeral to be converted to an Arabic number.
     * @return String of the converted Roman numeral.
     */
        public int RomanToArabic(String s)
        {
            char sCharArray[] = s.toCharArray();
            int total = 0;
            for(int i = 0; i < sCharArray.length; i++)
            {
                if(sCharArray[i] == 'M')
                {
                    total += 1000;
                }
                else if(sCharArray[i] == 'D')
                {
                    total += 500;
                }
                else if(sCharArray[i] == 'C')
                {
                    if(i != sCharArray.length-1 && sCharArray[i+1] == 'D')
                    {
                        total += 400;
                        i++;
                    }
                    else if(i != sCharArray.length-1 && sCharArray[i+1] == 'M')
                    {
                        total += 900;
                        i++;
                    }
                    else
                    {
                        total += 100;
                    }
                }
                else if(sCharArray[i] == 'L')
                {
                    total += 50;
                }
                else if(sCharArray[i] == 'X')
                {
                    if(i != sCharArray.length-1 && sCharArray[i+1] == 'L')
                    {
                        total += 40;
                        i++;
                    }
                    else if(i != sCharArray.length-1 && sCharArray[i+1] == 'C')
                    {
                        total += 90;
                        i++;
                    }
                    else
                    {
                        total += 10;
                    }
                }
                else if(i != sCharArray.length-1 && sCharArray[i] == 'V')
                {
                    total += 5;
                }
                else if(sCharArray[i] == 'I')
                {
                    if(i != sCharArray.length-1 && sCharArray[i+1] == 'V')
                    {
                        total += 4;
                        i++;
                    }
                    else if(i != sCharArray.length-1 && sCharArray[i+1] == 'X')
                    {
                        total += 9;
                        i++;
                    }
                    else
                    {
                        total += 1;
                    }
                }
            }
            return total;
        }
    }

